package vkaretko;

import org.junit.Before;
import org.junit.Test;

import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.PrintStream;

import static org.hamcrest.core.Is.is;
import static org.junit.Assert.assertThat;

/**
 * Test-class for ConsoleMenu.
 *
 * @author Karetko Victor
 * @version 1.00
 * @since 07.12.2016
 */
public class ConsoleMenuTest {
    /**
     * Console menu for tests.
     */
    private ConsoleMenu menu;

    /**
     * Init menu before tests.
     */
    @Before
    public void initConsoleMenuBeforeTests() {
        this.menu = new ConsoleMenu();
        this.menu.initMenu();
    }

    /**
     * Method checks filling list of menu items.
     */
    @Test
    public void whenInitMenuItemsThenResultListWithSixMenuItems() {
        final int expectedSizeOfMenu = 6;
        assertThat(this.menu.getMenu().size(), is(expectedSizeOfMenu));
    }

    /**
     * Method checks printing list of menu items.
     */
    @Test
    public void whenPrintMenuItemsThenResultMenuWithDashes() {
        String sep = System.getProperty("line.separator");
        StringBuilder menuInLine = new StringBuilder();
        menuInLine.append(String.format("File%s--New%s----Project...   [opr]%s", sep, sep, sep));
        menuInLine.append(String.format("%-17s%s%s", "--Open", "[open]", sep));
        menuInLine.append(String.format("Help%s--About          [ab]%s", sep, sep));
        try (ByteArrayOutputStream out = new ByteArrayOutputStream()) {
            System.setOut(new PrintStream(out));
            this.menu.printMenu();
            assertThat(out.toString(), is(menuInLine.toString()));
        } catch (IOException ioe) {
            ioe.printStackTrace();
        }
    }
}
