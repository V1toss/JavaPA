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
import java.util.Properties;

/**
 * Class DBManager. Connecting to database and provding CRUD operations.
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
     * Adding offers to database.
     * @param user user.
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
