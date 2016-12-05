package vkaretko.chat;

import org.junit.Before;
import org.junit.Test;

import java.io.File;
import java.io.IOException;
import java.io.ByteArrayOutputStream;
import java.io.ByteArrayInputStream;
import java.io.PrintStream;

import static org.hamcrest.core.Is.is;
import static org.junit.Assert.assertThat;

/**
 * Test-class for ConsoleChat.
 *
 * @author Karetko Victor
 * @version 1.00
 * @since 19.11.2016
 */
public class ConsoleChatTest {
    /**
     * Line-separator for Windows and Linux.
     */
    private final String sep = System.getProperty("line.separator");
    /**
     * Output stream for tests.
     */
    private ByteArrayOutputStream out;

    /**
     * File path to phrases.
     */
    private final String filePathPhrase = String.format("%s%s%s", System.getProperty("user.dir"),
            File.separator, "src/main/java/vkaretko/chat/resources/phrases.txt");

    /**
     * File path to log-file.
     */
    private final String filePathLog = String.format("%s%s%s", System.getProperty("user.dir"),
            File.separator, "src/main/java/vkaretko/chat/logs/log.txt");

    /**
     * Method prepare output stream before tests.
     */
    @Before
    public void prepareOutputStream() {
        this.out = new ByteArrayOutputStream();
        System.setOut(new PrintStream(this.out));
    }

    /**
     * Method checks that after word stop there is no messages.
     */
    @Test
    public void whenEnterStopAndOtherWordsThenResultNoAnswer() {
        String stopKey = String.format("stop%stest%stest2", sep, sep);
        System.setIn(new ByteArrayInputStream(stopKey.getBytes()));
        try {
            new ConsoleChat(this.filePathPhrase, this.filePathLog).init();
        } catch (IOException ioe) {
            ioe.printStackTrace();
        }
        assertThat(this.out.toString().isEmpty(), is(true));
    }

    /**
     * Method checks that after word stop and continue there are messages form program.
     */
    @Test
    public void whenEnterStopAndContinueResultRandomMessage() {
        String stopAndContinueKey = String.format("stop%scontinue%stest", sep, sep);
        System.setIn(new ByteArrayInputStream(stopAndContinueKey.getBytes()));
        try {
            new ConsoleChat(this.filePathPhrase, this.filePathLog).init();
        } catch (IOException ioe) {
            ioe.printStackTrace();
        }
        assertThat(this.out.toString().isEmpty(), is(false));
    }

    /**
     * Method checks that after random entered word program print random message.
     */
    @Test
    public void whenEnterWordThenResultRandomMessage() {
        String stopKey = "bree";
        System.setIn(new ByteArrayInputStream(stopKey.getBytes()));
        try {
            new ConsoleChat(this.filePathPhrase, this.filePathLog).init();
        } catch (IOException ioe) {
            ioe.printStackTrace();
        }
        assertThat(this.out.toString().isEmpty(), is(false));
    }

    /**
     * Method checks that words and keys entered after end ignoring.
     */
    @Test
    public void whenEnterEndThenResultProgramTerminate() {
        String stopKey = String.format("end%stest%scontinue%sstop", sep, sep, sep);
        System.setIn(new ByteArrayInputStream(stopKey.getBytes()));
        try {
            new ConsoleChat(this.filePathPhrase, this.filePathLog).init();
        } catch (IOException ioe) {
            ioe.printStackTrace();
        }
        assertThat(this.out.toString().isEmpty(), is(true));
    }
}
