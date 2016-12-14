package vkaretko;

import org.junit.Test;

import static org.hamcrest.core.Is.is;
import static org.junit.Assert.assertThat;

/**
 * Class for testing PrimeNumberIterator.
 *
 * @author Karetko Victor
 * @version 1.00
 * @since 14.12.2016
 */
public class PrimeNumberIteratorTest {
    /**
     * Array for tests.
     */
    private final int[] testArray = {1, 2, 4, 5, 7, 8};

    /**
     * Test-method for hasNext method of PrimeNumberIterator.
     */
    @Test
    public void wheIterateTwoTimeArrayThenResultHasNextIsTrueForThirdNumber() {
        PrimeNumberIterator primeIt = new PrimeNumberIterator(testArray);

        primeIt.next();
        primeIt.next();
        boolean result = primeIt.hasNext();

        assertThat(result, is(true));
    }

    /**
     * Test-method for hasNext method of PrimeNumberIterator with false result.
     */
    @Test
    public void wheIterateThreeTimeArrayThenResultHasNextIsFalse() {
        PrimeNumberIterator primeIt = new PrimeNumberIterator(testArray);

        primeIt.next();
        primeIt.next();
        primeIt.next();
        boolean result = primeIt.hasNext();

        assertThat(result, is(false));
    }

    /**
     * Test-method for next method of PrimeNumberIterator.
     */
    @Test
    public void wheIterateTwoTimeArrayThenResultSecondPrimeNumber() {
        PrimeNumberIterator primeIt = new PrimeNumberIterator(testArray);
        final int expectedNumber = 5;

        primeIt.next();
        int result = (Integer) primeIt.next();

        assertThat(result, is(expectedNumber));
    }

}