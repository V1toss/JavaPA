package vkaretko.dao;

import vkaretko.models.Body;

import java.util.Collections;
import java.util.List;

/**
 * Body DAO class.
 *
 * @author Karetko Victor.
 * @version 1.00.
 * @since 24.04.2017.
 */
public class BodyDAO extends AbstractDAO<Body>{

    private static final BodyDAO INSTANCE = new BodyDAO();

    public static BodyDAO getInstance() {
        return INSTANCE;
    }

    @Override
    public Body get(int id) {
        return persistGetAll(session -> Collections.singletonList(session.get(Body.class, id))).get(0);
    }

    @Override
    public List<Body> getAll() {
        return persistGetAll(session -> session.createQuery("from Body").list());
    }
}
