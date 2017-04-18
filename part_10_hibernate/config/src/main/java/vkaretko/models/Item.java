package vkaretko.models;

import java.sql.Timestamp;

/**
 * Created by vitoss on 19.04.17.
 */
public class Item {

    private int id;

    private String login;

    private String password;

    private Timestamp created;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getLogin() {
        return login;
    }

    public void setLogin(String login) {
        this.login = login;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public Timestamp getCreated() {
        return created;
    }

    public void setCreated(Timestamp created) {
        this.created = created;
    }
}
