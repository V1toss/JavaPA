package vkaretko.handbook;

import org.junit.Before;
import org.junit.Test;

import java.util.Iterator;

import static org.hamcrest.core.Is.is;
import static org.junit.Assert.assertThat;

/**
 * Test class for HandBook.
 * @author Karetko Victor
 * @version 1.00
 * @since 24.12.2016
 */
public class HandBookTest {
    /**
     * Map for tests.
     */
    private HandBook handBook = new HandBook();

    /**
     * Fill map with pairs kay values.
     */
    @Before
    public void fillMap() {
        handBook.insert("11", "111");
        handBook.insert("22", "222");
        handBook.insert("33", "333");
    }

    /**
     * Test for get-size method.
     */
    @Test
    public void whenAddFourthElementThenSizeIsFour() {
        final int expectedSize = 4;
        handBook.insert("23", "2323");
        assertThat(handBook.getSize(), is(expectedSize));
    }

    /**
     * Test for get method.
     */
    @Test
    public void whenGetByKeyThenResultValueOfEntry() {
        assertThat(handBook.get("22"), is("222"));
    }

    /**
     * Test for inserting same element.
     */
    @Test
    public void whenAddSameElementThanSameSize() {
        final int size = handBook.getSize();
        handBook.insert("22", "222");
        assertThat(handBook.getSize(), is(size));
    }

    /**
     * Method test delete method.
     */
    @Test
    public void whenDeleteElementThenSizeTwo() {
        handBook.delete("22");
        assertThat(handBook.getSize(), is(2));
    }

    /**
     * Method tests iterator next method.
     */
    @Test
    public void whenIteratorNextThenResultValue() {
        handBook.delete("11");
        handBook.delete("33");
        Iterator iter = handBook.iterator();
        assertThat(iter.next().toString(), is("Key: 22 Value: 222"));
    }

    /**
     * Method tests iterator hasNext method.
     */
    @Test
    public void whenIteratorNextTwiceThenHasNextTrue() {
        Iterator iter = handBook.iterator();
        iter.next();
        iter.next();
        assertThat(iter.hasNext(), is(true));
    }

}