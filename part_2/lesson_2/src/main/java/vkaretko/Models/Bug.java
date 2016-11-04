package vkaretko.Models;

/**
 * Class for creating Bug-reports
 * Extends from Item
 *
 * @author Karetko Victor
 * @version 1.00
 * @since 04.11.2016
 */
public class Bug extends Item{

    public Bug (String name, String description, long create) {
        super(name,description,create);
    }
}
