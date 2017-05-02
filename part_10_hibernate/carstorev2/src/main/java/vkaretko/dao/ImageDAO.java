package vkaretko.dao;

import vkaretko.models.Image;

/**
 * Image DAO class.
 *
 * @author Karetko Victor.
 * @version 1.00.
 * @since 24.04.2017.
 */
public class ImageDAO extends AbstractDAO<Image> {

    /**
     * Dao instance.
     */
    private static final ImageDAO INSTANCE = new ImageDAO();

    /**
     * Getter for instance.
     * @return instance.
     */
    public static ImageDAO getInstance() {
        return INSTANCE;
    }

}
