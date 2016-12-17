package vkaretko;

/**
 * Abstract class Base.
 * @author Karetko Victor
 * @version 1.00
 * @since 16.12.2016
 */
public abstract class Base {
    /**
     * Id of base.
     */
    private String id;
    /**
     * Get id of item.
     * @return id.
     */
    public String getId() {
        return this.id;
    }
    /**
     * Set if of item.
     * @param id id to set.
     */
    public void setId(String id) {
        this.id = id;
    }
}
