package vkaretko.products;

import java.util.Date;

/**
 * Meat class extended from FoodReproduct.
 *
 * @author Karetko Victor.
 * @version 1.00
 * @since 02.12.2016
 */
public class Chicken extends FoodReproduct {
    /**
     * Constructor of class Chicken.
     * @param name name of product.
     * @param expireDate expire date of product.
     * @param createDate create date of product.
     * @param price price of product.
     * @param discount possible dicsount of product.
     * @param canReproduct if product can reproduct.
     */
    public Chicken(String name, Date expireDate, Date createDate, double price, double discount, boolean canReproduct) {
        super(name, expireDate, createDate, price, discount, canReproduct);
    }
    /**
     * Method for reproducting food.
     * Refresh expiry date of product.
     */
    @Override
    public void reproduct() {
        final long expiryFiveDayAfterReproduct = 432000000;
        setExpireDate(new Date(System.currentTimeMillis() + expiryFiveDayAfterReproduct));
    }
}
