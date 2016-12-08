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
     * List of base menu items.
     */
    private ArrayList<MenuItems> menu = new ArrayList<>();
    /**
     * Method fills list of menu with items.
     */
    public void init() {
        File file = new File();
        New fileNew = new New();
        Help help = new Help();
        file.addMenuItem(fileNew);
        file.addMenuItem(new FileOpen());
        fileNew.addMenuItem(new Project());
        help.addMenuItem(new HelpAbout());
        menu.add(file);
        menu.add(help);
        printMenu(this.menu);
    }

    /**
     * Method for printing menu to console.
     * @param menu list of menu items to print.
     */
    public void printMenu(List<MenuItems> menu) {
        for (MenuItems item : menu) {
            System.out.println(String.format("%s%s", printDashes(item.getLevel()), item.getInfo()));
            if (item.getMenuItems() != null) {
                printMenu(item.getMenuItems());
            }
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
}
