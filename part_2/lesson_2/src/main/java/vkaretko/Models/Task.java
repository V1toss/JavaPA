package vkaretko.Models;

/**
 * Class for creating Tasks
 * Extends from Item
 *
 * @author Karetko Victor
 * @version 1.00
 * @since 04.11.2016
 */
public class Task extends Item {

    public Task (String name, String description, long create) {
        super(name,description,create);
    }
}
