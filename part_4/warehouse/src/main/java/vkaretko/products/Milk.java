package vkaretko.products;

import java.util.Date;

/**
 * Created by Vitoss on 02.12.2016.
 */
public class Milk extends Food {
    public Milk(String name, Date expireDate, Date createDate, double price, int discount) {
        super(name, expireDate, createDate, price, discount);
    }
}
