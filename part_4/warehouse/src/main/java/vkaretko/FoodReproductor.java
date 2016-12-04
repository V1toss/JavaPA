package vkaretko;

import vkaretko.products.Food;
import vkaretko.storageareas.StorageArea;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

/**
 * Class FoodReproductor for reproduct lists of food.
 *
 * @author Karetko Victor.
 * @version 1.00
 * @since 02.12.2016
 */
public class FoodReproductor {

    /**
     * Method separate list of products into two lists.
     * 1st list: products that cant reproduct back to their source StorageArea.
     * 2nd list: reproducted food sends to ControllQuality.
     * @param toReproduct list of food to reproduct.
     * @param area area, from which list was received.
     * @param control ControllQuality department.
     */
    public void separate(List<Food> toReproduct, StorageArea area, ControllQuality control) {
        ArrayList<Food> notReproducted = new ArrayList<>();
        ArrayList<Food> reproductedList = new ArrayList<>();
        for (Food food : toReproduct) {
            if (food.isCanReproduct() && food.getPercentExpiry() > 1) {
                reproductedList.add(reproduct(food));
            } else {
                notReproducted.add(food);
            }
        }
        area.clearProductList();
        area.setProducts(notReproducted);
        control.separateProducts(reproductedList, control.getAreas());
    }

    /**
     * Method for reproducting food.
     * Refresh expiry date of product.
     * @param product product to reproduct.
     * @return reproducted food.
     */
    private Food reproduct(Food product) {
        final long expiryFiveDayAfterReproduct = 432000000;
        product.setExpireDate(new Date(System.currentTimeMillis() + expiryFiveDayAfterReproduct));
        return product;
    }
}
