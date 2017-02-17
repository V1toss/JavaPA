package vkaretko;

import org.junit.Before;
import org.junit.Test;

import java.io.ByteArrayOutputStream;
import java.io.File;
import java.io.IOException;
import java.io.PrintStream;
import java.util.Scanner;

import static org.hamcrest.core.Is.is;
import static org.junit.Assert.assertThat;

/**
 * Test-class for FileSearch.
 *
 * @author Karetko Victor
 * @version 1.00
 * @since 26.11.2016
 */
public class FileSearchTest {
    /**
     * First temp-file for tests.
     */
    private File tempFileOne;
    /**
     * Second temp-file for tests.
     */
    private File tempFileTwo;
    /**
     * Third temp-file for tests.
     */
    private File tempFileThree;
    /**
     * Log-file.
     */
    private File logFile;

    /**
     * Create temp-files before tests.
     */
    @Before
    public void createTempFiles() {
        try {
            File tempDir = new File("c:/temp");
            tempDir.mkdir();
            tempDir.deleteOnExit();
            this.tempFileOne = new File("c:/temp/1.txt");
            this.tempFileTwo = new File("c:/temp/2.txt");
            this.tempFileThree = new File("c:/temp/3.txt");
            this.tempFileOne.createNewFile();
            this.tempFileTwo.createNewFile();
            this.tempFileThree.createNewFile();
            this.tempFileOne.deleteOnExit();
            this.tempFileTwo.deleteOnExit();
            this.tempFileThree.deleteOnExit();
            this.logFile = new File("c:/temp/log.txt");
            this.logFile.deleteOnExit();
        } catch (IOException ioe) {
            ioe.printStackTrace();
        }
    }

    /**
     * Test-method for checking message after wrong arguments.
     */
    @Test
    public void whenWrongArgumentsThenResultErrorMessage() {
        try (ByteArrayOutputStream output = new ByteArrayOutputStream()) {
            System.setOut(new PrintStream(output));
            String[] wrongArgs = {"-d", "-m", "-n"};
            FileSearch.main(wrongArgs);
            assertThat(output.toString(), is("Wrong arguments\r\nTo show help - execute program with key /help\r\n"));
        } catch (IOException ioe) {
            ioe.printStackTrace();
        }
    }

    /**
     * Test-method for check search by mask.
     */
    @Test
    public void whenSearchByMaskTxtThenResultThreeLinesInLogFile() {
        String[] argsSearchByMask = {"-d", "c:/temp/", "-n", "*.txt", "-m", "-o", "log.txt"};
        FileSearch.main(argsSearchByMask);
        StringBuilder sb = new StringBuilder();
        try (Scanner sc = new Scanner(this.logFile)) {
            while (sc.hasNext()) {
                sb.append(sc.nextLine());
            }
        } catch (IOException ioe) {
            ioe.printStackTrace();
        }
        assertThat(sb.toString(), is("c:\\temp\\1.txtc:\\temp\\2.txtc:\\temp\\3.txt"));
    }

    /**
     * Test-method for check search by name.
     */
    @Test
    public void whenSearchByNameThenResultOneLineInLogFile() {
        String[] argsSearchByName = {"-d", "c:/temp/", "-n", "2.txt", "-f", "-o", "log.txt"};
        FileSearch.main(argsSearchByName);
        StringBuilder sb = new StringBuilder();
        try (Scanner sc = new Scanner(this.logFile)) {
            while (sc.hasNext()) {
                sb.append(sc.nextLine());
            }
        } catch (IOException ioe) {
            ioe.printStackTrace();
        }
        assertThat(sb.toString(), is("c:\\temp\\2.txt"));
    }

    /**
     * Test-method for check search by regex.
     */
    @Test
    public void whenSearchByRegexThenResultTwoLinesInLogFile() {
        String[] argsSearchByName = {"-d", "c:/temp/", "-n", "[2-3].*", "-r", "-o", "log.txt"};
        FileSearch.main(argsSearchByName);
        StringBuilder sb = new StringBuilder();
        try (Scanner sc = new Scanner(this.logFile)) {
            while (sc.hasNext()) {
                sb.append(sc.nextLine());
            }
        } catch (IOException ioe) {
            ioe.printStackTrace();
        }
        assertThat(sb.toString(), is("c:\\temp\\2.txtc:\\temp\\3.txt"));
    }

}
