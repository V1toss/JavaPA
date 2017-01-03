package vkaretko;

/**
 * Class
 *
 * @author Karetko Victor.
 * @version 1.00.
 * @since 03.01.2017.
 */
public class Order {
    /**
     * Id of order.
     */
    private final int orderId;

    /**
     * Price of order.
     */
    private double price;

    /**
     * Volume of order.
     */
    private int volume;

    /**
     * Constructor of order.
     * @param price - price of order.
     * @param volume - volume of order.
     * @param orderId - id of order.
     */
    public Order(double price, int volume, int orderId) {
        this.orderId = orderId;
        this.price = price;
        this.volume = volume;
    }

    /**
     * Getter for price.
     * @return price.
     */
    public double getPrice() {
        return price;
    }

    /**
     * Getter for order id.
     * @return order id.
     */
    public int getOrderId() {
        return orderId;
    }

    /**
     * Getter for volume.
     * @return volume.
     */
    public int getVolume() {
        return volume;
    }
}
