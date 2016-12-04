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
     * Start percent of expiry date.
     */
    private double startRangeExpiry;
    /**
     * End percent of expiry date for adding products.
     */
    private double endRangeExpiry;
    /**
     * List of products in area.
     */
    private List<Food> products = new ArrayList<>();

    /**
     * Constructor of StorageArea.
     * @param startRangeExpiry start percent of expiry date for adding products.
     * @param endRangeExpiry end percent of expiry date for adding products.
     */
    public StorageArea(double startRangeExpiry, double endRangeExpiry) {
        this.startRangeExpiry = startRangeExpiry;
        this.endRangeExpiry = endRangeExpiry;
    }

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

    public boolean allowToAdd(Food product) {
        double percentExpiryOfProduct = product.getPercentExpiry();
        return (percentExpiryOfProduct >= startRangeExpiry) && (percentExpiryOfProduct < endRangeExpiry);
    }

    /**
     * Getter-method for list of products.
     * @return list of products.
     */
    public List<Food> getProducts() {
        return this.products;
    }

    /**
     * Method for clearing product list.
     */
    public void clearProductList() {
        this.products = new ArrayList<>();
    }

    /**
     * Method set new list of products.
     * @param products new list of products.
     */
    public void setProducts(List<Food> products) {
        this.products = products;
    }
}
