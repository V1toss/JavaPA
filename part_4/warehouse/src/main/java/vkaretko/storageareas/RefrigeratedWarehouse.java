package vkaretko.storageareas;

import vkaretko.products.Food;

/**
 * RefrigeratedWarehouse area class extended from StorageArea.
 *
 * @author Karetko Victor.
 * @version 1.00
 * @since 02.12.2016
 */
public class RefrigeratedWarehouse extends StorageArea {
    /**
     * Constructor of RefrigeratedWarehouse.
     * @param startRangeExpiry start percent of expiry date for adding products.
     * @param endRangeExpiry end percent of expiry date for adding products.
     */
    public RefrigeratedWarehouse(double startRangeExpiry, double endRangeExpiry) {
        super(startRangeExpiry, endRangeExpiry);
    }

    /**
     * Overrided method of allow to add for frozen products.
     * @param product product to add.
     * @return true if allow, false otherwise.
     */
    @Override
    public boolean allowToAdd(Food product) {
        return product.isFrozen() && super.allowToAdd(product);
    }
}
