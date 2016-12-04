package vkaretko.storageareas;

import vkaretko.products.Food;

import java.util.ArrayList;
import java.util.List;

/**
 * StorageArea class is base class for creating other areas like Shop or WareHouse.
 *
 * @author Karetko Victor.
 * @version 1.00
 * @since 02.12.2016
 */
public abstract class StorageArea {
    /**
     * List of products in area.
     */
    private List<Food> products = new ArrayList<>();

    /**
     * Method for adding products to area.
     * @param product product to add.
     */
    public void addProduct(Food product) {
        this.products.add(product);
    }

    /**
     * Method check if area allow to add product.
     * @param product product to add.
     * @return true if allow, false otherwise.
     */

    public abstract boolean allowToAdd(Food product);

    /**
     * Getter-method for list of products.
     * @return list of products.
     */
    public List<Food> getProducts() {
        return this.products;
    }

    /**
     * Method set new list of products.
     * @param products new list of products.
     */
    public void setProducts(List<Food> products) {
        this.products = products;
    }
}
