package vkaretko.dao;

import vkaretko.models.Image;

import java.util.Collections;
import java.util.List;

/**
 * Image DAO class.
 *
 * @author Karetko Victor.
 * @version 1.00.
 * @since 24.04.2017.
 */
public class ImageDAO extends AbstractDAO<Image>{

    private static final ImageDAO INSTANCE = new ImageDAO();

    public static ImageDAO getInstance() {
        return INSTANCE;
    }

}
