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
     * Constructor of Shop.
     * @param startRangeExpiry start percent of expiry date for adding products.
     * @param endRangeExpiry end percent of expiry date for adding products.
     */
    public Shop(double startRangeExpiry, double endRangeExpiry) {
        super(startRangeExpiry, endRangeExpiry);
    }

    /**
     * Overrided method of addProduct for setting price with discount for adding products close to expiry date.
     * @param product product for adding to Shop.
     */
    @Override
    public void addProduct(Food product) {
        final double closeToExpiry =  0.75;
        if (product.getPercentExpiry() > closeToExpiry) {
            product.setPrice(product.getPrice() * product.getDiscount());
        }
        super.addProduct(product);
    }
}
