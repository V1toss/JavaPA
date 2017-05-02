package vkaretko.dao;

import vkaretko.models.Transmission;

/**
 * Transmission DAO class.
 *
 * @author Karetko Victor.
 * @version 1.00.
 * @since 24.04.2017.
 */
public class TransmissionDAO extends AbstractDAO<Transmission> {

    /**
     * Dao instance.
     */
    private static final TransmissionDAO INSTANCE = new TransmissionDAO();

    /**
     * Getter for instance.
     * @return instance.
     */
    public static TransmissionDAO getInstance() {
        return INSTANCE;
    }

}
