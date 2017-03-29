package vkaretko;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import vkaretko.models.Role;
import vkaretko.models.User;

import javax.naming.InitialContext;
import javax.naming.NamingException;
import javax.sql.DataSource;
import java.sql.*;
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
        try (PreparedStatement st = getConnection().prepareStatement("INSERT INTO users(name, login, email, create_date, password, role_id) values(?,?,?,?,?,?)")) {
            st.setString(1, user.getName());
            st.setString(2, user.getLogin());
            st.setString(3, user.getEmail());
            st.setTimestamp(4, new Timestamp(System.currentTimeMillis()));
            st.setString(5, user.getPassword());
            st.setInt(6, user.getRole().getId());
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
        try (PreparedStatement st = getConnection().prepareStatement("UPDATE users SET name=?,email=?,create_date=?,password=?,role_id=? WHERE login=?")) {
            st.setString(1, user.getName());
            st.setString(2, user.getEmail());
            st.setTimestamp(3, new Timestamp(System.currentTimeMillis()));
            st.setString(4, user.getPassword());
            st.setInt(5, user.getRole().getId());
            st.setString(6, user.getLogin());
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
        try (PreparedStatement st = getConnection().prepareStatement("SELECT u.name, u.login, u.email, u.create_date, u.password, r.role_id, r.role FROM users as u inner join roles as r on u.role_id = r.role_id");
             ResultSet rs = st.executeQuery()) {
            while (rs.next()) {
                result.add(new User(rs.getString("name"), rs.getString("login"),
                        rs.getString("email"), rs.getTimestamp("create_date"),
                        rs.getString("password"), new Role(rs.getInt("role_id"),rs.getString("role"))));
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
        try (PreparedStatement st = getConnection().prepareStatement("SELECT u.name, u.login, u.email, u.create_date, u.password, r.role_id, r.role FROM users as u inner join roles as r on u.role_id = r.role_id where u.login=?")) {
            st.setString(1, login);
            try (ResultSet rs = st.executeQuery()) {
                if (rs.next()) {
                    return new User(rs.getString("name"), rs.getString("login"),
                            rs.getString("email"), rs.getTimestamp("create_date"),
                            rs.getString("password"), new Role(rs.getInt("role_id"),rs.getString("role")));
                }
            }
        } catch (SQLException e) {
            LOG.error(e.getMessage(), e);
        }
        throw new NoSuchElementException("login not found");
    }

    /**
     * Get user from db.
     * @param login login of user.
     * @param password password of user.
     * @return user.
     */
    public User getUser(String login, String password) {
        User result = null;
        for (User user : getAll()) {
            if (user.getLogin().equals(login) && user.getPassword().equals(password)) {
                result = user;
                break;
            }
        }
        return result;
    }

    /**
     * Get all users from DB.
     * @return list of users.
     */
    public List<Role> getRoles() {
        List<Role> result = new ArrayList<>();
        try (PreparedStatement st = getConnection().prepareStatement("SELECT * FROM roles");
             ResultSet rs = st.executeQuery()) {
            while (rs.next()) {
                result.add(new Role(rs.getInt("role_id"),rs.getString("role")));
            }
        } catch (SQLException e) {
            LOG.error(e.getMessage(), e);
        }
        return result;
    }

}
