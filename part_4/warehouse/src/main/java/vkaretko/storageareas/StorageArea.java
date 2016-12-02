package vkaretko.storageareas;

import vkaretko.products.Food;

import java.util.ArrayList;

/**
 * Created by Vitoss.
 */
public abstract class StorageArea {
    private double startRangeExpiry;
    private double endRangeExpiry;
    private ArrayList<Food> storage = new ArrayList<>();

    public StorageArea(double startRangeExpiry, double endRangeExpiry) {
        this.startRangeExpiry = startRangeExpiry;
        this.endRangeExpiry = endRangeExpiry;
    }

    public void addProduct(Food product) {
        storage.add(product);
    }

    public boolean allowToAdd(Food product) {
        double percentExpiryOfProduct = (System.currentTimeMillis() - product.getCreateDate().getTime())
                / (product.getExpireDate().getTime() - product.getCreateDate().getTime());
        return (percentExpiryOfProduct > startRangeExpiry) && (percentExpiryOfProduct <= endRangeExpiry);
    }

    public ArrayList<Food> getStorage() {
        return this.storage;
    }
}
