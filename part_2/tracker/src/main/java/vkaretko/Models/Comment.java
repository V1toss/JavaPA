package vkaretko.models;

/**
 * Class for creating Comment
 *
 * @author Karetko Victor
 * @version 1.00
 * @since 05.11.2016
 */
public class Comment {
    private String comment;

    /**
     * Constructor for creating Comment
     * @param comment string line of added comment
     */
    public Comment (String comment) {
        this.comment = comment;
    }

    /**
     * Getter method for comment field
     * @return comment
     */
    public String getComment() {
        return this.comment;
    }

    /**
     * Setter method for comment field
     * @param comment line for setting comment
     */
    public void setComment(String comment) {
        this.comment = comment;
    }


}
