package vkaretko.interfaces;

import vkaretko.models.User;

/**
 * Interface Storage for managing users.
 * Created by vitoss.
 *
 * @author Karetko Victor.
 * @version 1.00.
 * @since 06.05.17 12:53.
 */
public interface Storage {
    /**
     * Add user to storage.
     * @param user user to add.
     */
    void add(User user);

    /**
     * Get user from storage.
     * @param id id of user to get.
     * @return user.
     */
    User get(int id);
}
