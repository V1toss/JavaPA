package vkaretko;

import org.junit.Test;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;

import static org.hamcrest.core.Is.is;
import static org.junit.Assert.assertThat;

/**
 * Class
 *
 * @author Karetko Victor.
 * @version 1.00.
 * @since 06.01.2017.
 */
public class CacheTest {

    /**
     * Line separator.
     */
    private final String sep = System.getProperty("line.separator");


    /**
     * Test for read file method.
     */
    @Test
    public void whenReadFileThenResultLinesFromFile() {
        Cache cache = new Cache("c:/temp");
        String result = cache.readFile("names.txt");
        assertThat(result, is(String.format("Ivan%sVictor%sPetr%s", sep, sep, sep)));
    }

    /**
     * Test for read from cache.
     */
    @Test
    public void whenReadFileAndAddNewLineToFileThenSecondReadFromHashWithoutLine() {
        Cache cache = new Cache("c:/temp");
        String before = cache.readFile("names2.txt");
        String result = cache.select("names2.txt");
        String path = "c:/temp/names2.txt";
        try (FileWriter writer = new FileWriter(path, true);
             BufferedWriter bufferWriter = new BufferedWriter(writer)) {
            bufferWriter.write("test");
        } catch (IOException e) {
            e.printStackTrace();
        }
        result = cache.select("names2.txt");
        assertThat(result, is(before));
    }

}