package vkaretko;

import org.junit.Before;
import org.junit.Test;

import java.util.Iterator;
import java.util.NoSuchElementException;

import static org.hamcrest.core.Is.is;
import static org.junit.Assert.assertThat;

/**
 * Test class for MyLinkedList.
 * @author Karetko Victor
 * @version 1.00
 * @since 20.12.2016
 */
public class MyLinkedListTest {
    /**
     * MyLinked list for tests.
     */
    private MyLinkedList list;

    /**
     * Create MyLinkedList.
     */
    @Before
    public void prepareMyLinkedList() {
        this.list = new MyLinkedList();
    }

    /**
     * Check get method.
     */
    @Test
    public void whenAddThreeElementThenFirstElementIsOne() {
        list.add(0);
        list.add(1);
        list.add(2);
        assertThat(list.get(1), is(1));
    }

    /**
     * Check get method with search from end of list.
     */
    @Test
    public void whenAddThreeElementThenSecondElementIsTwo() {
        list.add(0);
        list.add(1);
        list.add(2);
        assertThat(list.get(2), is(2));
    }
    /**
     * Check get method with search from end of list.
     */
    @Test
    public void whenAddOneElementThenCallOfSecondElementThrowException() {
        list.add(0);
        try {
            list.get(1);
        } catch (IndexOutOfBoundsException ioobe) {
            assertThat(ioobe.getMessage(), is("No element with such index"));
        }
    }
    /**
     * Check size method.
     */
    @Test
    public void whenAddThreeElementsThenSizeThree() {
        final int expectedListLength = 3;
        list.add("0");
        list.add("1");
        list.add("2");
        assertThat(list.size(), is(expectedListLength));
    }

    /**
     * Test for hasNext method for MyLinkedList with false result.
     */
    @Test
    public void whenHasNextInEmptyListThenResultFalse() {
        Iterator itr = list.iterator();
        assertThat(itr.hasNext(), is(false));
    }

    /**
     * Test for hasNext method for MyLinkedList with true result.
     */
    @Test
    public void whenHasNextThenResultTrue() {
        list.add(0);
        Iterator itr = list.iterator();
        assertThat(itr.hasNext(), is(true));
    }

    /**
     * Method checks next method for MyArrayList.
     */
    @Test
    public void whenIteratorNextTwoTimesThenResultSecondElement() {
        list.add(1);
        list.add(2);
        Iterator itr = list.iterator();
        itr.next();
        assertThat(itr.next(), is(2));
    }

    /**
     * Method checks next method for MyArrayList.
     */
    @Test
    public void whenNextInEmptyListThenResultException() {
        Iterator itr = list.iterator();
        try {
            itr.next();
        } catch (NoSuchElementException nsee) {
            assertThat(nsee.getMessage(), is("No more elements in list"));
        }
    }

}