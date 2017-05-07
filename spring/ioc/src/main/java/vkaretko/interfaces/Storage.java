package vkaretko.interfaces;

import vkaretko.models.User;

import java.util.List;

/**
 * Class Storage.
 * Description TODO.
 * Created by vitoss.
 *
 * @author Karetko Victor.
 * @version 1.00.
 * @since 06.05.17 12:53.
 */
public interface Storage {
    void add(User user);

    User get(int id);

    void remove(User user);

    List<User> getAll();

    void update(User user);
}
