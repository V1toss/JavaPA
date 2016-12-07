package vkaretko.menuitems;

import vkaretko.interfaces.MenuItems;

/**
 * Class FileOpen to show Open item in File menu.
 *
 * @author Karetko Victor
 * @version 1.00
 * @since 07.12.2016
 */
public class FileOpen extends MenuItems {
    /**
     * Overrided method of get level for current item.
     * @return level of item in menu.
     */
    @Override
    public int getLevel() {
        return 1;
    }

    /**
     * Overrided method of get info for current item.
     * @return information of menu item.
     */
    @Override
    public String getInfo() {
        return String.format("%-15s%s", "Open", "[open]");
    }
}
