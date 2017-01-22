package vkaretko;

import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

/**
 * Class UserStorage.
 *
 * @author Karetko Victor.
 * @version 1.00.
 * @since 15.01.2017.
 */
public class UserStorage {
    /**
     * List of users.
     */
    private Map<Integer, User> users;

    /**
     * Id of user in userstorage.
     */
    private int countId = 0;

    /**
     * COnstructor of class UserStorage.
     */
    public UserStorage() {
        this.users = new ConcurrentHashMap<>();
    }

    /**
     * Method adds users to list.
     * @param user user to add.
     */
    public synchronized void add(User user) {
        users.put(incrementId(), user);
    }

    /**
     * Method increment id while adding new users to storage.
     * @return id for user.
     */
    private synchronized int incrementId() {
        return this.countId++;
    }

    /**
     * Method update user buy id.
     * @param id of user to delete.
     * @return true if update successful? false otherwise.
     */
    public synchronized boolean delete(int id) {
        boolean result = false;
        if (users.containsKey(id)) {
            users.remove(id);
            result = true;
        }
        return result;
    }

    /**
     * Method delete user buy id.
     * @param id id of user.
     * @param user user to update.
     * @return true if update successful? false otherwise.
     */
    public synchronized boolean update(int id, User user) {
        boolean result = false;
        if (users.containsKey(id)) {
            users.put(id, user);
            result = true;
        }
        return result;
    }

    /**
     * Method search user by id.
     * @param id id of user.
     * @return user.
     */
    public User read(Integer id) {
        User result = null;
        if (users.containsKey(id)) {
            result = users.get(id);
        }
        return result;
    }

    /**
     * Method for transferring money from one user to another.
     * @param amount amount of cash.
     * @param userIdSrc - id of first user.
     * @param userIdDst - id of second user.
     * @return true if transfer completed, false otherwise.
     */
    public synchronized boolean transferMoney(int amount, int userIdSrc, int userIdDst) {
        boolean result = false;
        if (users.containsKey(userIdSrc) && users.containsKey(userIdDst)) {
            users.get(userIdSrc).setAmount(users.get(userIdSrc).getAmount() - amount);
            users.get(userIdDst).setAmount(users.get(userIdDst).getAmount() + amount);
            result = true;
        }
        return result;
    }
}
