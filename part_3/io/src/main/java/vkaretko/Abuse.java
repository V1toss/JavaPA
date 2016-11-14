package vkaretko;

import java.io.InputStream;
import java.io.OutputStream;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.io.IOException;

/**
 * Class Abuse for checking abused words in stream.
 *
 * @author Karetko Victor
 * @version 1.00
 * @since 13.11.2016
 */
public class Abuse {
    /**
     * Method for checking abused words.
     * @param in input stream
     * @param out output stream
     * @param abuse array of filters
     */
    void dropAbuses(InputStream in, OutputStream out, String[] abuse) {
        StringBuilder sb = new StringBuilder();
        boolean isAbusedWord = false;
        int streamChar;
        try (InputStreamReader reader = new InputStreamReader(in);
             OutputStreamWriter writer = new OutputStreamWriter(out)) {
            while ((streamChar = reader.read()) > 0) {
                sb.append((char) streamChar);
                for (String word : abuse) {
                    if (word.startsWith(sb.toString())) {
                        isAbusedWord = true;
                        if (word.equals(sb.toString())) {
                            sb.delete(0, sb.length());
                        }
                        break;
                    } else {
                        isAbusedWord = false;
                    }
                }
                if (!isAbusedWord) {
                    writer.write(sb.toString());
                    sb.delete(0, sb.length());
                }
            }
        } catch (IOException ioe) {
            ioe.printStackTrace();
        }
    }
}
