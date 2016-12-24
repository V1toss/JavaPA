package vkaretko;

import org.junit.Test;

import java.util.Calendar;
import java.util.Map;
import java.util.HashMap;
import java.util.GregorianCalendar;

/**
 * Test class for map tasks with class User.
 * @author Karetko Victor
 * @version 1.00
 * @since 24.12.2016
 */
public class UserTest {
    /**
     * Calendar for tests.
     */
    private final Calendar calend = new GregorianCalendar(20, 12, 16);
    /**
     * Test-method to see result when adding users without overriding hashCode and equals.
     */
    @Test
    public void whenHashAndEqualsAreNotOverridedThen() {
        Map<User, Object> users = new HashMap<>();
        User userOne = new User("Vasya", 1, calend);
        User userTwo = new User("Vasya", 1, calend);
        users.put(userOne, "1");
        users.put(userTwo, "1");
        System.out.println(users);
    }
    /**
     * Test-method to see result when adding users with overrided hashCode and without equals.
     */
    @Test
    public void whenHashOverridedAndEqualsNotThen() {
        Map<User, Object> users = new HashMap<>();
        User userOne = new UserHash("Vasya", 1, calend);
        User userTwo = new UserHash("Vasya", 1, calend);
        users.put(userOne, "1");
        users.put(userTwo, "1");
        System.out.println((userOne.hashCode()) == userTwo.hashCode());
        System.out.println(users);
    }

    /**
     * Test-method to see result when adding users with overrided equals and without hashcode.
     */
    @Test
    public void whenEqualsOverridedAndHashNotThen() {
        Map<User, Object> users = new HashMap<>();
        User userOne = new UserEquals("Vasya", 1, calend);
        User userTwo = new UserEquals("Vasya", 1, calend);
        users.put(userOne, "1");
        users.put(userTwo, "1");
        System.out.println(userOne.equals(userTwo));
        System.out.println(users);
    }

    /**
     * Test-method to see result when adding users with overrided equals and without hashcode.
     */
    @Test
    public void whenEqualsAndHashOverridedThen() {
        Map<User, Object> users = new HashMap<>();
        User userOne = new UserEqualsHash("Vasya", 1, calend);
        User userTwo = new UserEqualsHash("Vasya", 1, calend);
        users.put(userOne, "1");
        users.put(userTwo, "1");
        System.out.println(users);
    }

}