package vkaretko.storageareas;

import vkaretko.products.Food;

/**
 * Trash area class extended from Storage area.
 *
 * @author Karetko Victor.
 * @version 1.00
 * @since 02.12.2016
 */
public class Trash extends StorageArea {
    /**
     * Start percent of expiry date.
     */
    private double startRangeExpiry;
    /**
     * Constructor of Trash.
     * @param endRangeExpiry end percent of expiry date for adding products.
     */
    public Trash(double endRangeExpiry) {
        this.startRangeExpiry = endRangeExpiry;
    }

    /**
     * Overrided method of allow to add.
     * @param product product to add.
     * @return true if allow, false otherwise.
     */
    @Override
    public boolean allowToAdd(Food product) {
        return product.getPercentExpiry() >= this.startRangeExpiry;
    }
}
