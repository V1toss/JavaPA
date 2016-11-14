package vkaretko;

import org.junit.Test;

import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;

import static org.hamcrest.core.Is.is;
import static org.junit.Assert.assertThat;

/**
 * Test class for abuse.
 *
 * @author Karetko Victor
 * @version 1.00
 * @since 13.11.2016
 */
public class AbuseTest {

    /**
     * Test method for checking abused words in input stream.
     */
    @Test
    public void whenCheckLineWithAbuseWordsThenResultLineWithoutAbusedWords() {
        ByteArrayOutputStream output = new ByteArrayOutputStream();
        ByteArrayInputStream input = new ByteArrayInputStream("mygoodlittlebadson".getBytes());
        String[] wordFilter = {"good", "bad"};
        Abuse abuse = new Abuse();
        abuse.dropAbuses(input, output, wordFilter);
        assertThat(output.toString(), is("mylittleson"));
    }

    /**
     * Test method for checking abused words like spaces in input stream.
     */
    @Test
    public void whenCheckLineWithSpacesThenResultLineWithoutSpaces() {
        ByteArrayOutputStream output = new ByteArrayOutputStream();
        ByteArrayInputStream input = new ByteArrayInputStream("my good little bad son".getBytes());
        String[] wordFilter = {" ", "goo", "my"};
        Abuse abuse = new Abuse();
        abuse.dropAbuses(input, output, wordFilter);
        assertThat(output.toString(), is("dlittlebadson"));
    }

    /**
     * Test method for checking abused words with empty filter in input stream.
     */
    @Test
    public void whenCheckLineWithEmptyFilterThenResultSameLine() {
        ByteArrayOutputStream output = new ByteArrayOutputStream();
        ByteArrayInputStream input = new ByteArrayInputStream("my good little bad son".getBytes());
        String[] wordFilter = {};
        Abuse abuse = new Abuse();
        abuse.dropAbuses(input, output, wordFilter);
        assertThat(output.toString(), is("my good little bad son"));
    }
}
