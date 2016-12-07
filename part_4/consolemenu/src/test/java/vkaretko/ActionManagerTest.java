package vkaretko;

import org.junit.Before;
import org.junit.Test;

import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.PrintStream;

import static org.hamcrest.core.Is.is;
import static org.junit.Assert.assertThat;

/**
 * Test-class for console menu.
 *
 * @author Karetko Victor
 * @version 1.00
 * @since 07.12.2016
 */
public class ActionManagerTest {
    /**
     * MultiOS separator for lines.
     */
    private String sep = System.getProperty("line.separator");
    /**
     * Console menu for tests.
     */
    private ActionManager manager;

    /**
     * Init menu before tests.
     */
    @Before
    public void initActionManagerBeforeTests() {
        this.manager = new ActionManager();
        this.manager.init();
    }

    /**
     * Method checks filling list of actions.
     */
    @Test
    public void whenInitActionManagerThenResultListWithThreeActions() {
        final int expectedSizeOfMenu = 3;
        assertThat(manager.getActions().size(), is(expectedSizeOfMenu));
    }

    /**
     * Method check Select action About.
     */
    @Test
    public void whenSelectActionAboutThenResultMessageHelpAbout() {
        try (ByteArrayOutputStream out = new ByteArrayOutputStream()) {
            System.setOut(new PrintStream(out));
            manager.select("ab");
            assertThat(out.toString(), is(String.format("HelpAbout%s", sep)));
        } catch (IOException ioe) {
            ioe.printStackTrace();
        }
    }

    /**
     * Method check Select action Open.
     */
    @Test
    public void whenSelectActionOpenThenResultMessageFileOpen() {
        try (ByteArrayOutputStream out = new ByteArrayOutputStream()) {
            System.setOut(new PrintStream(out));
            manager.select("open");
            assertThat(out.toString(), is(String.format("File Open%s", sep)));
        } catch (IOException ioe) {
            ioe.printStackTrace();
        }
    }

    /**
     * Method check Select action Open.
     */
    @Test
    public void whenSelectActionOpenProjectsThenResultMessageFileOpen() {
        try (ByteArrayOutputStream out = new ByteArrayOutputStream()) {
            System.setOut(new PrintStream(out));
            manager.select("opr");
            assertThat(out.toString(), is(String.format("OpenProject%s", sep)));
        } catch (IOException ioe) {
            ioe.printStackTrace();
        }
    }

}
