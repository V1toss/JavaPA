package vkaretko;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import vkaretko.models.User;

import javax.naming.InitialContext;
import javax.naming.NamingException;
import javax.sql.DataSource;
import java.sql.PreparedStatement;
import java.sql.Connection;
import java.sql.SQLException;
import java.sql.ResultSet;
import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.List;
import java.util.NoSuchElementException;

/**
 * Class DBManager. Provding CRUD operations with DB.
 *
 * @author Karetko Victor.
 * @version 1.00.
 * @since 28.02.2017.
 */
public class DBManager {
    /**
     * DataSource for generating connections.
     */
    private static DataSource dataSource;

    /**
     * Logger for database errors.
     */
    private static final Logger LOG = LoggerFactory.getLogger(DBManager.class);

    /**
     * Static INSTANCE for Singleton realisation.
     */
    private static final DBManager INSTANCE = new DBManager();

    /**
     * Private constructor for DBManager singleton realization.
     */
    private DBManager() {
    }

    /**
     * Create connection to Database.
     * @return connection.
     */
    public static Connection getConnection() {
        Connection conn = null;
        try {
            if (dataSource == null) {
                dataSource = (DataSource) new InitialContext().lookup("java:comp/env/jdbc/users");
            }
            conn = dataSource.getConnection();
        } catch (SQLException | NamingException e) {
            LOG.error(e.getMessage(), e);
        }
        return conn;
    }

    /**
     * Getter for DBManager instance.
     * @return instance.
     */
    public static DBManager getInstance() {
        return INSTANCE;
    }

    /**
     * Adding users to database.
     * @param user user.
     */
    public void add(User user) {
        try (PreparedStatement st = getConnection().prepareStatement("INSERT INTO users(name, login, email, create_date) values(?,?,?,?)")) {
            st.setString(1, user.getName());
            st.setString(2, user.getLogin());
            st.setString(3, user.getEmail());
            st.setTimestamp(4, new Timestamp(System.currentTimeMillis()));
            st.executeUpdate();
        } catch (SQLException e) {
            LOG.error(e.getMessage(), e);
        }
    }

    /**
     * Updating user in database.
     * @param user user.
     */
    public void update(User user) {
        try (PreparedStatement st = getConnection().prepareStatement("UPDATE users SET name=?,email=?,create_date=? WHERE login=?")) {
            st.setString(1, user.getName());
            st.setString(2, user.getEmail());
            st.setTimestamp(3, new Timestamp(System.currentTimeMillis()));
            st.setString(4, user.getLogin());
            st.executeUpdate();
        } catch (SQLException e) {
            LOG.error(e.getMessage(), e);
        }
    }

    /**
     * Delete user from DB.
     * @param login login of user to delete.
     */
    public void delete(String login) {
        try (PreparedStatement st = getConnection().prepareStatement("DELETE FROM users WHERE login=?")) {
            st.setString(1, login);
            st.executeUpdate();
        } catch (SQLException e) {
            LOG.error(e.getMessage(), e);
        }
    }

    /**
     * Get all users from DB.
     * @return list of users.
     */
    public List<User> getAll() {
        List<User> result = new ArrayList<>();
        try (PreparedStatement st = getConnection().prepareStatement("SELECT * FROM users");
             ResultSet rs = st.executeQuery()) {
            while (rs.next()) {
                result.add(new User(rs.getString("name"), rs.getString("login"),
                        rs.getString("email"), rs.getTimestamp("create_date")));
            }
        } catch (SQLException e) {
            LOG.error(e.getMessage(), e);
        }
        return result;
    }

    /**
     * Search user by Login in database.
     * @return user.
     * @param login to search.
     */
    public User searchByLogin(String login) {
        try (PreparedStatement st = getConnection().prepareStatement("SELECT * FROM users WHERE login=?")) {
            st.setString(1, login);
            try (ResultSet rs = st.executeQuery()) {
                if (rs.next()) {
                    return new User(rs.getString("name"), rs.getString("login"),
                            rs.getString("email"), rs.getTimestamp("create_date"));
                }
            }

        } catch (SQLException e) {
            LOG.error(e.getMessage(), e);
        }
        throw new NoSuchElementException("login not found");
    }

}
