package vkaretko.storageareas;

import vkaretko.products.Food;

/**
 * Warehouse area class extended from Storage area.
 *
 * @author Karetko Victor.
 * @version 1.00
 * @since 02.12.2016
 */
public class Warehouse extends StorageArea {
    /**
     * Start percent of expiry date.
     */
    private double startRangeExpiry;
    /**
     * End percent of expiry date for adding products.
     */
    private double endRangeExpiry;
    /**
     * Constructor of Warehouse.
     * @param startRangeExpiry start percent of expiry date for adding products.
     * @param endRangeExpiry end percent of expiry date for adding products.
     */
    public Warehouse(double startRangeExpiry, double endRangeExpiry) {
        this.startRangeExpiry = startRangeExpiry;
        this.endRangeExpiry = endRangeExpiry;
    }

    /**
     * Overrided method of allow to add non frozen products.
     * @param product product to add.
     * @return true if allow, false otherwise.
     */
    @Override
    public boolean allowToAdd(Food product) {
        return (!product.isFrozen() && product.getPercentExpiry() >= this.startRangeExpiry
                && (product.getPercentExpiry() < this.endRangeExpiry));
    }
}
