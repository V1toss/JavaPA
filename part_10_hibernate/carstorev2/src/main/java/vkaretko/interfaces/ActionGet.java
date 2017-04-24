package vkaretko.interfaces;

import org.hibernate.Session;

import java.util.List;

/**
 * Interface ActionGet.
 *
 * @author Karetko Victor.
 * @version 1.00.
 * @since 24.04.2017.
 */
public interface ActionGet<T> {
    /**
     * Execute action with get.
     * @param session session from factory.
     */
     List<T> executeGet(Session session);
}
