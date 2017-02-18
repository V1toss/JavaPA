package vkaretko.models;

/**
 * Base class for creating Items, like Tasks and Bug-reports
 *
 * @author Karetko Victor
 * @version 1.00
 * @since 18.02.2017
 */
public class Item {
    private int id;
    private String name;
    private String description;
    private long create;

    /**
     * Constructor of Item class
     * @param name name of item
     * @param description of item
     * @param create create time of item
     */
    public Item (String name, String description, long create) {
        this.name = name;
        this.description = description;
        this.create = create;
    }

    /**
     * Getter method for name field
     * @return name
     */
    public String getName() {
        return this.name;
    }

    /**
     * Getter method for description field
     * @return description
     */
    public String getDescription() {
        return this.description;
    }

    /**
     * Getter method for create field
     * @return create time
     */
    public long getCreate() {
        return this.create;
    }

    /**
     * Getter method for Id field
     * @return id
     */
    public int getId() {
        return this.id;
    }

    /**
     * Setter method for id field
     * @param id string for set id
     */
    public void setId (int id) {
        this.id = id;
    }

    /**
     * Setter method for name field
     * @param name string for set name
     */
    public void setName(String name) {
        this.name = name;
    }

    /**
     * Setter method for name field
     * @param description string for set description
     */
    public void setDescription(String description) {
        this.description = description;
    }

    /**
     * Setter method for create field
     * @param create number for set create
     */
    public void setCreate(long create) {
        this.create = create;
    }
}
