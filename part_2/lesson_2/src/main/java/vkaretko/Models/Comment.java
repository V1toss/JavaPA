package vkaretko.Models;

/**
 * Class for creating Tasks
 * Extends from Item
 *
 * @author Karetko Victor
 * @version 1.00
 * @since 04.11.2016
 */
public class Comment {
    private String comment;

    public Comment (String comment) {
        this.comment = comment;
    }

    public String getComment() {
        return this.comment;
    }

    public void setComment(String comment) {
        this.comment = comment;
    }


}
