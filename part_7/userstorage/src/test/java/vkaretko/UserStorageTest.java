package vkaretko;

import org.junit.Before;
import org.junit.Test;

import static org.hamcrest.core.Is.is;
import static org.junit.Assert.assertThat;
import static org.junit.Assert.assertNull;

/**
 * Test class for User Storage.
 *
 * @author Karetko Victor.
 * @version 1.00.
 * @since 22.01.2017.
 */
public class UserStorageTest {

    /**
     * User storage.
     */
    private UserStorage stor;

    /**
     * Prepare user storage.
     */
    @Before
    public void prepareStorage() {
        this.stor = new UserStorage();
        User user = new User("Test", 100);
        User userTwo = new User("Test", 100);
        stor.add(user);
        stor.add(userTwo);
    }

    /**
     * Test delete method.
     */
    @Test
    public void whenDeleteUserWithIdOneThenResultNoUserInStorage() {
        stor.delete(1);
        assertNull(stor.read(1));
    }

    /**
     * Test update method.
     */
    @Test
    public void whenUpdateUserThenUserWithNewAmount() {
        User updUser = new User("Test2", 100);
        stor.update(1, updUser);
        assertThat(stor.read(1).getName(), is("Test2"));
    }

    /**
     * Test transfer money.
     */
    @Test
    public void whenTransferMoneyFromOneUserTwoSecondThenSecondUserHasMoreMoney() {
        stor.transferMoney(30, 0, 1);
        assertThat(stor.read(1).getAmount(), is(130));
    }

    /**
     * Test transfer money.
     */
    @Test
    public void whenTransferMoneyFromOneUserTwoSecondThenFirstUserHasLessMoney() {
        stor.transferMoney(30, 0, 1);
        assertThat(stor.read(0).getAmount(), is(70));
    }

}