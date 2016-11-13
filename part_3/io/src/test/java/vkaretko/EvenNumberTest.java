package vkaretko;

import org.junit.Test;
import java.io.ByteArrayInputStream;

import static org.hamcrest.core.Is.is;
import static org.junit.Assert.assertThat;

/**
 * Test class for EvenNumber.
 *
 * @author Karetko Victor
 * @version 1.00
 * @since 13.11.2016
 */
public class EvenNumberTest {
    /**
     * Test-method for checking even numbers.
     */
    @Test
    public void whenEvenNumberTwoInStreamThenResultTrue() {
        EvenNumber number = new EvenNumber();
        ByteArrayInputStream stream = new ByteArrayInputStream("2".getBytes());
        assertThat(number.isNumber(stream), is(true));
    }

    /**
     * Test-method for checking odd numbers.
     */
    @Test
    public void whenOddNumberThreeInStreamThenResultFalse() {
        EvenNumber number = new EvenNumber();
        ByteArrayInputStream stream = new ByteArrayInputStream("3".getBytes());
        assertThat(number.isNumber(stream), is(false));
    }
}
