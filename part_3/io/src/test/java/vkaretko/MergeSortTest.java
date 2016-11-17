package vkaretko;

import org.junit.Before;
import org.junit.Test;
import vkaretko.sort.MergeSort;

import java.io.File;
import java.io.IOException;
import java.io.RandomAccessFile;

import static org.hamcrest.core.Is.is;
import static org.junit.Assert.assertThat;

/**
 * Test class for MergeSort.
 *
 * @author Karetko Victor
 * @version 1.00
 * @since 15.11.2016
 */
public class MergeSortTest {

    /**
     * Unsorted array of string lines.
     */
    private final String[] unSortedLines = {"1", "22222", "3333333", "555", "66", "77777", "8888888888", "9999"};
    /**
     * Sorted array of string lines.
     */
    private final String[] sortedLines = {"1", "66", "555", "9999", "22222", "77777", "3333333", "8888888888"};
    /**
     * Source text file.
     */
    private File srcTxtFile;
    /**
     * Destination text file.
     */
    private File dstTxtFile;
    /**
     * Random Access File for source file.
     */
    private RandomAccessFile rafSrc;
    /**
     * Random Access File for destination file.
     */
    private RandomAccessFile rafDst;
    /**
     * Creating temp files and creating filled txt file.
     */
    @Before
    public void createTempFiles() {
        try {
            this.srcTxtFile = File.createTempFile("first", ".txt");
            this.srcTxtFile.deleteOnExit();
            this.dstTxtFile = File.createTempFile("second", ".txt");
            this.dstTxtFile.deleteOnExit();
        } catch (IOException ioe) {
            ioe.printStackTrace();
        }
        try (RandomAccessFile rafF = new RandomAccessFile(this.srcTxtFile, "rw")) {
            this.rafSrc = rafF;
            for (String line : this.unSortedLines) {
                this.rafSrc.writeBytes(String.format("%s\r\n", line));
            }
        } catch (IOException ioe) {
            ioe.printStackTrace();
        }
    }

    /**
     * Test-method for checking that unsorted file become sorted after external merge sorting.
     */
    @Test
    public void whenSortTextFileThenResultSortedFile() {
        MergeSort sort = new MergeSort();
        String[] result = new String[this.unSortedLines.length];
        try {
            sort.sort(this.srcTxtFile, this.dstTxtFile);
        } catch (IOException ioe) {
            ioe.printStackTrace();
        }
        try (RandomAccessFile rafD = new RandomAccessFile(this.dstTxtFile, "rw")) {
            this.rafDst = rafD;
            String line;
            int count = 0;
            while ((line = rafDst.readLine()) != null) {
                result[count++] = line;
            }
            assertThat(result, is(this.sortedLines));
        } catch (IOException ioe) {
            ioe.printStackTrace();
        }
    }
}
