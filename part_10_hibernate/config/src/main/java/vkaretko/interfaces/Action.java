package vkaretko.interfaces;

import org.hibernate.Session;

/**
 * Interface Action.
 *
 * @author Karetko Victor.
 * @version 1.00.
 * @since 22.04.2017.
 */
public interface Action {

    /**
     * Execute action.
     * @param session session from factory.
     */
    void execute(Session session);
}
