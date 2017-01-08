package vkaretko;

import org.junit.Test;

/**
 * Class
 *
 * @author Karetko Victor.
 * @version 1.00.
 * @since 08.01.2017.
 */
public class SpaceCalculatorTest {
    /**
     * Test with join.
     */
    @Test
    public void whenParseTextWithJoinThenResultAmountOfWordsAndSpaces() {
        SpaceCalculator sp = new SpaceCalculator();
        try {
            sp.parse("sdfsd sdfsdf sdfsdf sdfsdf", true);
        } catch (InterruptedException ie) {
            ie.printStackTrace();
        }
    }

    /**
     * Test without join.
     */
    @Test
    public void whenParseTextWithoutJoinThenResultAmountOfWordsAndSpaces() {
        SpaceCalculator sp = new SpaceCalculator();
        try {
            sp.parse("sdfsd sdfsdf sdfsdf sdfsdf", false);
        } catch (InterruptedException ie) {
            ie.printStackTrace();
        }
    }

}