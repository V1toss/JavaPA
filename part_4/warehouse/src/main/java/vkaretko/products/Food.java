package vkaretko.products;

import java.util.Date;

/**
 * Base class for food products.
 *
 * @author Karetko Victor.
 * @version 1.00
 * @since 02.12.2016
 */
public abstract class Food {
    /**
     * Name of product.
     */
    private String name;
    /**
     * Expire date of product.
     */
    private Date expireDate;
    /**
     * Create date of product.
     */
    private Date createDate;
    /**
     * Price of product.
     */
    private double price;
    /**
     * Possible discount on product.
     */
    private double discount;

    /**
     * Constructor of class Food.
     * @param name name of product.
     * @param expireDate expire date of product.
     * @param createDate create date of product.
     * @param price price of product.
     * @param discount possible dicsount of product.
     */
    public Food(String name, Date expireDate, Date createDate, double price, double discount) {
        this.name = name;
        this.expireDate = expireDate;
        this.createDate = createDate;
        this.price = price;
        this.discount = discount;
    }

    /**
     * Getter-method of price.
     * @return price of product.
     */
    public double getPrice() {
        return price;
    }

    /**
     * Setter method for price.
     * @param price price of product.
     */
    public void setPrice(double price) {
        this.price = price;
    }

    /**
     * Getter-method for discount.
     * @return discount of product
     */
    public double getDiscount() {
        return discount;
    }

    /**
     * Get the percent of expiry product depends from current time.
     * @return percent of expiry
     */
    public double getPercentExpiry() {
        return (double) (System.currentTimeMillis() - this.createDate.getTime())
                / (this.expireDate.getTime() - this.createDate.getTime());
    }
}
