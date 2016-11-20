package vkaretko.sort;

import java.io.File;
import java.io.IOException;
import java.io.RandomAccessFile;

/**
 * Class MergeSort for external natural sorting large text-files.
 *
 * @author Karetko Victor
 * @version 1.00
 * @since 15.11.2016
 */
public class MergeSort {
    /**
     * Source file.
     */
    private RandomAccessFile srcFile;
    /**
     * Destination file.
     */
    private RandomAccessFile dstFile;
    /**
     * First temp file.
     */
    private RandomAccessFile fstTempFile;
    /**
     * Second temp file.
     */
    private RandomAccessFile sndTempFile;
    /**
     * Status of sorting.
     */
    private boolean isUnsortedFile = true;

    /**
     * Public method for initiate sorting text files.
     * @param source Source file
     * @param distance Destination file
     * @throws IOException if file not found
     */
    public void sort(File source, File distance) throws IOException {
        initFiles(source, distance);
        mergeSort();
    }

    /**
     * Method for initiate Random Access Files for source and distance files.
     * @param source Source file
     * @param distance Destination file
     * @throws IOException if file not found
     */
    private void initFiles(File source, File distance) throws IOException {
        this.srcFile = new RandomAccessFile(source, "r");
        this.dstFile = new RandomAccessFile(distance, "rw");
    }

    /**
     * Method for merge sorting.
     * Creating temp files, calling split and merge methods.
     * @throws IOException if file not found
     */
    private void mergeSort() throws IOException {
        File firstTmpFile = File.createTempFile("first", ".tmp");
        File secondTmpFile = File.createTempFile("second", ".tmp");
        RandomAccessFile fileToSplit = this.srcFile;

        try (RandomAccessFile fstSplitFile = new RandomAccessFile(firstTmpFile, "rw");
             RandomAccessFile sndSplitFile = new RandomAccessFile(secondTmpFile, "rw")) {
            this.fstTempFile = fstSplitFile;
            this.sndTempFile = sndSplitFile;
            while (this.isUnsortedFile) {
                splitToTempFiles(fileToSplit);
                mergeTempFiles();
                fileToSplit = this.dstFile;
            }
        }
        firstTmpFile.deleteOnExit();
        secondTmpFile.deleteOnExit();
    }

    /**
     * Method for for splitting text file into two temp files.
     * @param raf file for split
     * @throws IOException if file not found
     */
    private void splitToTempFiles(RandomAccessFile raf) throws IOException {
        raf.seek(0);
        this.fstTempFile.setLength(0);
        this.sndTempFile.setLength(0);
        boolean selector = true;
        String line = raf.readLine();
        while (line != null) {
            if (selector) {
                line = writeSeries(line, raf, this.fstTempFile);
                selector = false;
            } else {
                line = writeSeries(line, raf, this.sndTempFile);
                selector = true;
            }
        }
    }

    /**
     * Method for merging two temp files into one text file.
     * @throws IOException if file not found
     */
    private void mergeTempFiles() throws IOException {
        this.dstFile.setLength(0);
        this.fstTempFile.seek(0);
        this.sndTempFile.seek(0);
        String fstFileLine = fstTempFile.readLine();
        String sndFileLine = sndTempFile.readLine();
        if (sndFileLine != null) {
            startMerging(fstFileLine, sndFileLine);
        } else {
            writeSeries(fstFileLine, this.fstTempFile, this.dstFile);
            this.isUnsortedFile = false;
        }
    }

    /**
     * Method, that contains algorithm of natural merging.
     * @param fstFileLine - first line from first temp file.
     * @param sndFileLine - first line from second temp file.
     * @throws IOException if file not found
     */
    private void startMerging(String fstFileLine, String sndFileLine) throws IOException {
        long fstPrevLineLength = -1;
        long sndPrevLineLength = -1;
        while (fstFileLine != null && sndFileLine != null) {
            fstPrevLineLength = fstPrevLineLength > fstFileLine.length() ? fstFileLine.length() : -1;
            sndPrevLineLength = sndPrevLineLength > sndFileLine.length() ? sndFileLine.length() : -1;
            boolean isFirstFileSeriesEnded = fstFileLine.length() < fstPrevLineLength;
            boolean isSecondFileSeriesEnded = sndFileLine.length() < sndPrevLineLength;
            if (fstFileLine.length() <= sndFileLine.length() && !isFirstFileSeriesEnded) {
                fstFileLine = writeToDest(fstFileLine, this.fstTempFile);
            } else if (fstFileLine.length() >= sndFileLine.length() && !isSecondFileSeriesEnded) {
                sndFileLine = writeToDest(sndFileLine, this.sndTempFile);
            } else if (isFirstFileSeriesEnded && !isSecondFileSeriesEnded) {
                sndFileLine = writeToDest(sndFileLine, this.sndTempFile);
            } else if (!isFirstFileSeriesEnded && isSecondFileSeriesEnded) {
                fstFileLine = writeToDest(fstFileLine, this.fstTempFile);
            }
        }
        writeTail(fstFileLine, sndFileLine);
    }

    /**
     * Method, that checks tail of temp files after merging and write tail if it exists.
     * @param fstFileLine - last line of first file.
     * @param sndFileLine - last line of second file.
     * @throws IOException if file not found
     */
    private void writeTail(String fstFileLine, String sndFileLine) throws IOException {
        while (fstFileLine != null) {
            fstFileLine = writeToDest(fstFileLine, this.fstTempFile);
        }
        while (sndFileLine != null) {
            sndFileLine = writeToDest(sndFileLine, this.sndTempFile);
        }
    }

    /**
     * Method for write series into temp files while splitting.
     * @param prevLine - start line.
     * @param srcRaf - source file.
     * @param dstRaf - destination file.
     * @return first line of new series.
     * @throws IOException if file not found
     */
    private String writeSeries(String prevLine, RandomAccessFile srcRaf, RandomAccessFile dstRaf) throws IOException {
        dstRaf.writeBytes(String.format("%s\r\n", prevLine));
        int prevLineLength = prevLine.length();
        String currentLine = srcRaf.readLine();
        while (currentLine != null && currentLine.length() >= prevLineLength) {
            prevLineLength = currentLine.length();
            dstRaf.writeBytes(String.format("%s\r\n", currentLine));
            currentLine = srcRaf.readLine();
        }
        return currentLine;
    }

    /**
     * Method for write lines to destination file and return next line.
     * @param line - line to write
     * @param raf - destination file
     * @return next line
     * @throws IOException if file not found
     */
    private String writeToDest(String line, RandomAccessFile raf) throws IOException {
        this.dstFile.writeBytes(String.format("%s\r\n", line));
        return raf.readLine();
    }

    public static void main(String[] args) {

    }
}