package vkaretko;

import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.Transaction;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import vkaretko.models.Item;
import vkaretko.service.HibernateUtil;

import java.util.ArrayList;
import java.util.List;

/**
 * Class DBManager. Providing CRUD operations for items through hibernate.
 *
 * @author Karetko Victor.
 * @version 1.00.
 * @since 19.04.2017.
 */
public class ItemDBManager {
    /**
     * Logger.
     */
    private static final Logger LOG = LoggerFactory.getLogger(ItemDBManager.class);

    /**
     * Static INSTANCE for Singleton realisation.
     */
    private static final ItemDBManager INSTANCE = new ItemDBManager();

    /**
     * Private constructor for DBManager singleton realization.
     */
    private ItemDBManager() {
    }

    /**
     * Getter for DBManager instance.
     * @return instance.
     */
    public static ItemDBManager getInstance() {
        return INSTANCE;
    }

    /**
     * Add item in database.
     * @param item item to update.
     */
    public void addItem(Item item) {
        Transaction transaction = null;
        try (Session session = HibernateUtil.getFactory().openSession()) {
            transaction = session.beginTransaction();
            session.saveOrUpdate(item);
            transaction.commit();
        } catch (HibernateException he) {
            LOG.error(he.getMessage(), he);
            if (transaction != null) {
                transaction.rollback();
            }
        }
    }

    /**
     * Get all items from DB.
     * @param isDone flag for filtering by item status.
     * @return list of items.
     */
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
