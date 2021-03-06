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
    private final String name;

    /**
     * User login.
     */
    private final String login;

    /**
     * User email.
     */
    private final String email;

    /**
     * User create date.
     */
    private final Timestamp createDate;

    /**
     * Constructor of user class.
     * @param name user name.
     * @param login user login.
     * @param email user mail.
     * @param createDate create date of user.
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
}
