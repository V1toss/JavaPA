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
        String sep = System.getProperty("line.separator");
        assertThat(result, is(String.format("6.0%s18.0%s38.0%s", sep, sep, sep)));
    }
}
