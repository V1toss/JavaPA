package vkaretko;

import org.junit.Before;
import org.junit.Test;

import static org.hamcrest.core.Is.is;
import static org.junit.Assert.assertThat;

/**
 * Test class for MyQueueList.
 * @author Karetko Victor
 * @version 1.00
 * @since 22.12.2016
 */
public class MyStackListTest {
    /**
     * MyLinked list for tests.
     */
    private MyStackList list;

    /**
     * Create MyLinkedList.
     */
    @Before
    public void prepareMyStackList() {
        this.list = new MyStackList();
        list.push(1);
        list.push(2);
    }

    /**
     * Test for peek method.
     */
    @Test
    public void whenPeekThanResultLastElement() {
        assertThat(list.peek(), is(2));
    }

    /**
     * Test for pop method.
     */
    @Test
    public void whenPopThenResultLastElement() {
        assertThat(list.pop(), is(2));
    }

    /**
     * Test for pop method with check size.
     */
    @Test
    public void whenPopThenSizeIsOne() {
        list.pop();
        assertThat(list.size(), is(1));
    }

    /**
     * Test for push method.
     */
    @Test
    public void whenPushThenPeekReturnPushedElement() {
        list.push(0);
        assertThat(list.peek(), is(0));
    }
}