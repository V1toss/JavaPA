package vkaretko;

import org.junit.Before;
import org.junit.Test;

import java.util.Iterator;
import java.util.ArrayList;
import java.util.List;
import java.util.Arrays;
import java.util.NoSuchElementException;

import static org.hamcrest.core.Is.is;
import static org.junit.Assert.assertThat;

/**
 * Class ConverterIteratorTest for testing ConverterIterator.
 *
 * @author Karetko Victor
 * @version 1.00
 * @since 15.12.2016
 */
public class ConverterIteratorTest {
    /**
     * Iterator throw iterators.
     */
    private Iterator<Integer> convertedIterator;

    /**
     * Method prepare iterators before tests.
     */
    @Before
    public void prepareIteratorsForTests() {
        final List<Integer> listOne = new ArrayList<>(Arrays.asList(1, 2, 3));
        final List<Integer> listTwo = new ArrayList<>(Arrays.asList(4, 5, 6));
        List<Iterator<Integer>> listIter = new ArrayList<>(Arrays.asList(listOne.iterator(), listTwo.iterator()));
        ConverterIterator converter = new ConverterIterator();
        this.convertedIterator = converter.convert(listIter.iterator());
    }

    /**
     * Method checks hasNext method.
     */
    @Test
    public void whenHasNextThenResultTrue() {
        boolean result = convertedIterator.hasNext();
        assertThat(result, is(true));
    }

    /**
     * Method checks iterating throw first iterator into second iterator.
     */
    @Test
    public void whenNextFourTimesThenResultFour() {
        final Integer expected = 4;
        convertedIterator.next();
        convertedIterator.next();
        convertedIterator.next();
        Integer result = convertedIterator.next();
        assertThat(result, is(expected));
    }

    /**
     * Method checks hasNext method at the end of last iterator.
     */
    @Test
    public void whenIterateSixTimesThenHasNextFalse() {
        final int countIter = 6;
        for (int iter = 0; iter < countIter; iter++) {
            convertedIterator.next();
        }
        boolean result = convertedIterator.hasNext();
        assertThat(result, is(false));
    }

    /**
     * Method checks that method next throws exceptions.
     */
    @Test
    public void whenIterateSixTimesThenNextThrowException() {
        final int countIter = 6;
        for (int iter = 0; iter < countIter; iter++) {
            convertedIterator.next();
        }

        try {
            convertedIterator.next();
        } catch (NoSuchElementException nee) {
            assertThat(nee.getMessage(), is("No numbers in iterators."));
        }
    }

}