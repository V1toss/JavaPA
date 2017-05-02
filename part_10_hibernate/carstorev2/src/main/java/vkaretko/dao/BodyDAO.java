package vkaretko.dao;

import vkaretko.models.Body;

/**
 * Body DAO class.
 *
 * @author Karetko Victor.
 * @version 1.00.
 * @since 24.04.2017.
 */
public class BodyDAO extends AbstractDAO<Body> {

    /**
     * Dao instance.
     */
    private static final BodyDAO INSTANCE = new BodyDAO();

    /**
     * Getter for instance.
     * @return instance.
     */
    public static BodyDAO getInstance() {
        return INSTANCE;
    }

}
