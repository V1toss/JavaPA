package vkaretko.interfaces;

import java.util.List;

/**
 * Interface Get for getting menu lists.
 *
 * @author Karetko Victor
 * @version 1.00
 * @since 08.12.2016
 */
public interface Get {
    /**
     * Method for getting list of menu items.
     * @return list of menu items
     */
    List<MenuItems> getMenuItems();
}
