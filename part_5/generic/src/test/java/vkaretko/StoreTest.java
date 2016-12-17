package vkaretko;

import org.junit.Before;
import org.junit.Test;

import java.util.NoSuchElementException;

import static org.hamcrest.core.Is.is;
import static org.junit.Assert.assertThat;

/**
 * Test-class for Store.
 *
 * @author Karetko Victor
 * @version 1.00
 * @since 16.12.2016
 */
public class StoreTest {
    /**
     * BaseStore for tests.
     */
    private UserStore uStore;

    /**
     * BaseStore for tests.
     */
    private RoleStore rStore;

    /**
     * First user for tests.
     */
    private User userOne;
    /**
     * Second user for tests.
     */
    private User userTwo;

    /**
     * Prepare stores for tests.
     */
    @Before
    public void prepareStores() {
        this.uStore = new UserStore();
        this.rStore = new RoleStore();
        this.userOne = new User();
        this.userTwo = new User();
        this.userOne.setId("1234");
        this.userTwo.setId("5678");
        this.uStore.add(userOne);
        this.uStore.add(userTwo);
    }

    /**
     * Method checks get method.
     */
    @Test
    public void whenGetByCorrectIdThenResultUserTwoInStore() {
        assertThat(uStore.get("5678"), is(this.userTwo));
    }

    /**
     * Method checks get method with wrong id.
     */
    @Test
    public void whenGetByWrongIdThenResultException() {
        try {
            uStore.get("5678123");
        } catch (NoSuchElementException nsee) {
            assertThat(nsee.getMessage(), is("No element with such id."));
        }
    }

    /**
     * Method checks update method.
     */
    @Test
    public void whenUpdateUserWithAnotherUserThenResultAnotherUser() {
        User testUser = new User();
        testUser.setId("1111");
        this.uStore.update("1234", testUser);
        assertThat(this.uStore.get("1111"), is(testUser));
    }

    /**
     * Method checks delete method.
     */
    @Test
    public void whenDeleteUserThenNoThisUserInStore() {
        this.uStore.delete("1234");
        try {
            uStore.get("1234");
        } catch (NoSuchElementException nsee) {
            assertThat(nsee.getMessage(), is("No element with such id."));
        }
    }

    /**
     * Method checks add method.
     */
    @Test
    public void whenAddRoleToRoleStoreThenSameRoleInRoleStore() {
        Role role = new Role();
        role.setId("12345");
        rStore.add(role);
        assertThat(rStore.get("12345"), is(role));
    }

}