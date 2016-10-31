package vkaretko.Task_4_1;

import org.junit.Test;

import java.io.ByteArrayOutputStream;
import java.io.PrintStream;

import static org.hamcrest.core.Is.is;
import static org.junit.Assert.assertThat;

/**
 * Тест-класс для тестирования класса "Square".
 *
 * @author Karetko Victor
 * @version 1.00
 * @since 31.10.2016
 */
public class SquareTest {
    @Test
    public void whenSquareCalculateWithArgumentThreeThenResultEighteen() {
        Square sq = new Square(1f,2f,3f);
        assertThat(sq.calculate(3), is(18f));
    }

    @Test
    public void whenSquareShowWithArgumentsOneAndFiveAndTwoThenPrintOutSixAndEighteenAndThirtyEight() {
        Square sq = new Square(1f,2f,3f);
        String result = null;
        PrintStream outConsole = System.out;
        try {
            ByteArrayOutputStream outStream = new ByteArrayOutputStream();
            PrintStream printStream = new PrintStream(outStream);
            System.setOut(printStream);
            sq.show(1,5,2);
            printStream.flush();
            result = outStream.toString();
        } finally {
            System.setOut(outConsole);
        }
        assertThat(result, is("6.0\r\n18.0\r\n38.0\r\n"));
    }
}
