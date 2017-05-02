package vkaretko.dao;

import vkaretko.models.Drive;

/**
 * Drive DAO class.
 *
 * @author Karetko Victor.
 * @version 1.00.
 * @since 24.04.2017.
 */
public class DriveDAO extends AbstractDAO<Drive> {

    /**
     * Dao instance.
     */
    private static final DriveDAO INSTANCE = new DriveDAO();

    /**
     * Getter for instance.
     * @return instance.
     */
    public static DriveDAO getInstance() {
        return INSTANCE;
    }

}
