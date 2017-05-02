package vkaretko.dao;

import vkaretko.models.Engine;

/**
 * Engine DAO class.
 *
 * @author Karetko Victor.
 * @version 1.00.
 * @since 24.04.2017.
 */
public class EngineDAO extends AbstractDAO<Engine> {

    /**
     * Dao instance.
     */
    private static final EngineDAO INSTANCE = new EngineDAO();

    /**
     * Getter for instance.
     * @return instance.
     */
    public static EngineDAO getInstance() {
        return INSTANCE;
    }
}
