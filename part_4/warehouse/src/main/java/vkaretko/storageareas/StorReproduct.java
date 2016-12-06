package vkaretko.storageareas;

import vkaretko.products.Food;
import vkaretko.products.FoodReproduct;

/**
 * StorReproduct class is a class for food going to reproduct.
 *
 * @author Karetko Victor.
 * @version 1.00
 * @since 02.12.2016
 */
public class StorReproduct extends StorageArea {
    /**
     * Overrided method if food is not reproduct.
     * @param product product to add.
     * @return always false.
     */
    @Override
    public boolean allowToAdd(Food product) {
        return false;
    }

    /**
     * Overrided method for food that can be reproducted.
     * @param product product to add.
     * @return true if food can reproduct.
     */
    public boolean allowToAdd(FoodReproduct product) {
        return product.isCanReproduct();
    }
}
