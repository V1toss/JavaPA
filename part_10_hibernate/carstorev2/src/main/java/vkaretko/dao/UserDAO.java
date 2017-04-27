package vkaretko.dao;

import vkaretko.models.User;

import java.util.Collections;
import java.util.List;

/**
 * User DAO class.
 *
 * @author Karetko Victor.
 * @version 1.00.
 * @since 24.04.2017.
 */
public class UserDAO extends AbstractDAO<User>{

    private static final UserDAO INSTANCE = new UserDAO();

    public static UserDAO getInstance() {
        return INSTANCE;
    }

}
