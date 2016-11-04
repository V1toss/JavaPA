package vkaretko;

import org.junit.Test;
import vkaretko.Models.*;
import vkaretko.Start.Tracker;

import static org.hamcrest.core.Is.is;
import static org.junit.Assert.assertThat;

/**
 * Test-class for Tracker class
 *
 * @author Karetko Victor
 * @version 1.00
 * @since 04.11.2016
 */
public class TrackerTest {
    @Test
    public void whenAddedNewItemThenResultArrayWithSameItem() {
        Tracker tracker = new Tracker();
        Item[] testItemArray = new Item[1];
        Item item = new Task("test1","testDescription",123L);
        testItemArray[0] = item;
        tracker.add(item);
        assertThat(tracker.getAll(), is(testItemArray));
    }

    @Test
    public void whenAddTaskAndEditToBugThenResultArrayWithBug() {
        Tracker tracker = new Tracker();
        Item[] testItemArray = new Item[1];
        Item itemTask = new Task("test1","testDescription",123L);
        Item itemBug = new Bug("test2","testDescription2",1234L);
        tracker.add(itemTask);
        tracker.edit(itemTask,itemBug);
        testItemArray[0] = itemBug;
        assertThat(tracker.getAll(), is(testItemArray));
    }

    @Test
    public void whenAddTwoTasksAndDeleteFirstTaskThenResultArrayWithSecondTask() {
        Tracker tracker = new Tracker();
        Item[] testItemArray = new Item[2];
        Item itemFirst = new Task("test1","testDescription",123L);
        Item itemSecond = new Task("test2","testDescription2",1234L);
        tracker.add(itemFirst);
        tracker.add(itemSecond);
        tracker.delete(itemFirst);
        testItemArray[1] = itemSecond;
        assertThat(tracker.getAll(), is(testItemArray));
    }

    @Test
    public void whenAddTwoTasksAndFindByNameThenResultFoundedTask() {
        Tracker tracker = new Tracker();
        Item itemFirst = new Task("test1","testDescription",123L);
        Item itemSecond = new Task("test2","testDescription",123L);
        tracker.add(itemFirst);
        tracker.add(itemSecond);
        assertThat(tracker.findByName(itemSecond.getName()), is(itemSecond));
    }

    @Test
    public void whenAddTwoTasksAndFindByIdThenResultFoundedTask() {
        Tracker tracker = new Tracker();
        Item itemFirst = new Task("test1","testDescription",123L);
        Item itemSecond = new Task("test2","testDescription",123L);
        tracker.add(itemFirst);
        tracker.add(itemSecond);
        assertThat(tracker.findById(itemSecond.getId()), is(itemSecond));
    }

    @Test
    public void whenAddCommentToTaskThenResultArrayOfCommentsWithOneAddedComment() {
        Tracker tracker = new Tracker();
        Item item = new Task("test1","testDescription",123L);
        Comment[] testComments = new Comment[10];
        Comment comment = new Comment("Test comment");
        testComments[0] = comment;
        tracker.add(item);
        tracker.addComment(item, comment);
        assertThat(item.getComments(), is(testComments));
    }

}
