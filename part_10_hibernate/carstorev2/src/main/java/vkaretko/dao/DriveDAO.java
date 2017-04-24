package vkaretko.dao;

import vkaretko.models.Drive;

import java.util.Collections;
import java.util.List;

/**
 * Drive DAO class.
 *
 * @author Karetko Victor.
 * @version 1.00.
 * @since 24.04.2017.
 */
public class DriveDAO extends AbstractDAO<Drive>{

    private static final DriveDAO INSTANCE = new DriveDAO();

    public static DriveDAO getInstance() {
        return INSTANCE;
    }

    @Override
    public Drive get(int id) {
        return persistGetAll(session -> Collections.singletonList(session.get(Drive.class, id))).get(0);
    }

    @Override
    public List<Drive> getAll() {
        return persistGetAll(session -> session.createQuery("from Drive").list());
    }
}
