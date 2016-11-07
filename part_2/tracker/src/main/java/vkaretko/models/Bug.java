package vkaretko.models;

/**
 * Class for creating Bug-reports
 * Extends from Item
 *
 * @author Karetko Victor
 * @version 1.00
 * @since 04.11.2016
 */
public class Bug extends Item{

    /**
     * Constructor for creating bug reports
     * @param name name of bug report
     * @param description of bug report
     * @param create create time of bug report
     */
    public Bug (String name, String description, long create) {
        super(name,description,create);
    }
}
