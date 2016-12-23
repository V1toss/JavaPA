package vkaretko;

import org.junit.Test;
import org.junit.Before;

import java.util.Iterator;
import java.util.LinkedList;

import static org.hamcrest.core.Is.is;
import static org.junit.Assert.assertThat;

/**
 * Test class for MySet.
 * @author Karetko Victor
 * @version 1.00
 * @since 23.12.2016
 */
public class MySetTest {
    /**
     * MySet for tests.
     */
    private MySet arraySet;
    /**
     * MySet for tests.
     */
    private MySet linkedSet;

    /**
     * Create Sets based on array and linked list.
     */
    @Before
    public void prepareMyQueueList() {
        this.arraySet = new MySet();
        this.linkedSet = new MySet(new LinkedList());
    }

    /**
     * Test checks that same elements are not adding to set.
     */
    @Test
    public void whenAddThreeSameElementsThenSizeOne() {
        arraySet.add("1");
        arraySet.add("1");
        arraySet.add("1");
        assertThat(arraySet.size(), is(1));
    }

    /**
     * Test checks that same elements are not adding to set with more complex mixed adding.
     */
    @Test
    public void whenAddSixElementsThenSizeThree() {
        final int expectedSize = 5;
        for (int index = 0; index < expectedSize; index++) {
            arraySet.add(index);
        }
        arraySet.add(2);
        for (int index = expectedSize - 1; index > 0; index--) {
            arraySet.add(index);
        }
        arraySet.add(1);
        assertThat(arraySet.size(), is(expectedSize));
    }

    /**
     * Method checks next method of iterator.
     */
    @Test
    public void whenNextThenResultFirstElement() {
        linkedSet.add(1);
        linkedSet.add(2);
        Iterator itr = linkedSet.iterator();
        assertThat(itr.next(), is(1));
    }

    /**
     * Method checks sort by hash in set.
     */
    @Test
    public void whenAddTwoElementsThenSecondElementWithHigherHashCode() {
        linkedSet.add(2);
        linkedSet.add(1);
        Iterator itr = linkedSet.iterator();
        itr.next();
        assertThat(itr.next(), is(2));
    }

    /**
     * Method checks hasNext method of iterator with true result.
     */
    @Test
    public void whenNextTwoTimesThenHasNextFalse() {
        linkedSet.add(2);
        linkedSet.add(1);
        Iterator itr = linkedSet.iterator();
        itr.next();
        itr.next();
        assertThat(itr.hasNext(), is(false));
    }

}