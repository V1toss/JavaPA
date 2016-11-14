package vkaretko;

import org.junit.Test;

import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.IOException;

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
        String[] wordFilter = {"good", "bad"};
        Abuse abuse = new Abuse();

        try (ByteArrayOutputStream output = new ByteArrayOutputStream();
             ByteArrayInputStream input = new ByteArrayInputStream("mygoodlittlebadson".getBytes())) {
            abuse.dropAbuses(input, output, wordFilter);
            assertThat(output.toString(), is("mylittleson"));
        } catch (IOException ioe) {
            ioe.printStackTrace();
        }
    }

    /**
     * Test method for checking abused words like spaces in input stream.
     */
    @Test
    public void whenCheckLineWithSpacesThenResultLineWithoutSpaces() {
        String[] wordFilter = {" ", "goo", "my"};
        Abuse abuse = new Abuse();

        try (ByteArrayOutputStream output = new ByteArrayOutputStream();
             ByteArrayInputStream input = new ByteArrayInputStream("my good little bad son".getBytes())) {
            abuse.dropAbuses(input, output, wordFilter);
            assertThat(output.toString(), is("dlittlebadson"));
        } catch (IOException ioe) {
            ioe.printStackTrace();
        }
    }

    /**
     * Test method for checking abused words with empty filter in input stream.
     */
    @Test
    public void whenCheckLineWithEmptyFilterThenResultSameLine() {
        String[] wordFilter = {};
        Abuse abuse = new Abuse();
        try (ByteArrayOutputStream output = new ByteArrayOutputStream();
             ByteArrayInputStream input = new ByteArrayInputStream("my good little bad son".getBytes())) {
            abuse.dropAbuses(input, output, wordFilter);
            assertThat(output.toString(), is("my good little bad son"));
        } catch (IOException ioe) {
            ioe.printStackTrace();
        }
    }
}
