package vkaretko.dao;

import vkaretko.models.Brand;

import java.util.Collections;
import java.util.List;

/**
 * Brand DAO class.
 *
 * @author Karetko Victor.
 * @version 1.00.
 * @since 24.04.2017.
 */
public class BrandDAO extends AbstractDAO<Brand>{

    private static final BrandDAO INSTANCE = new BrandDAO();

    public static BrandDAO getInstance() {
        return INSTANCE;
    }

}
