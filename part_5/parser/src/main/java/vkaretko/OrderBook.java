package vkaretko;

import java.util.*;

/**
 * Class
 *
 * @author Karetko Victor.
 * @version 1.00.
 * @since 03.01.2017.
 */
public class OrderBook {

    /**
     * Buy orders.
     */
    private HashMap<Integer, Order> unsorted = new HashMap<>();

    /**
     * Buy orders.
     */
    private TreeMap<Double, HashMap<Integer, Order>> buySort = new TreeMap<>((o1, o2) -> Double.compare(o2, o1));

    /**
     * Sell orders.
     */
    private TreeMap<Double, HashMap<Integer, Order>> sellSort = new TreeMap<>(Double::compare);

    /**
     * Method add orders to buy or sell hashmap.
     * @param order order to add.
     */
    public void add(Order order) {
        unsorted.put(order.getOrderId(), order);
        if (order.isOperation()) {
            addToSorted(buySort, order);
        } else {
            addToSorted(sellSort, order);
        }
    }

    /**
     * Method add orders to sorted maps by prices.
     * @param sortMap map to add.
     * @param order order to add.
     */
    private void addToSorted(TreeMap<Double, HashMap<Integer, Order>> sortMap, Order order) {
        HashMap<Integer, Order> map;
        if (sortMap.containsKey(order.getPrice())) {
            map = sortMap.get(order.getPrice());
            map.put(order.getOrderId(), order);
        } else {
            map = new HashMap<>();
            map.put(order.getOrderId(), order);
            sortMap.put(order.getPrice(), map);
        }
    }

    /**
     * Method delete order by id.
     * @param orderId id to delete.
     */
    public void delete(int orderId) {
        if (unsorted.containsKey(orderId)) {
            Order order = unsorted.get(orderId);
            if (order.isOperation()) {
                buySort.get(order.getPrice()).remove(order.getOrderId());
            } else {
                sellSort.get(order.getPrice()).remove(order.getOrderId());
            }
            unsorted.remove(orderId);
        }
    }

    /**
     * Method prints pairs of sell orders and buy orders.
     */
    public void print() {

    }


}
