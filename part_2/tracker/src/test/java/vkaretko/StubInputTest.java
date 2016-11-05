package vkaretko;

import org.junit.Test;
import vkaretko.Models.Item;
import vkaretko.Start.*;

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
    @Test
    public void whenUserAddNewItemThenResultAddedItemInTracker() {
        Tracker tracker = new Tracker();
        Input input = new StubInput(new String[]{"0", "name", "desc", "y"});
        new StartUI(input, tracker).init();
        assertThat(tracker.getAll()[0].getName(), is ("name"));
        assertThat(tracker.getAll()[0].getDescription(), is ("desc"));
    }

    @Test
    public void whenUserEditItemThenResultEditedItemInTracker() {
        Tracker tracker = new Tracker();
        tracker.add(new Item("name","desc", 123L));
        Input input = new StubInput(new String[]{"2", tracker.getAll()[0].getId(), "name2", "desc2", "y"});
        new StartUI(input, tracker).init();
        assertThat(tracker.getAll()[0].getName(), is ("name2"));
        assertThat(tracker.getAll()[0].getDescription(), is ("desc2"));
    }

    @Test
    public void whenUserDeleteFirstItemThenResultOnlySecondItemInTracker() {
        Tracker tracker = new Tracker();
        tracker.add(new Item("name","desc", 123L));
        tracker.add(new Item("name2","desc2", 1234L));
        Input input = new StubInput(new String[]{"3", tracker.getAll()[0].getId(), "y"});
        new StartUI(input, tracker).init();
        assertThat(tracker.getAll()[0].getName(), is ("name2"));
        assertThat(tracker.getAll()[0].getDescription(), is ("desc2"));
    }

    @Test
    public void whenUserFindItemByIdThenResultItemWIthThatId() {
        Tracker tracker = new Tracker();
        Item itemToFind = new Item("name","desc", 123L);
        Item itemOther = new Item("name2","desc2", 1234L);
        tracker.add(itemToFind);
        tracker.add(itemOther);
        String id = itemToFind.getId();
        Input input = new StubInput(new String[]{"4", id, "y"});
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
        Input input = new StubInput(new String[]{"5", "name", "y"});
        new StartUI(input, tracker).init();
        assertThat(itemToFind.getName(), is ("name"));
        assertThat(itemToFind.getDescription(), is ("desc"));
    }

    @Test
    public void whenUserAddCommentThenResultItemWIthThatComment() {
        Tracker tracker = new Tracker();
        Item item = new Item("name","desc", 123L);
        tracker.add(item);
        Input input = new StubInput(new String[]{"5", "name", "y"});
        new StartUI(input, tracker).init();
        assertThat(item.getName(), is ("name"));
        assertThat(item.getDescription(), is ("desc"));
    }
}
