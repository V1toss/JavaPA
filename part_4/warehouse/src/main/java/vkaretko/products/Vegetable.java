package vkaretko.products;

import java.util.Date;

/**
 * Vegetables class extended from Food.
 * Comes to warehouse frozen.
 *
 * @author Karetko Victor.
 * @version 1.00
 * @since 02.12.2016
 */
public class Vegetable extends Food {
    /**
     * Constructor of class Vegetable.
     * @param name name of product.
     * @param expireDate expire date of product.
     * @param createDate create date of product.
     * @param price price of product.
     * @param discount possible dicsount of product.
     */
    public Vegetable(String name, Date expireDate, Date createDate, double price, double discount) {
        super(name, expireDate, createDate, price, discount);
    }

    /**
     * Getter-method for frozen field.
     * @return true if frozen, false otherwise.
     */
    @Override
    public boolean isFrozen() {
        return true;
    }
}
