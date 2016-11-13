package vkaretko;

import org.junit.Test;

import static org.hamcrest.core.Is.is;
import static org.junit.Assert.assertThat;

/**
 * Test class for BracketCheck.
 *
 * @author Karetko Victor
 * @version 1.00
 * @since 13.11.2016
 */
public class BracketCheckTest {
    /**
     * Test-method for checking sequence of brackets.
     */
    @Test
    public void whenBracketCheckThreeLinesThenResultTrueFalseFalse() {
        BracketCheck bracket = new BracketCheck();
        assertThat(bracket.checkLine("()(()((())))"), is(true));
        assertThat(bracket.checkLine("())"), is(false));
        assertThat(bracket.checkLine("())(()"), is(false));
    }
}
