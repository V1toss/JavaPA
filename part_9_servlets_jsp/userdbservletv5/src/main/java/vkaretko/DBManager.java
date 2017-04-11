package vkaretko;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import vkaretko.models.Role;
import vkaretko.models.User;

import javax.naming.Context;
import javax.naming.InitialContext;
import javax.naming.NamingException;
import java.beans.PropertyVetoException;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.sql.Timestamp;
import java.sql.ResultSet;
import java.util.*;
import com.mchange.v2.c3p0.ComboPooledDataSource;

/**
 * Class DBManager. Providing CRUD operations with DB.
 *
 * @author Karetko Victor.
 * @version 1.00.
 * @since 28.02.2017.
 */
public class DBManager {
    /**
     * DataSource for generating connections.
     */
    private static ComboPooledDataSource dataSource;

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
    private static Connection getConnection() {
        Connection conn = null;
        try {
            if (dataSource == null) {
                createDataSource();
            }
            conn = dataSource.getConnection();
        } catch (SQLException e) {
            LOG.error(e.getMessage(), e);
        }
        return conn;
    }

    /**
     * Init data source.
     */
    private static void createDataSource() {
        Properties prop = new Properties();
        dataSource = new ComboPooledDataSource();
        try {
            prop.load(new FileInputStream(DBManager.class.getClassLoader().getResource("db.properties").getPath()));
        } catch (IOException e) {
            LOG.error(e.getMessage());
        }
        try {
            dataSource.setDriverClass(prop.getProperty("driverClass"));
        } catch (PropertyVetoException e) {
            LOG.error(e.getMessage());
        }
        dataSource.setJdbcUrl(prop.getProperty("url"));
        dataSource.setUser(prop.getProperty("user"));
        dataSource.setPassword(prop.getProperty("password"));
        dataSource.setMaxPoolSize(Integer.valueOf(prop.getProperty("maxActive")));
        dataSource.setMaxIdleTime(Integer.valueOf(prop.getProperty("maxIdle")));
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
     * Adding roles to database.
     * @param role role.
     */
    public void addRole(String role) {
        try (PreparedStatement st = getConnection().prepareStatement("INSERT INTO roles(role) values(?)")) {
            st.setString(1, role);
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
     * Delete role from DB.
     * @param id id of role.
     */
    public void deleteRole(int id) {
        try (PreparedStatement st = getConnection().prepareStatement("DELETE FROM roles WHERE role_id=?")) {
            st.setInt(1, id);
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
                        rs.getString("password"), new Role(rs.getInt("role_id"), rs.getString("role"))));
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
                            rs.getString("password"), new Role(rs.getInt("role_id"), rs.getString("role")));
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
     * Get role from db.
     * @param id role.
     * @return user.
     */
    public Role getRoleById(int id) {
        Role result = null;
        for (Role role : getRoles()) {
            if (role.getId() == id) {
                result = role;
                break;
            }
        }
        return result;
    }

    /**
     * Get all roles from DB.
     * @return list of roles.
     */
    public List<Role> getRoles() {
        List<Role> result = new ArrayList<>();
        try (PreparedStatement st = getConnection().prepareStatement("SELECT * FROM roles");
             ResultSet rs = st.executeQuery()) {
            while (rs.next()) {
                result.add(new Role(rs.getInt("role_id"), rs.getString("role")));
            }
        } catch (SQLException e) {
            LOG.error(e.getMessage(), e);
        }
        return result;
    }

}
