package vkaretko.dao;

import vkaretko.models.Car;

import java.util.Collections;
import java.util.List;

/**
 * Car DAO class.
 *
 * @author Karetko Victor.
 * @version 1.00.
 * @since 24.04.2017.
 */
public class CarDAO extends AbstractDAO<Car>{

    private static final CarDAO INSTANCE = new CarDAO();

    public static CarDAO getInstance() {
        return INSTANCE;
    }

    @Override
    public Car get(int id) {
        return persistGetAll(session -> Collections.singletonList(session.get(Car.class, id))).get(0);
    }

    @Override
    public List<Car> getAll() {
        return persistGetAll(session -> session.createQuery("from Car").list());
    }
}
