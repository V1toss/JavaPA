package vkaretko.models;

import java.sql.Timestamp;

/**
 * Class User.
 *
 * @author Karetko Victor.
 * @version 1.00.
 * @since 28.02.2017.
 */
public class User {
    /**
     * User name.
     */
    private String name;

    /**
     * User login.
     */
    private final String login;

    /**
     * User email.
     */
    private String email;

    /**
     * User create date.
     */
    private Timestamp createDate;

    /**
     * Constructor of user class.
     * @param name user name.
     * @param login user login.
     * @param email user mail.
     */
    public User(String name, String login, String email, Timestamp createDate) {
        this.name = name;
        this.login = login;
        this.email = email;
        this.createDate = createDate;
    }

    /**
     * Getter for name.
     * @return user name.
     */
    public String getName() {
        return this.name;
    }

    /**
     * Getter for login.
     * @return user login.
     */
    public String getLogin() {
        return this.login;
    }

    /**
     * Getter for email.
     * @return user emeil.
     */
    public String getEmail() {
        return this.email;
    }

    /**
     * Getter for create date.
     * @return user create date.
     */
    public Timestamp getCreateDate() {
        return this.createDate;
    }

    @Override
    public String toString() {
        return String.format("User{name=%s, login=%s, email=%s, createDate=%s", name, login, email, createDate);
    }
}
