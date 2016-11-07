package vkaretko.models;

/**
 * Class for creating Tasks
 * Extends from Item
 *
 * @author Karetko Victor
 * @version 1.00
 * @since 04.11.2016
 */
public class Task extends Item {

    /**
     * Constructor for creating Task
     * @param name name of task
     * @param description of task
     * @param create create time of task
     */
    public Task (String name, String description, long create) {
        super(name,description,create);
    }
}
