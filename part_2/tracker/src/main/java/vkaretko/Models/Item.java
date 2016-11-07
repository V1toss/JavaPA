package vkaretko.models;

/**
 * Base class for creating Items, like Tasks and Bug-reports
 *
 * @author Karetko Victor
 * @version 1.00
 * @since 04.11.2016
 */
public class Item {
    private String id;
    private String name;
    private String description;
    private long create;
    private Comment[] comments = new Comment[10];
    private int commentPosition = 0;

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
    public String getId() {
        return this.id;
    }

    /**
     * Setter method for id field
     * @param id string for set id
     */
    public void setId (String id) {
        this.id = id;
    }

    /**
     * Method for adding comment to item
     * @param comment comment for adding
     */
    public void addComment (Comment comment) {
        this.comments[commentPosition++] = comment;
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

    /**
     * Getter method for comments
     * @return array of comments
     */
    public Comment[] getComments() {
        Comment[] result = new Comment[this.commentPosition];
        for (int index = 0; index != this.commentPosition; index++) {
            result[index] = comments[index];
        }
        return result;
    }
}
