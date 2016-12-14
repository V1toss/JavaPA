package vkaretko;

import org.junit.Test;

import static org.hamcrest.core.Is.is;
import static org.junit.Assert.assertThat;

/**
 * Class for testing EvenIterator.
 *
 * @author Karetko Victor
 * @version 1.00
 * @since 14.12.2016
 */
public class EvenIteratorTest {
    /**
     * Test-method for next method of EvenIterator.
     */
    @Test
    public void wheIterateTwoTimeArrayWithEvenNumbersThenResultSecondEvenNumber() {
        EvenIterator evenIt = new EvenIterator(new int[]{-1, 0, 1, 2});

        evenIt.next();
        int result = (Integer) evenIt.next();

        assertThat(result, is(2));
    }

    /**
     * Test-method for hasNext method of EvenIterator.
     */
    @Test
    public void wheIterateArrayWithTwoEvenNumbersThenHasNextIsTrueForSecondNumber() {
        EvenIterator evenIt = new EvenIterator(new int[]{-1, 0, 1, 2});

        evenIt.next();
        boolean result = evenIt.hasNext();

        assertThat(result, is(true));
    }


}