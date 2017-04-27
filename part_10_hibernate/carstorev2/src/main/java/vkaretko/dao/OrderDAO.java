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

}
