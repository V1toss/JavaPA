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
     * Operation.
     * True - buy, false - sell.
     */
    private boolean operation;

    /**
     * Constructor of order.
     * @param price - price of order.
     * @param volume - volume of order.
     * @param orderId - id of order.
     */
    public Order(double price, int volume, int orderId, boolean operation) {
        this.orderId = orderId;
        this.price = price;
        this.volume = volume;
        this.operation = operation;
    }

    /**
     * Getter for price.
     * @return price.
     */
    public double getPrice() {
        return this.price;
    }

    /**
     * Getter for order id.
     * @return order id.
     */
    public int getOrderId() {
        return this.orderId;
    }

    /**
     * Getter for volume.
     * @return volume.
     */
    public int getVolume() {
        return this.volume;
    }

    /**
     * Getter for operation.
     * @return operation.
     */
    public boolean isOperation() {
        return this.operation;
    }
}
