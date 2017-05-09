package vkaretko.repository;

import org.springframework.stereotype.Repository;
import vkaretko.models.Image;

/**
 * Image DAO class.
 *
 * @author Karetko Victor.
 * @version 1.00.
 * @since 08.05.2017.
 */
@Repository
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
