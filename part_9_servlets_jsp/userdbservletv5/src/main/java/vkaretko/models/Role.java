package vkaretko.models;

/**
 * Class
 *
 * @author Karetko Victor.
 * @version 1.00.
 * @since 27.03.2017.
 */
public class Role {
    /**
     * Role id.
     */
    private int id;

    /**
     * Name of role.
     */
    private String name;

    /**
     * Constructor of role
     * @param id role id.
     * @param name name of role.
     */
    public Role(int id, String name) {
        this.id = id;
        this.name = name;
    }

    /**
     * Getter for role id.
     * @return id.
     */
    public int getId() {
        return id;
    }

    /**
     * Getter for name of role.
     * @return name of role.
     */
    public String getName() {
        return name;
    }
}
