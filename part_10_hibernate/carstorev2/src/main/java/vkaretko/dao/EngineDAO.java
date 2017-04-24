package vkaretko.dao;

import vkaretko.models.Engine;

import java.util.Collections;
import java.util.List;

/**
 * Engine DAO class.
 *
 * @author Karetko Victor.
 * @version 1.00.
 * @since 24.04.2017.
 */
public class EngineDAO extends AbstractDAO<Engine>{

    private static final EngineDAO INSTANCE = new EngineDAO();

    public static EngineDAO getInstance() {
        return INSTANCE;
    }

    @Override
    public Engine get(int id) {
        return persistGetAll(session -> Collections.singletonList(session.get(Engine.class, id))).get(0);
    }

    @Override
    public List<Engine> getAll() {
        return persistGetAll(session -> session.createQuery("from Engine").list());
    }
}
