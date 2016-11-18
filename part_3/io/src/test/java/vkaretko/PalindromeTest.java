package vkaretko;

import org.junit.Before;
import org.junit.Test;

import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.PrintStream;

import static org.hamcrest.core.Is.is;
import static org.junit.Assert.assertThat;

/**
 * Test-class for Palindrome.
 *
 * @author Karetko Victor
 * @version 1.00
 * @since 17.11.2016
 */
public class PalindromeTest {
    /**
     * Output stream for tests.
     */
    private ByteArrayOutputStream out;

    /**
     * Method prepare output stream before tests.
     */
    @Before
    public void prepareOutputStream() {
        this.out = new ByteArrayOutputStream();
        System.setOut(new PrintStream(this.out));
    }

    /**
     * Method checks that word entered form console is palindrome.
     */
    @Test
    public void whenEnterPalindromeThenResultMessagePalindrome() {
        String testWord = "КоМок";
        System.setIn(new ByteArrayInputStream(testWord.getBytes()));
        new Palindrome().init();
        assertThat(this.out.toString(), is(String.format("%s is palindrome\r\n", testWord)));
    }

    /**
     * Method checks that word entered form console is not palindrome.
     */
    @Test
    public void whenEnterNotPalindromeThenResultMessageNotPalindrome() {
        String testWord = "Камок";
        System.setIn(new ByteArrayInputStream(testWord.getBytes()));
        new Palindrome().init();
        assertThat(this.out.toString(), is(String.format("%s is NOT palindrome\r\n", testWord)));
    }

    /**
     * Method checks that word entered form console have no 5 symbols.
     */
    @Test
    public void whenEnteredWordHaveNoFiveLettersThenResultMessageNoFiveLetters() {
        String testWord = "Кам";
        System.setIn(new ByteArrayInputStream(testWord.getBytes()));
        new Palindrome().init();
        assertThat(this.out.toString(), is(String.format("%s has not 5 symbols\r\n", testWord)));
    }

}

