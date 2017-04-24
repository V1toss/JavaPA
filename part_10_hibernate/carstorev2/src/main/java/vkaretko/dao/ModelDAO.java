package vkaretko.dao;

import vkaretko.models.Model;

import java.util.Collections;
import java.util.List;

/**
 * Model DAO class.
 *
 * @author Karetko Victor.
 * @version 1.00.
 * @since 24.04.2017.
 */
public class ModelDAO extends AbstractDAO<Model>{

    private static final ModelDAO INSTANCE = new ModelDAO();

    public static ModelDAO getInstance() {
        return INSTANCE;
    }

    @Override
    public Model get(int id) {
        return persistGetAll(session -> Collections.singletonList(session.get(Model.class, id))).get(0);
    }

    @Override
    public List<Model> getAll() {
        return persistGetAll(session -> session.createQuery("from Model").list());
    }
}
