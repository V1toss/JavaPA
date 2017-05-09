package vkaretko.repository;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.orm.hibernate4.HibernateTemplate;
import org.springframework.stereotype.Repository;


import java.lang.reflect.ParameterizedType;
import java.util.List;

/**
 * Abstract item dao interface.
 *
 * @author Karetko Victor.
 * @version 1.00.
 * @since 08.05.2017.
 * @param <T> parametrized type.
 */
@Repository
public abstract class AbstractDAO<T> {
    /**
     * Logger.
     */
    private static final Logger LOG = LoggerFactory.getLogger(AbstractDAO.class);

    /**
     * Hibernate template.
     */
    private HibernateTemplate template;

    @Autowired
    public void setTemplate(HibernateTemplate template) {
        this.template = template;
    }

    /**
     * Get class using reglection.
     */
    @SuppressWarnings("unchecked")
    private Class<T> persistentClass = (Class<T>) ((ParameterizedType) getClass().getGenericSuperclass()).getActualTypeArguments()[0];

    /**
     * Delete entry from db.
     * @param t entry to delete.
     */
    public void delete(T t) {
        this.template.delete(t);
    }

    /**
     * Update entry in db.
     * @param t entry to update.
     */
    public void update(T t) {
        this.template.update(t);
    }

    /**
     * Update entry in db.
     * @param t entry to update.
     */
    public void save(T t) {
        this.template.save(t);
    }

    /**
     * Get entry from db by id.
     * @param id if of entry to get.
     * @return T object.
     */
    public T get(int id) {
        return this.template.get(persistentClass, id);
    }

    /**
     * Get list of entries from database.
     * @return list of entries.
     */
    @SuppressWarnings("unchecked")
    public List<T> getAll() {
        return (List<T>) this.template.loadAll(persistentClass);
    }
}
