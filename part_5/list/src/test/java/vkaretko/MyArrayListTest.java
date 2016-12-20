package vkaretko;

import org.junit.Test;

import java.util.Iterator;
import java.util.NoSuchElementException;

import static org.hamcrest.core.Is.is;
import static org.junit.Assert.assertThat;

/**
 * Test class for MyArrayList.
 * @author Karetko Victor
 * @version 1.00
 * @since 20.12.2016
 */
public class MyArrayListTest {
    /**
     * Method checks get method.
     */
    @Test
    public void whenAddThreeElementThenFirstElementIsOne() {
        MyArrayList list = new MyArrayList();
        list.add(0);
        list.add(1);
        list.add(2);
        assertThat(list.get(1), is(1));
    }

    /**
     * Method tests ensureCapacity of MyArrayList.
     */
    @Test
    public void whenCreateArrayWithSizeTwoAndAddThreeElementsThenSizeThree() {
        MyArrayList list = new MyArrayList(2);
        final int expectedListLength = 3;
        list.add("0");
        list.add("1");
        list.add("2");
        assertThat(list.length(), is(expectedListLength));
    }

    /**
     * Method checks hasNext method for MyArrayList with false result.
     */
    @Test
    public void whenHasNextInEmptyArrayListThenResultFalse() {
        MyArrayList list = new MyArrayList(2);
        Iterator itr = list.iterator();
        assertThat(itr.hasNext(), is(false));
    }

    /**
     * Method checks hasNext method for MyArrayList with true result.
     */
    @Test
    public void whenHasNextThenResultTrue() {
        MyArrayList list = new MyArrayList();
        list.add(0);
        Iterator itr = list.iterator();
        assertThat(itr.hasNext(), is(true));
    }


    /**
     * Method checks next method for MyArrayList.
     */
    @Test
    public void whenNextTwoTimesThenResultSecondElement() {
        MyArrayList list = new MyArrayList(2);
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
        MyArrayList list = new MyArrayList(2);
        Iterator itr = list.iterator();
        try {
            itr.next();
        } catch (NoSuchElementException nsee) {
            assertThat(nsee.getMessage(), is("No more elements in list"));
        }
    }
}