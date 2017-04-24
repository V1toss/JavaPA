package vkaretko.dao;

import vkaretko.models.Order;

import java.util.Collections;
import java.util.List;

/**
 * Order DAO class.
 *
 * @author Karetko Victor.
 * @version 1.00.
 * @since 24.04.2017.
 */
public class OrderDAO extends AbstractDAO<Order>{

    private static final OrderDAO INSTANCE = new OrderDAO();

    public static OrderDAO getInstance() {
        return INSTANCE;
    }

    @Override
    public Order get(int id) {
        return persistGetAll(session -> Collections.singletonList(session.get(Order.class, id))).get(0);
    }

    @Override
    public List<Order> getAll() {
        return persistGetAll(session -> session.createQuery("from Order").list());
    }
}
