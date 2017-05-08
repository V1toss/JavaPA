package vkaretko.models;

/**
 * Model User.
 * Created by vitoss.
 *
 * @author Karetko Victor.
 * @version 1.00.
 * @since 06.05.17 12:53.
 */
public class User {

    /**
     * User id.
     */
    private int id;

    /**
     * User name.
     */
    private String name;

    /**
     * Getter for id.
     * @return id of user.
     */
    public int getId() {
        return id;
    }

    /**
     * Setter for id.
     * @param id id to set.
     */
    public void setId(int id) {
        this.id = id;
    }

    /**
     * Getter for user name.
     * @return users name.
     */
    public String getName() {
        return name;
    }

    /**
     * Setter for user name.
     * @param name name of user.
     */
    public void setName(String name) {
        this.name = name;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        User user = (User) o;

        if (id != user.id) return false;
        return name != null ? name.equals(user.name) : user.name == null;
    }

    @Override
    public int hashCode() {
        int result = id;
        result = 31 * result + (name != null ? name.hashCode() : 0);
        return result;
    }
}

