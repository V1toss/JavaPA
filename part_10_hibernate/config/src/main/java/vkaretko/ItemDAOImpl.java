package vkaretko;

import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.Transaction;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import vkaretko.interfaces.AbstractItemDAO;
import vkaretko.interfaces.Action;
import vkaretko.models.Item;
import vkaretko.service.HibernateUtil;

import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.List;

/**
 * Class DBManager. Providing CRUD operations for items through hibernate.
 *
 * @author Karetko Victor.
 * @version 1.00.
 * @since 19.04.2017.
 */
public class ItemDAOImpl implements AbstractItemDAO {
    /**
     * Logger.
     */
    private static final Logger LOG = LoggerFactory.getLogger(ItemDAOImpl.class);

    /**
     * Static INSTANCE for Singleton realisation.
     */
    private static final ItemDAOImpl INSTANCE = new ItemDAOImpl();

    /**
     * Private constructor for DBManager singleton realization.
     */
    private ItemDAOImpl() {
    }

    /**
     * Getter for DBManager instance.
     * @return instance.
     */
    public static ItemDAOImpl getInstance() {
        return INSTANCE;
    }

    /**
     * Template method for CRUD operations.
     * @param action action.
     */
    private void tx(Action action) {
        Transaction transaction = null;
        try (Session session = HibernateUtil.getFactory().openSession()) {
            transaction = session.beginTransaction();
            action.execute(session);
            transaction.commit();
        } catch (HibernateException he) {
            LOG.error(he.getMessage(), he);
            if (transaction != null) {
                transaction.rollback();
            }
        }
    }

    /**
     * Add item in database.
     * @param desc description of item.
     */
    @Override
    public void addItem(String desc) {
        tx(s -> {
            Item item = new Item();
            item.setDesc(desc);
            item.setCreated(new Timestamp(System.currentTimeMillis()));
            s.save(item);
        });
    }

    /**
     * Update item status in db by id.
     * @param isDone status of item.
     * @param id id of item.
     */
    @Override
    public void updateStatus(int id, boolean isDone) {
        tx(s -> {
            Item item = s.get(Item.class, id);
            item.setDone(isDone);
            s.update(item);
        });
    }

    /**
     * Delete item from db.
     * @param id of item.
     */
    @Override
    public void deleteItem(int id) {
        tx(s -> {
            Item item = new Item();
            item.setId(id);
            s.delete(item);
        });
    }

    /**
     * Get all items from DB.
     * @param isDone flag for filtering by item status.
     * @return list of items.
     */
    @Override
    @SuppressWarnings("unchecked")
    public List<Item> getAllItems(boolean isDone) {
        Transaction transaction = null;
        List<Item> items = new ArrayList<>();
        try (Session session = HibernateUtil.getFactory().openSession()) {
            transaction = session.beginTransaction();
            items = !isDone ? session.createQuery("from Item").list()
                    : session.createQuery("from Item where done = true").list();
            transaction.commit();
        } catch (HibernateException he) {
            LOG.error(he.getMessage(), he);
            if (transaction != null) {
                transaction.rollback();
            }
        }
        return items;
    }
}
