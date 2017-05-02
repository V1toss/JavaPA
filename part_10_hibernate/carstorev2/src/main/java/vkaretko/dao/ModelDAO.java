package vkaretko.dao;

import vkaretko.models.Model;

/**
 * Model DAO class.
 *
 * @author Karetko Victor.
 * @version 1.00.
 * @since 24.04.2017.
 */
public class ModelDAO extends AbstractDAO<Model> {

    /**
     * Dao instance.
     */
    private static final ModelDAO INSTANCE = new ModelDAO();

    /**
     * Getter for instance.
     * @return instance.
     */
    public static ModelDAO getInstance() {
        return INSTANCE;
    }

}
