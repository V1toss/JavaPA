package vkaretko.dao;

import vkaretko.models.Order;

/**
 * Order DAO class.
 *
 * @author Karetko Victor.
 * @version 1.00.
 * @since 24.04.2017.
 */
public class OrderDAO extends AbstractDAO<Order> {

    /**
     * Dao instance.
     */
    private static final OrderDAO INSTANCE = new OrderDAO();

    /**
     * Getter for instance.
     * @return instance.
     */
    public static OrderDAO getInstance() {
        return INSTANCE;
    }

}
