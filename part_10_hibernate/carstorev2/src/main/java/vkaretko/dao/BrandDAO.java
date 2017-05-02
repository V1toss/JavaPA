package vkaretko.dao;

import vkaretko.models.Brand;

/**
 * Brand DAO class.
 *
 * @author Karetko Victor.
 * @version 1.00.
 * @since 24.04.2017.
 */
public class BrandDAO extends AbstractDAO<Brand> {

    /**
     * Dao instance.
     */
    private static final BrandDAO INSTANCE = new BrandDAO();

    /**
     * Getter for instance.
     * @return instance.
     */
    public static BrandDAO getInstance() {
        return INSTANCE;
    }

}
