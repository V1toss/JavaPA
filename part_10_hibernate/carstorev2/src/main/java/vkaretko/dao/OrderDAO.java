package vkaretko.dao;

import vkaretko.models.Order;

import java.util.List;

/**
 * Order DAO class.
 *
 * @author Karetko Victor.
 * @version 1.00.
 * @since 24.04.2017.
 */
public class OrderDAO extends AbstractDAO<Order> {

    private Boolean priceFilter = false;

    private Integer maxPrice = null;

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

    /**
     * Get all orders.
     * @return list of orders.
     */
    @Override
    public List<Order> getAll() {
        return persistGetAll(session -> {
            if (priceFilter) {
                session.enableFilter("priceFilter").setParameter("maxPrice", maxPrice);
            } else {
                session.disableFilter("priceFilter");
            }
            return session.createQuery("from Order").list();
        });
    }

    /**
     * Set price filter.
     * @param price max price.
     */
    public void setPriceFilter(Integer price) {
        this.priceFilter = true;
        this.maxPrice = price;
    }

    /**
     * Switch price filter.
     * @param flag switch filter on/off.
     */
    public void setPriceFilter(Boolean flag) {
        this.priceFilter = flag;
    }
}
