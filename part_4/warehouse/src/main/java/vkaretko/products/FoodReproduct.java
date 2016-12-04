package vkaretko.products;

import java.util.Date;

/**
 * Base class for food products with reproduct opportunity.
 *
 * @author Karetko Victor.
 * @version 1.00
 * @since 02.12.2016
 */
public abstract class FoodReproduct extends Food {
    /**
     * True if can reproduct, false otherwise.
     */
    private boolean canReproduct = true;

    /**
     * Constructor of class Food.
     * @param name name of product.
     * @param expireDate expire date of product.
     * @param createDate create date of product.
     * @param price price of product.
     * @param discount possible dicsount of product.
     * @param canReproduct opportunity to peproduct.
     */
    public FoodReproduct(String name, Date expireDate, Date createDate,
                         double price, double discount, boolean canReproduct) {
        super(name, expireDate, createDate, price, discount);
        this.canReproduct = canReproduct;
    }

    /**
     * Abstract class for reproducting.
     */
    public abstract void reproduct();

    /**
     * Getter-method for field canReproduct.
     * @return true if can reproduct, false otherwise.
     */
    public boolean isCanReproduct() {
        return this.canReproduct;
    }

    /**
     * Set product canReproduct flag.
     * @param canReproduct new value of canReproduct.
     */
    public void setCanReproduct(boolean canReproduct) {
        this.canReproduct = canReproduct;
    }
}
