package vkaretko;

import java.util.Calendar;

/**
 * Model User for creating Users.
 * @author Karetko Victor
 * @version 1.00
 * @since 24.12.2016
 */
public class User {
    /**
     * Name of user.
     */
    private final String name;
     /**
     * Amount of children.
     */
    private final int children;
    /**
     * Birthday of User.
     */
    private final Calendar birthday;

    /**
     * Constructor of User class.
     * @param name name of user.
     * @param children amount of children.
     * @param birthday birthday of user.
     */
    public User(String name, int children, Calendar birthday) {
        this.name = name;
        this.children = children;
        this.birthday = birthday;
    }
    /**
     * Getter for name.
     * @return name.
     */
    public String getName() {
        return name;
    }
    /**
     * Getter for childre.
     * @return children.
     */
    public int getChildren() {
        return children;
    }
    /**
     * Getter for birthday.
     * @return birthday.
     */
    public Calendar getBirthday() {
        return birthday;
    }
}
