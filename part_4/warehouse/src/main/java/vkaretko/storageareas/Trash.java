package vkaretko.storageareas;

import vkaretko.products.Food;

/**
 * Created by Vitoss.
 */
public class Trash extends StorageArea{
    public Trash(double startRangeExpiry, double endRangeExpiry) {
        super(startRangeExpiry, endRangeExpiry);
    }

    @Override
    public void addProduct(Food product) {
        product.setPrice(product.getPrice() * product.getDiscount());
        super.addProduct(product);
    }
}
