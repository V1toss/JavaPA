package vkaretko;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import vkaretko.models.User;

import java.sql.PreparedStatement;
import java.sql.Connection;
import java.sql.SQLException;
import java.sql.ResultSet;
import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.List;

/**
 * Class DBManager. Provding CRUD operations with DB.
 *
 * @author Karetko Victor.
 * @version 1.00.
 * @since 28.02.2017.
 */
public class DBManager {
    /**
     * Logger for database errors.
     */
    private static final Logger LOG = LoggerFactory.getLogger(DBManager.class);

    /**
     * Static instance for Singleton realisation.
     */
    private static final DBManager instance = new DBManager();

    /**
     * Private constructor for DBManager singleton realization.
     */
    private DBManager() {
    }

    /**
     * Getter for instance.
     * @return instance of DBManager.
     */
    public static DBManager getInstance() {
        return instance;
    }

    /**
     * Adding offers to database.
     * @param user user.
     * @param conn connection from servlet.
     */
    public void add(User user, Connection conn) {
        try (PreparedStatement st = conn.prepareStatement("INSERT INTO users(name, login, email, create_date) values(?,?,?,?)")) {
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
     * Adding offers to database.
     * @param user user.
     * @param conn connection from servlet.
     */
    public void update(User user, Connection conn) {
        try (PreparedStatement st = conn.prepareStatement("UPDATE users SET name=?,email=?,create_date=? WHERE login=?")) {
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
     * Adding offers to database.
     * @param login login of user to delete.
     * @param conn connection from servlet.
     */
    public void delete(String login, Connection conn) {
        try (PreparedStatement st = conn.prepareStatement("DELETE FROM users WHERE login=?")) {
            st.setString(1, login);
            st.executeUpdate();
        } catch (SQLException e) {
            LOG.error(e.getMessage(), e);
        }
    }

    /**
     * Saving offers to log.
     * @return list of users.
     * @param conn connection from servlet.
     */
    public List<User> getAll(Connection conn) {
        List<User> result = new ArrayList<>();
        try (PreparedStatement st = conn.prepareStatement("SELECT * FROM users");
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
}
