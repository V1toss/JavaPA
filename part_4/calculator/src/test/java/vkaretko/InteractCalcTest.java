package vkaretko;

import org.junit.Test;

import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.PrintStream;

import static org.hamcrest.core.Is.is;
import static org.junit.Assert.assertThat;

/**
 * Class InteractCalc test-class.
 *
 * @author Karetko Victor
 * @version 1.00
 * @since 30.11.2016
 */
public class InteractCalcTest {
    /**
     * Method checks positive scenario of Add action.
     */
    @Test
    public void whenSelectActionAddAndInputTwoNumbersThenResultSumOfTwoNumbers() {
        try (ByteArrayOutputStream output = new ByteArrayOutputStream();
             ByteArrayInputStream input = new ByteArrayInputStream("1\r\n5\r\n6\r\nn\r\n0".getBytes())) {
            System.setOut(new PrintStream(output));
            System.setIn(input);
            new InteractCalc().initDialog();
            assertThat(output.toString().contains("is 11.0"), is(true));
        } catch (IOException ioe) {
            ioe.printStackTrace();
        }
    }

    /**
     * Method checks positive scenario of Subtract action.
     */
    @Test
    public void whenSelectActionSubtractAndInputTwoNumbersThenResultSubtractOfTwoNumbers() {
        try (ByteArrayOutputStream output = new ByteArrayOutputStream();
             ByteArrayInputStream input = new ByteArrayInputStream("2\r\n15\r\n5\r\nn\r\n0".getBytes())) {
            System.setOut(new PrintStream(output));
            System.setIn(input);
            new InteractCalc().initDialog();
            assertThat(output.toString().contains("is 10.0"), is(true));
        } catch (IOException ioe) {
            ioe.printStackTrace();
        }
    }

    /**
     * Method checks positive scenario of Multiply action.
     */
    @Test
    public void whenSelectActionMultiplyAndInputTwoNumbersThenResultMultuplyedNumbers() {
        try (ByteArrayOutputStream output = new ByteArrayOutputStream();
             ByteArrayInputStream input = new ByteArrayInputStream("3\r\n15\r\n5\r\nn\r\n0".getBytes())) {
            System.setOut(new PrintStream(output));
            System.setIn(input);
            new InteractCalc().initDialog();
            assertThat(output.toString().contains("is 75.0"), is(true));
        } catch (IOException ioe) {
            ioe.printStackTrace();
        }
    }

    /**
     * Method checks positive scenario of Division action.
     */
    @Test
    public void whenSelectActionDivisionAndInputTwoNumbersThenResultDivisionOfTwoNumbers() {
        try (ByteArrayOutputStream output = new ByteArrayOutputStream();
             ByteArrayInputStream input = new ByteArrayInputStream("4\r\n15\r\n5\r\nn\r\n0".getBytes())) {
            System.setOut(new PrintStream(output));
            System.setIn(input);
            new InteractCalc().initDialog();
            assertThat(output.toString().contains("is 3.0"), is(true));
        } catch (IOException ioe) {
            ioe.printStackTrace();
        }
    }

    /**
     * Method checks positive scenario of repeat add action.
     */
    @Test
    public void whenSelectActionAddInputTwoNumbersAndRepeatThenResultTwoNumbers() {
        try (ByteArrayOutputStream output = new ByteArrayOutputStream();
             ByteArrayInputStream input = new ByteArrayInputStream("1\r\n15\r\n5\r\ny\r\nn\r\n0".getBytes())) {
            System.setOut(new PrintStream(output));
            System.setIn(input);
            new InteractCalc().initDialog();
            assertThat(output.toString().contains("is 25.0"), is(true));
        } catch (IOException ioe) {
            ioe.printStackTrace();
        }
    }

    /**
     * Method checks positive scenario of first powers second number operation.
     */
    @Test
    public void whenSelectActionPowThreeToThreeThenResultTwentySeven() {
        try (ByteArrayOutputStream output = new ByteArrayOutputStream();
             ByteArrayInputStream input = new ByteArrayInputStream("5\r\n3\r\n3\r\nn\r\n0".getBytes())) {
            System.setOut(new PrintStream(output));
            System.setIn(input);
            new InteractCalc().initDialog();
            assertThat(output.toString().contains("is 27.0"), is(true));
        } catch (IOException ioe) {
            ioe.printStackTrace();
        }
    }

    /**
     * Method checks positive scenario of sinus operation.
     */
    @Test
    public void whenSelectActionSinNinetyThenResultOne() {
        try (ByteArrayOutputStream output = new ByteArrayOutputStream();
             ByteArrayInputStream input = new ByteArrayInputStream("6\r\n90\r\n0\r\nn\r\n0".getBytes())) {
            System.setOut(new PrintStream(output));
            System.setIn(input);
            new InteractCalc().initDialog();
            assertThat(output.toString().contains("is 1.0"), is(true));
        } catch (IOException ioe) {
            ioe.printStackTrace();
        }
    }

    /**
     * Method checks positive scenario of cosinus operation.
     */
    @Test
    public void whenSelectActionCosZeroThenResultOne() {
        try (ByteArrayOutputStream output = new ByteArrayOutputStream();
             ByteArrayInputStream input = new ByteArrayInputStream("7\r\n0\r\n0\r\nn\r\n0".getBytes())) {
            System.setOut(new PrintStream(output));
            System.setIn(input);
            new InteractCalc().initDialog();
            assertThat(output.toString().contains("is 1.0"), is(true));
        } catch (IOException ioe) {
            ioe.printStackTrace();
        }
    }

    /**
     * Method checks positive scenario of tangens operation.
     */
    @Test
    public void whenSelectActionTanFortyFiveThenResultOne() {
        try (ByteArrayOutputStream output = new ByteArrayOutputStream();
             ByteArrayInputStream input = new ByteArrayInputStream("8\r\n45\r\n0\r\nn\r\n0".getBytes())) {
            System.setOut(new PrintStream(output));
            System.setIn(input);
            new InteractCalc().initDialog();
            assertThat(output.toString().contains("is 1.0"), is(true));
        } catch (IOException ioe) {
            ioe.printStackTrace();
        }
    }
}
