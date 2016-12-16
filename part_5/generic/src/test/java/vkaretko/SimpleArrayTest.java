package vkaretko;

import org.junit.Before;
import org.junit.Test;

import static org.hamcrest.core.Is.is;
import static org.junit.Assert.assertThat;

/**
 * Test-class for SimpleArray.
 *
 * @author Karetko Victor
 * @version 1.00
 * @since 16.12.2016
 */
public class SimpleArrayTest {
    /**
     * Array for tests.
     */
    private SimpleArray arr;

    /**
     * Prepare SimpleArray for tests.
     */
    @Before
    public void prepareArrayForTests() {
        final int arraySize = 10;
        this.arr = new SimpleArray(arraySize);
        this.arr.add(0);
        this.arr.add(1);
        this.arr.add(2);
    }

    /**
     * Method checks get method.
     */
    @Test
    public void whenGetFirstElementThenResultOne() {
        assertThat(this.arr.get(1), is(1));
    }

    /**
     * Method checks update method.
     */
    @Test
    public void whenUpdateZeroElementThenResultTwo() {
        this.arr.update(0, 2);
        assertThat(this.arr.get(0), is(2));
    }

    /**
     * Method checks delete method.
     */
    @Test
    public void whenDeleteFirstElementThenFirstElementBecomeTwo() {
        this.arr.delete(1);
        assertThat(this.arr.get(1), is(2));
    }

}