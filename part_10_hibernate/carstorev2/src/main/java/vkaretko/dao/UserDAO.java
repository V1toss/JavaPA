package vkaretko.dao;

import vkaretko.models.User;

/**
 * User DAO class.
 *
 * @author Karetko Victor.
 * @version 1.00.
 * @since 24.04.2017.
 */
public class UserDAO extends AbstractDAO<User> {

    /**
     * Dao instance.
     */
    private static final UserDAO INSTANCE = new UserDAO();

    /**
     * Getter for instance.
     * @return instance.
     */
    public static UserDAO getInstance() {
        return INSTANCE;
    }

}
