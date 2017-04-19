package vkaretko.service;

import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * Hibernate Session Factory service.
 *
 * @author Karetko Victor.
 * @version 1.00.
 * @since 19.04.2017.
 */
public class HibernateUtil {
    /**
     * Logger.
     */
    private static final Logger LOG = LoggerFactory.getLogger(HibernateUtil.class);

    /**
     * Session factory for hibernate.
     */
    private static SessionFactory factory;

    /**
     * Get session factory. If factory is null init new session factory.
     * @return session factory.
     */
    public static SessionFactory getFactory() {
        if (factory == null) {
            try {
                factory = new Configuration().configure().buildSessionFactory();
            } catch (Throwable ex) {
                LOG.error("SessionFactory creation error", ex);
                throw new ExceptionInInitializerError(ex);
            }

        }
        return factory;
    }

    /**
     * Close session factory.
     */
    public void closeFactory() {
        factory.close();
    }


}
