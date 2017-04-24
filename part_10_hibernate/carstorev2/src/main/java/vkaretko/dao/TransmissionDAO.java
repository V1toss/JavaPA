package vkaretko.dao;

import vkaretko.models.Transmission;

import java.util.Collections;
import java.util.List;

/**
 * Transmission DAO class.
 *
 * @author Karetko Victor.
 * @version 1.00.
 * @since 24.04.2017.
 */
public class TransmissionDAO extends AbstractDAO<Transmission>{

    private static final TransmissionDAO INSTANCE = new TransmissionDAO();

    public static TransmissionDAO getInstance() {
        return INSTANCE;
    }

    @Override
    public Transmission get(int id) {
        return persistGetAll(session -> Collections.singletonList(session.get(Transmission.class, id))).get(0);
    }

    @Override
    public List<Transmission> getAll() {
        return persistGetAll(session -> session.createQuery("from Transmission").list());
    }
}
