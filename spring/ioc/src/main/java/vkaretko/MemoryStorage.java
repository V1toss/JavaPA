package vkaretko;

import org.springframework.stereotype.Component;
import vkaretko.interfaces.Storage;
import vkaretko.models.User;

import java.util.ArrayList;
import java.util.List;

/**
 * Class MemoryStorage.
 * Description TODO.
 * Created by vitoss.
 *
 * @author Karetko Victor.
 * @version 1.00.
 * @since 06.05.17 12:56.
 */
public class MemoryStorage implements Storage {

    private List<User> storage = new ArrayList<>();

    @Override
    public void add(User user) {
        this.storage.add(user);
    }

    @Override
    public User get(int id) {
        User result = null;
        for (User user : this.storage) {
            if (user != null && user.getId() == id) {
                result = user;
                break;
            }
        }
        return result;
    }
}
