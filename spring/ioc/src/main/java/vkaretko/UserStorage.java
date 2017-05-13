package vkaretko;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import vkaretko.interfaces.Storage;
import vkaretko.models.User;

import java.util.List;

/**
 * Class UserStorage.
 * Description TODO.
 * Created by vitoss.
 *
 * @author Karetko Victor.
 * @version 1.00.
 * @since 06.05.17 12:53.
 */
public class UserStorage implements Storage {
    private final Storage storage;

    public UserStorage(final Storage storage) {
        this.storage = storage;
    }

    public void add(User user) {
        this.storage.add(user);
    }

    public User get(int id) {
        return this.storage.get(id);
    }
}
