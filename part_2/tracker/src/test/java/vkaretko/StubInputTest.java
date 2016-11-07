package vkaretko;

import org.junit.Test;
import vkaretko.models.Item;
import vkaretko.start.*;

import static org.hamcrest.core.Is.is;
import static org.junit.Assert.assertThat;

/**
 * Part 2. OOP
 * Lesson 3. Polymorphism.
 * Task 2. Implement class, that uses StubInput for jUnit tests.
 * Using the class StubInput to write junit tests that simulate user behavior.
 * Simulate user selecting the menu item. Input, output, and exits the application.
 *
 * @author Karetko Victor
 * @version 1.00
 * @since 05.11.2016
 */
public class StubInputTest {

    private int firstElementOfArray = 0;
    private enum actionKey {ADD, SHOW, EDIT, DELETE, FIND_BY_ID, FIND_BY_NAME, ADD_COMMENT}

    @Test
    public void whenUserAddNewItemThenResultAddedItemInTracker() {
        Tracker tracker = new Tracker();
        Input input = new StubInput(new String[]{String.valueOf(actionKey.ADD.ordinal()), "name", "desc", "y"});
        new StartUI(input, tracker).init();
        assertThat(tracker.getAll()[firstElementOfArray].getName(), is ("name"));
        assertThat(tracker.getAll()[firstElementOfArray].getDescription(), is ("desc"));
    }

    @Test
    public void whenUserEditItemThenResultEditedItemInTracker() {
        Tracker tracker = new Tracker();
        tracker.add(new Item("name","desc", 123L));
        Input input = new StubInput(new String[]{
                String.valueOf(actionKey.EDIT.ordinal()),
                tracker.getAll()[firstElementOfArray].getId(),"name2", "desc2", "y"});
        new StartUI(input, tracker).init();
        assertThat(tracker.getAll()[firstElementOfArray].getName(), is ("name2"));
        assertThat(tracker.getAll()[firstElementOfArray].getDescription(), is ("desc2"));
    }

    @Test
    public void whenUserDeleteFirstItemThenResultOnlySecondItemInTracker() {
        Tracker tracker = new Tracker();
        tracker.add(new Item("name","desc", 123L));
        tracker.add(new Item("name2","desc2", 1234L));
        Input input = new StubInput(new String[]{
                String.valueOf(actionKey.DELETE.ordinal()), tracker.getAll()[firstElementOfArray].getId(), "y"});
        new StartUI(input, tracker).init();
        assertThat(tracker.getAll()[firstElementOfArray].getName(), is ("name2"));
        assertThat(tracker.getAll()[firstElementOfArray].getDescription(), is ("desc2"));
    }

    @Test
    public void whenUserFindItemByIdThenResultItemWIthThatId() {
        Tracker tracker = new Tracker();
        Item itemToFind = new Item("name","desc", 123L);
        Item itemOther = new Item("name2","desc2", 1234L);
        tracker.add(itemToFind);
        tracker.add(itemOther);
        String id = itemToFind.getId();
        Input input = new StubInput(new String[]{String.valueOf(actionKey.FIND_BY_ID.ordinal()), id, "y"});
        new StartUI(input, tracker).init();
        assertThat(itemToFind.getName(), is ("name"));
        assertThat(itemToFind.getDescription(), is ("desc"));
    }

    @Test
    public void whenUserFindItemByNameThenResultItemWIthThatName() {
        Tracker tracker = new Tracker();
        Item itemToFind = new Item("name","desc", 123L);
        Item itemOther = new Item("name2","desc2", 1234L);
        tracker.add(itemToFind);
        tracker.add(itemOther);
        Input input = new StubInput(new String[]{String.valueOf(actionKey.FIND_BY_NAME.ordinal()), "name", "y"});
        new StartUI(input, tracker).init();
        assertThat(itemToFind.getName(), is ("name"));
        assertThat(itemToFind.getDescription(), is ("desc"));
    }

    @Test
    public void whenUserAddCommentThenResultItemWIthThatComment() {
        Tracker tracker = new Tracker();
        Item item = new Item("name","desc", 123L);
        tracker.add(item);
        Input input = new StubInput(new String[]{
                String.valueOf(actionKey.ADD_COMMENT.ordinal()),
                tracker.getAll()[firstElementOfArray].getId(), "test comment", "y"});
        new StartUI(input, tracker).init();
        assertThat(tracker.getAll()[0].getComments()[0].getComment(), is ("test comment"));
    }
}
