package vkaretko.interfaces;

import java.util.ArrayList;
import java.util.List;

/**
 * Abstract class MenuItems is base class for all menu items.
 *
 * @author Karetko Victor
 * @version 1.00
 * @since 07.12.2016
 */
public abstract class MenuItems implements Add, Get, Information, NestingLevel {
    /**
     * List of items.
     */
    private ArrayList<MenuItems> menu = new ArrayList<>();

    /**
     * Overrided method of adding menu item to list.
     * @param item item to add.
     */
    @Override
    public void addMenuItem(MenuItems item) {
        this.menu.add(item);
    }

    /**
     * Overrided method for getting list of menu items.
     * @return
     */
    @Override
    public List<MenuItems> getMenuItems() {
        return this.menu;
    }
}
