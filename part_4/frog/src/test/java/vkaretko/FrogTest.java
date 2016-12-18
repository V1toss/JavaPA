package vkaretko;

import org.junit.Test;

import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.PrintStream;
import java.util.ArrayList;

import static org.hamcrest.core.Is.is;
import static org.junit.Assert.assertThat;

/**
 * Frog test class.
 * @author Karetko Victor
 * @version 1.00
 * @since 16.12.2016
 */
public class FrogTest {
    /**
     * Line separator.
     */
    private String sep = System.getProperty("line.separator");

    /**
     * Method checks recursive search of shortest path.
     */
    @Test
    public void whenInitFrogWithDefaultParametersThenResultStringWithLengthSevenAndCoordinates() {
        final Position startPos = new Position(11, 7);
        final Position finalPos = new Position(9, 10);
        final Position treeOne = new Position(14, 9);
        final Position treeTwo = new Position(5, 8);
        ArrayList<Position> trees = new ArrayList<>();
        trees.add(treeOne);
        trees.add(treeTwo);

        try (ByteArrayOutputStream output = new ByteArrayOutputStream()) {
            System.setOut(new PrintStream(output));
            new Frog(startPos, finalPos, trees).init();
            assertThat(output.toString(), is(String.format(
                    "Minimum length: 7%sPath:(11,7)(14,7)(1,7)(4,7)(6,8)(7,6)(8,8)(9,10)%s", sep, sep)));
        } catch (IOException io) {
            io.printStackTrace();
        }
    }
}