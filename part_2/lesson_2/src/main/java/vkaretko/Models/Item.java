package vkaretko.Models;

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

    public Item () {
    }

    public Item (String name, String description, long create) {
        this.name = name;
        this.description = description;
        this.create = create;
    }

    public String getName() {
        return this.name;
    }

    public String getDescription() {
        return this.description;
    }

    public long getCreate() {
        return this.create;
    }

    public String getId() {
        return this.id;
    }

    public void setId (String id) {
        this.id = id;
    }

    public void addComment (Comment comment) {
        this.comments[commentPosition++] = comment;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public void setCreate(long create) {
        this.create = create;
    }

    public Comment[] getComments() {
        return comments;
    }
}
