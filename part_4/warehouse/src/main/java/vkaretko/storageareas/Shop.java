package vkaretko.storageareas;

import vkaretko.products.Food;

/**
 * Shop area class extended from Storage area.
 *
 * @author Karetko Victor.
 * @version 1.00
 * @since 02.12.2016
 */
public class Shop extends StorageArea {
    /**
     * Start percent of expiry date.
     */
    private double startRangeExpiry;
    /**
     * End percent of expiry date for adding products.
     */
    private double endRangeExpiry;
    /**
     * Constructor of Shop.
     * @param startRangeExpiry start percent of expiry date for adding products.
     * @param endRangeExpiry end percent of expiry date for adding products.
     */
    public Shop(double startRangeExpiry, double endRangeExpiry) {
        this.startRangeExpiry = startRangeExpiry;
        this.endRangeExpiry = endRangeExpiry;
    }

    /**
     * Overrided method of addProduct for setting price with discount for adding products close to expiry date.
     * @param product product for adding to Shop.
     */
    @Override
    public void addProduct(Food product) {
        super.addProduct(checkDiscount(product));
    }

    /**
     * Overrided method of allow to add.
     * @param product product to add.
     * @return true if allow, false otherwise.
     */
    @Override
    public boolean allowToAdd(Food product) {
        return (product.getPercentExpiry() >= this.startRangeExpiry
                && product.getPercentExpiry() < this.endRangeExpiry);
    }

    /**
     * Method checks that product go to shop with discount.
     * @param product product to check.
     * @return product after check.
     */
    private Food checkDiscount(Food product) {
        final double closeToExpiry =  0.75;
        if (product.getPercentExpiry() > closeToExpiry) {
            product.setPrice(product.getPrice() * product.getDiscount());
        }
        return product;
    }
}
