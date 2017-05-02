package vkaretko.dao;

import vkaretko.models.Car;

/**
 * Car DAO class.
 *
 * @author Karetko Victor.
 * @version 1.00.
 * @since 24.04.2017.
 */
public class CarDAO extends AbstractDAO<Car> {

    /**
     * Dao instance.
     */
    private static final CarDAO INSTANCE = new CarDAO();

    /**
     * Getter for instance.
     * @return instance.
     */
    public static CarDAO getInstance() {
        return INSTANCE;
    }

}
