package vkaretko;

import org.junit.Before;
import org.junit.Test;

import static org.hamcrest.core.Is.is;
import static org.junit.Assert.assertThat;

/**
 * Test class for MyStackList.
 * @author Karetko Victor
 * @version 1.00
 * @since 22.12.2016
 */
public class MyQueueListTest {
    /**
     * MyLinked list for tests.
     */
    private MyQueueList list;

    /**
     * Create MyLinkedList.
     */
    @Before
    public void prepareMyStackList() {
        this.list = new MyQueueList();
        list.offer(1);
        list.offer(2);
    }

    /**
     * Test for peek method.
     */
    @Test
    public void whenPeekThanResultFirstElement() {
        assertThat(list.peek(), is(1));
    }

    /**
     * Test for pop method.
     */
    @Test
    public void whenPollThenResultFirstElement() {
        assertThat(list.poll(), is(1));
    }

    /**
     * Test for poll method with check size.
     */
    @Test
    public void whenPollThenSizeIsOne() {
        list.poll();
        assertThat(list.size(), is(1));
    }

    /**
     * Test for push method.
     */
    @Test
    public void whenOfferThenPeekReturnFirstElement() {
        list.offer(0);
        assertThat(list.peek(), is(1));
    }
}