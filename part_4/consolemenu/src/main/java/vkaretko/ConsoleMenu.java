package vkaretko;

import vkaretko.interfaces.MenuItems;
import vkaretko.menuitems.File;
import vkaretko.menuitems.FileOpen;
import vkaretko.menuitems.Project;
import vkaretko.menuitems.New;
import vkaretko.menuitems.Help;
import vkaretko.menuitems.HelpAbout;

import java.util.ArrayList;
import java.util.List;

/**
 * Class ConsoleMenu for filling list of menu items and print them in console.
 *
 * @author Karetko Victor
 * @version 1.00
 * @since 07.12.2016
 */
public class ConsoleMenu {
    /**
     * List of menu items.
     */
    private final List<MenuItems> menu = new ArrayList<>();

    /**
     * Method fills list of menu with items.
     */
    public void initMenu() {
        menu.add(new File());
        menu.add(new New());
        menu.add(new Project());
        menu.add(new FileOpen());
        menu.add(new Help());
        menu.add(new HelpAbout());
    }

    /**
     * Method for printing menu to console.
     */
    public void printMenu() {
        for (MenuItems item : this.menu) {
            System.out.println(String.format("%s%s", printDashes(item.getLevel()), item.getInfo()));
        }
    }

    /**
     * Method for printing double dashes before text.
     * @param amountOfDashes amount of double dashes.
     * @return string with dashes.
     */
    private String printDashes(int amountOfDashes) {
        StringBuilder sb = new StringBuilder();
        for (int dashes = 0; dashes < amountOfDashes; dashes++) {
            sb.append("--");
        }
        return sb.toString();
    }

    /**
     * Getter-method for list of menu items.
     * @return list of menu items.
     */
    public List<MenuItems> getMenu() {
        return this.menu;
    }
}
