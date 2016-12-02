package vkaretko.products;

import java.util.Date;

/**
 * Meat class extended from Food.
 *
 * @author Karetko Victor.
 * @version 1.00
 * @since 02.12.2016
 */
public class Meat extends Food {
    /**
     * Constructor of class Meat.
     * @param name name of product.
     * @param expireDate expire date of product.
     * @param createDate create date of product.
     * @param price price of product.
     * @param discount possible dicsount of product.
     */
    public Meat(String name, Date expireDate, Date createDate, double price, int discount) {
        super(name, expireDate, createDate, price, discount);
    }
}
