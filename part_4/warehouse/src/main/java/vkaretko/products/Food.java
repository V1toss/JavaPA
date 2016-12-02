package vkaretko.products;

import java.util.Date;

/**
 * Created by Vitoss.
 */
public abstract class Food {
    private String name;
    private Date expireDate;
    private Date createDate;
    private double price;
    private int discount;

    public Food(String name, Date expireDate, Date createDate, double price, int discount) {
        this.name = name;
        this.expireDate = expireDate;
        this.createDate = createDate;
        this.price = price;
        this.discount = discount;
    }

    public Date getExpireDate() {
        return this.expireDate;
    }

    public Date getCreateDate() {
        return this.createDate;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public int getDiscount() {
        return discount;
    }

    public String getName() {
        return name;
    }
}
