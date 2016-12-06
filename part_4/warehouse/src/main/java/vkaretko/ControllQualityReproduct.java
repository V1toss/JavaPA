package vkaretko;

import vkaretko.products.Food;
import vkaretko.products.FoodReproduct;
import vkaretko.storageareas.StorReproduct;

import java.util.ArrayList;
import java.util.List;

/**
 * ControllQualityReproduct class extended from Control Quality.
 *
 * @author Karetko Victor.
 * @version 1.00
 * @since 06.12.2016
 */
public class ControllQualityReproduct extends ControllQuality {
    /**
     * Method to separate products to reproduct storage area.
     * @param food products for adding.
     * @param storRep reproduct storage area.
     * @param defControl default quality control department.
     */
    public void separateProducts(FoodReproduct food, StorReproduct storRep, ControllQuality defControl) {
        if (storRep.allowToAdd(food)) {
            storRep.addProduct(food);
        } else {
            List<Food> products = new ArrayList<>();
            products.add(food);
            defControl.separateProducts(products, defControl.getAreas());
        }
    }
}