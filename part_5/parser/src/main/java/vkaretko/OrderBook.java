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
    private HashMap<Integer, Order> buy = new HashMap<>();

    /**
     * Sell orders.
     */
    private HashMap<Integer, Order> sell = new HashMap<>();

    /**
     * Sorted array list of buy orders.
     */
    private ArrayList<Order> buySort = new ArrayList<>();

    /**
     * Sorted array list of sell orders.
     */
    private ArrayList<Order> sellSort = new ArrayList<>();

    /**
     * Method add orders to buy or sell hashmap.
     * @param order order to add.
     * @param orderId order id to add.
     * @param operation operation - true to buy, false to sell.
     */
    public void add(Order order, int orderId, boolean operation) {
        if (operation) {
            buy.put(orderId, order);
        } else {
            sell.put(orderId, order);
        }
    }

    /**
     * Method delete order by id.
     * @param orderId id to delete.
     */
    public void delete(int orderId) {
        if (buy.containsKey(orderId)) {
            buy.remove(orderId);
        } else if (sell.containsKey(orderId)) {
            sell.remove(orderId);
        }
    }

    /**
     * Method prints pairs of sell orders and buy orders.
     */
    public void print() {
        buySort.addAll(buy.values());
        sellSort.addAll(sell.values());
        Collections.sort(buySort, (o1, o2) -> Double.compare(o2.getPrice(), o1.getPrice()));
        Collections.sort(sellSort, (o1, o2) -> Double.compare(o1.getPrice(), o2.getPrice()));
        int maxSize = buySort.size() > sellSort.size() ? sellSort.size() : buySort.size();
        for (int index = 0; index < maxSize; index++) {
            System.out.println(String.format("%s@%s - %s@%s", buySort.get(index).getVolume(),
                    buySort.get(index).getPrice(), sellSort.get(index).getVolume(), sellSort.get(index).getPrice()));
        }
    }


}
