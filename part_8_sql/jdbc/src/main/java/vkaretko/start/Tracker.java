package vkaretko.start;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import vkaretko.models.Item;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

/**
 * Part 2. OOP
 * Lesson 2. Encapsulation.
 * Task 1. Implement a class Tracker.
 * This class is used as a repository for items.
 * It must have methods: add, edit, delete, get all items, addComments.
 *
 * @author Karetko Victor
 * @version 1.01
 * @since 18.02.2017
 */
public class Tracker {

    private static final Logger Log = LoggerFactory.getLogger(SQLStorage.class);
    private Connection conn = null;

    public void connectToDB() {
        String url = "jdbc:postgresql://localhost:5432/tracker";
        String username = "postgres";
        String password = "123";
        try {
            this.conn = DriverManager.getConnection(url, username, password);
        } catch (SQLException e) {
            Log.error(e.getMessage(), e);
        }
    }

    public void disconnect() {
        try {
            conn.close();
        } catch (SQLException e) {
            Log.error(e.getMessage(), e);
        } finally {
            if (conn != null) {
                try {
                    conn.close();
                } catch (SQLException e) {
                    Log.error(e.getMessage(), e);
                }
            }
        }
    }

    /**
     * Method for adding item to array of items
     * @param item item for adding
     */
    public void add (Item item) {
        PreparedStatement st = null;
        try {
            st = conn.prepareStatement("INSERT INTO items (name, description, create_date) values(?,?,?)");
            st.setString(1,item.getName());
            st.setString(2,item.getDescription());
            st.setTimestamp(3,new Timestamp(item.getCreate()));
            st.executeUpdate();
        } catch (SQLException e) {
            Log.error(e.getMessage(), e);
        } finally {
            try {
                st.close();
            } catch (SQLException e) {
                Log.error(e.getMessage(), e);
            }
        }
    }
    /**
     * Method for editing item
     * @param item item for edit
     */
    public void edit (Item item) {
        PreparedStatement st = null;
        try {
            st = conn.prepareStatement("UPDATE items SET name=?,description=?,create_date=? WHERE item_id=?");
            st.setString(1,item.getName());
            st.setString(2,item.getDescription());
            st.setTimestamp(3,new Timestamp(item.getCreate()));
            st.setInt(4,item.getId());
            st.executeUpdate();
        } catch (SQLException e) {
            Log.error(e.getMessage(), e);
        } finally {
            try {
                st.close();
            } catch (SQLException e) {
                Log.error(e.getMessage(), e);
            }
        }
    }

    /**
     * Method for deleting item
     * @param id id of item for deleting
     */
    public void delete (int id) {
        PreparedStatement st = null;
        try {
            st = conn.prepareStatement("DELETE FROM items WHERE item_id=?");
            st.setInt(1, id);
            st.executeUpdate();
        } catch (SQLException e) {
            Log.error(e.getMessage(), e);
        } finally {
            try {
                st.close();
            } catch (SQLException e) {
                Log.error(e.getMessage(), e);
            }
        }
    }

    /**
     * Method for finding item by Id key
     * @param id id key for searching
     * @return founded item
     */
    public Item findById (int id) {
        Item result = null;
        PreparedStatement st = null;
        ResultSet rs = null;
        try {
            st = conn.prepareStatement("SELECT * FROM items WHERE item_id=?");
            st.setInt(1, id);
            rs = st.executeQuery();
            if (rs.next()) {
                result = new Item(rs.getString("name"),rs.getString("description"), rs.getTimestamp("create_date").getTime());
                result.setId(rs.getInt("item_id"));
            }
        } catch (SQLException e) {
            Log.error(e.getMessage(), e);
        } finally {
            try {
                st.close();
                rs.close();
            } catch (SQLException e) {
                Log.error(e.getMessage(), e);
            }
        }
        return result;
    }

    /**
     * Method for get all items
     * @return array of items
     */
    public List<Item> getAll() {
        List<Item> result = new ArrayList<>();
        PreparedStatement st = null;
        ResultSet rs = null;
        try {
            st = conn.prepareStatement("SELECT * FROM items");
            rs = st.executeQuery();
            while (rs.next()) {
                Item item = new Item(rs.getString("name"),rs.getString("description"), rs.getTimestamp("create_date").getTime());
                item.setId(rs.getInt("item_id"));
                result.add(item);
            }
        } catch (SQLException e) {
            Log.error(e.getMessage(), e);
        } finally {
            try {
                st.close();
                rs.close();
            } catch (SQLException e) {
                Log.error(e.getMessage(), e);
            }
        }
        return result;
    }

    /**
     * Method for adding comment to item
     * @param id id of item for adding comment
     * @param comment new comment for item
     */
    public void addComment (int id, String comment) {
        PreparedStatement st = null;
        try {
            st = conn.prepareStatement("INSERT INTO comments (comment, item_id) values(?,?)");
            st.setString(1, comment);
            st.setInt(2, id);
            st.executeUpdate();
        } catch (SQLException e) {
            Log.error(e.getMessage(), e);
        } finally {
            try {
                st.close();
            } catch (SQLException e) {
                Log.error(e.getMessage(), e);
            }
        }
    }

    /**
     * Method for adding comment to item
     * @param id id of item for adding comment
     */
    public List<String> getComments (int id) {
        List<String> result = new ArrayList<>();
        PreparedStatement st = null;
        ResultSet rs = null;
        try {
            st = conn.prepareStatement("SELECT comment FROM comments WHERE item_id=?");
            st.setInt(1, id);
            rs = st.executeQuery();
            while (rs.next()) {
                result.add(rs.getString("comment"));
            }
        } catch (SQLException e) {
            Log.error(e.getMessage(), e);
        } finally {
            try {
                st.close();
                rs.close();
            } catch (SQLException e) {
                Log.error(e.getMessage(), e);
            }
        }
        return result;
    }
}
