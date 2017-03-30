package vkaretko.models;

import java.util.Objects;

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

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Role role = (Role) o;
        return id == role.id &&
                Objects.equals(name, role.name);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, name);
    }
}
