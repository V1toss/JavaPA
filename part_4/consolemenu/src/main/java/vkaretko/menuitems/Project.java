package vkaretko.menuitems;

import vkaretko.interfaces.MenuItems;

/**
 * Class Project to show Project item in File/New menu.
 *
 * @author Karetko Victor
 * @version 1.00
 * @since 07.12.2016
 */
public class Project extends MenuItems {
    /**
     * Overrided method of get info for current item.
     * @return information of menu item.
     */
    @Override
    public String getInfo() {
        return String.format("%-13s%s", "Project...", "[opr]");
    }
    /**
     * Overrided method of get level for current item.
     * @return level of item in menu.
     */
    @Override
    public int getLevel() {
        return 2;
    }
}
