package vkaretko;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.io.IOException;
import java.io.InputStream;
import java.sql.*;
import java.util.Properties;

/**
 * Class ManagerDB.
 *
 * @author Karetko Victor.
 * @version 1.00.
 * @since 20.02.2017.
 */
public class DBManager {
    /**
     * Properties for db connection.
     */
    private final Properties prs = new Properties();

    /**
     * Logger for database errors.
     */
    private static final Logger LOG = LoggerFactory.getLogger(DBManager.class);

    /**
     * Connection for db.
     */
    private Connection conn = null;

    /**
     * Properties file name.
     */
    private final String properties = "db.properties";

    /**
     * Method load properties for db.
     */
    public void loadProperties() {
        try (InputStream in = getClass().getClassLoader().getResourceAsStream(properties)) {
            prs.load(in);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    /**
     * Method establish connection to db.
     */
    public void connectToDB() {
        try {
            this.conn = DriverManager.getConnection(prs.getProperty("url"),
                    prs.getProperty("user"), prs.getProperty("password"));
        } catch (SQLException sqe) {
            LOG.error(sqe.getMessage(), sqe);
        }
    }

    /**
     * Method close connection to db.
     */
    public void disconnect() {
        try {
            conn.close();
        } catch (SQLException e) {
            LOG.error(e.getMessage(), e);
        } finally {
            if (conn != null) {
                try {
                    conn.close();
                } catch (SQLException e) {
                    LOG.error(e.getMessage(), e);
                }
            }
        }
    }

    /**
     * Adding offers to database.
     * @param offer_id offer id.
     * @param link link of offer.
     * @param description description of offer.
     * @param last_update last update of offer.
     */
    public void add(int offer_id, String link, String description, Timestamp last_update) {
        try (PreparedStatement st = conn.prepareStatement("INSERT INTO offers(offer_id, link, description, last_update) values(?,?,?,?) ON CONFLICT DO NOTHING;")) {
            st.setInt(1, offer_id);
            st.setString(2, link );
            st.setString(3, description);
            st.setTimestamp(4, last_update);
            st.executeUpdate();
        } catch (SQLException e) {
            LOG.error(e.getMessage(), e);
        }
    }

}
