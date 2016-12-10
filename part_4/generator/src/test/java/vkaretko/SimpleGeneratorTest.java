package vkaretko;

import org.junit.Before;
import org.junit.Test;

import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.PrintStream;
import java.util.HashMap;
import java.util.Map;

import static org.hamcrest.core.Is.is;
import static org.junit.Assert.assertThat;

/**
 * Created by vitoss on 10.12.16.
 */
public class SimpleGeneratorTest {
    /**
     * Simple Generator object.
     */
    private SimpleGenerator generator;
    /**
     * Map with keys and values to replace.
     */
    private Map<String, String> keyMap;

    /**
     * Method create instance of SimpleGenerator, create map and fill it with keys and values.
     */
    @Before
    public void createObjectOfClassAndFillMap() {
        generator = new SimpleGenerator();
        keyMap = new HashMap<>();
        keyMap.put("${are}", "do");
        keyMap.put("${g}", "good");
    }

    /**
     * Method checks positive scenario with replacement keys with values.
     */
    @Test
    public void whenReplaceKeyInLineWithProperKeyMapThenResultLineWithReplacedWord() {
        final String lineToReplace = "How ${are} you ${are}? ${g}";
        final String expectedResult = "How do you do? good";
        try {
            String result = generator.generate(lineToReplace, keyMap);
            assertThat(result, is(expectedResult));
        } catch (NoKeyException | WrongKeyException nke) {
            nke.printStackTrace();
        }
    }

    /**
     * Method checks scenario when program throws No Key Exception.
     */
    @Test
    public void whenReplaceKeyInLineWithNoKeyInKeyMapThenResultNoKeyException() {
        final String lineToReplace = "How ${are} you ${do}? ${g}";
        try (ByteArrayOutputStream output = new ByteArrayOutputStream()) {
            System.setOut(new PrintStream(output));
            generator.generate(lineToReplace, keyMap);
        } catch (NoKeyException | WrongKeyException | IOException nke) {
            assertThat(nke.getMessage(), is("Error: no Key in Map"));
        }
    }

    /**
     * Method checks scenario when program throws Wrong Key Exception.
     */
    @Test
    public void whenKeyMapHasUnnecessaryKeyThenResultWrongKeyException() {
        final String lineToReplace = "How ${are} you ${are}?";
        try (ByteArrayOutputStream output = new ByteArrayOutputStream()) {
            System.setOut(new PrintStream(output));
            generator.generate(lineToReplace, keyMap);
        } catch (NoKeyException | WrongKeyException | IOException nke) {
            assertThat(nke.getMessage(), is("Error: Map has unnecessary key"));
        }
    }
}
