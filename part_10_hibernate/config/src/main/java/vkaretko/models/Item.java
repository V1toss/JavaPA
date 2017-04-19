package vkaretko.models;

import java.sql.Timestamp;

/**
 * Model Item. Represents items in tracker.
 *
 * @author Karetko Victor.
 * @version 1.00.
 * @since 28.02.2017.
 */
public class Item {

    /**
     * Item id.
     */
    private int id;
    /**
     * Item description.
     */
    private String desc;
    /**
     * Status of item.
     */
    private boolean done;
    /**
     * Create date of item.
     */
    private Timestamp created;

    /**
     * Getter item id.
     * @return item id.
     */
    public int getId() {
        return id;
    }

    /**
     * Setter for item id.
     * @param id id to set.
     */
    public void setId(int id) {
        this.id = id;
    }

    /**
     * Getter for item description.
     * @return item desription.
     */
    public String getDesc() {
        return desc;
    }

    /**
     * Setter for item description.
     * @param desc description.
     */
    public void setDesc(String desc) {
        this.desc = desc;
    }

    /**
     * Getter for item status.
     * @return true if finished, false otherwise.
     */
    public boolean getDone() {
        return done;
    }

    /**
     * Setter for item status.
     * @param done done.
     */
    public void setDone(boolean done) {
        this.done = done;
    }

    /**
     * Getter for item create date.
     * @return create date of item.
     */
    public Timestamp getCreated() {
        return created;
    }

    /**
     * Setter for create date of item.
     * @param created date to set.
     */
    public void setCreated(Timestamp created) {
        this.created = created;
    }
}
