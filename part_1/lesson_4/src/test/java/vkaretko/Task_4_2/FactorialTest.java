package vkaretko.Task_4_2;

import org.junit.Test;

import java.io.ByteArrayOutputStream;
import java.io.PrintStream;

import static org.hamcrest.core.Is.is;
import static org.junit.Assert.assertThat;

/**
 * Тест-класс для тестирования класса "Factorial".
 *
 * @author Karetko Victor
 * @version 1.00
 * @since 31.10.2016
 */
public class FactorialTest {
    @Test
    public void whenCalculateFactorialOfFourThenResultTwentyFour() {
        Factorial factorial = new Factorial(4);
        assertThat(factorial.calculate(), is(24L));
    }

    @Test
    public void whenCalculateFactorialOfZeroThenResultOne() {
        Factorial factorial = new Factorial(0);
        assertThat(factorial.calculate(), is(1L));
    }

    @Test
    public void whenCalculateFactorialOfNegativeNumberFiveThenResultZeroAndPrintOutMessage() {
        Factorial factorial = new Factorial(-5);
        String result = null;
        PrintStream outConsole = System.out;
        try {
            ByteArrayOutputStream outStream = new ByteArrayOutputStream();
            PrintStream printStream = new PrintStream(outStream);
            System.setOut(printStream);
            assertThat(factorial.calculate(), is(0L));
            printStream.flush();
            result = outStream.toString();
        } finally {
            System.setOut(outConsole);
        }
        assertThat(result, is("Non positive number\r\n"));
    }
}
