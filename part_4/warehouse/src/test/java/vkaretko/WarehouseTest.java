package vkaretko;

import org.junit.Test;
import vkaretko.products.Bread;
import vkaretko.products.Food;
import vkaretko.products.Meat;
import vkaretko.products.Milk;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;

import static org.hamcrest.core.Is.is;
import static org.junit.Assert.assertThat;

/**
 * Test-class for warehouse program.
 *
 * @author Karetko Victor.
 * @version 1.00
 * @since 02.12.2016
 */
public class WarehouseTest {
    /**
     * List of products.
     */
    private ArrayList<Food> products = new ArrayList<>();
    /**
     * Format for dates.
     */
    private SimpleDateFormat sdf = new SimpleDateFormat("dd.MM.yyyy");
    /**
     * Positive test of add product to warehouse.
     */
    @Test
    public void whenAddMilkWithLowPercentOfExpiryThenSeparatedToWarehouse() {
        ControllQuality control = new ControllQuality();
        try {
            Date dateCreate = sdf.parse("01.12.2016");
            Date dateExpiry = sdf.parse("01.01.2017");
            final double priceOfMilk = 10.0;
            final double discountMilk = 0.7;
            Milk milk = new Milk("Milk", dateExpiry, dateCreate, priceOfMilk, discountMilk);
            this.products.add(milk);
            control.separateProducts(this.products, control.getAreas());
            assertThat(control.getAreas().get(0).getProducts().get(0), is(milk));
        } catch (ParseException pe) {
            pe.printStackTrace();
        }
    }

    /**
     * Positive test of add product to shop.
     */
    @Test
    public void whenAddBreadWithFiftyPercentOfExpiryThenSeparatedToShop() {
        ControllQuality control = new ControllQuality();
        try {
            Date dateCreate = sdf.parse("01.09.2016");
            Date dateExpiry = sdf.parse("01.02.2017");
            final double priceOfBread = 10.0;
            final double discountOfBread = 0.7;
            Bread bread = new Bread("Bread", dateExpiry, dateCreate, priceOfBread, discountOfBread);
            this.products.add(bread);
            control.separateProducts(this.products, control.getAreas());
            assertThat(control.getAreas().get(1).getProducts().get(0), is(bread));
        } catch (ParseException pe) {
            pe.printStackTrace();
        }
    }

    /**
     * Positive test of add product to trash.
     */
    @Test
    public void whenAddMeatWithMoreThanHundredPercentOfExpiryThenSeparatedToTrash() {
        ControllQuality control = new ControllQuality();
        try {
            Date dateCreate = sdf.parse("01.09.2016");
            Date dateExpiry = sdf.parse("01.11.2016");
            final double priceOfMeat = 10.0;
            final double discountOfMeat = 0.7;
            Meat meat = new Meat("Meat", dateExpiry, dateCreate, priceOfMeat, discountOfMeat);
            this.products.add(meat);
            control.separateProducts(this.products, control.getAreas());
            assertThat(control.getAreas().get(2).getProducts().get(0), is(meat));
        } catch (ParseException pe) {
            pe.printStackTrace();
        }
    }

    /**
     * Positive test of add product to trash.
     */
    @Test
    public void whenAddMeatToShopWithNinetyPercentOfExpiryThenPriceWithDiscount() {
        ControllQuality control = new ControllQuality();
        try {
            Date dateCreate = sdf.parse("01.09.2016");
            Date dateExpiry = sdf.parse("01.01.2017");
            final double priceOfMeat = 10.0;
            final double discountOfMeat = 0.7;
            final double expectedPrice = 7.0;
            Meat meat = new Meat("Meat", dateExpiry, dateCreate, priceOfMeat, discountOfMeat);
            this.products.add(meat);
            control.separateProducts(this.products, control.getAreas());
            assertThat(control.getAreas().get(1).getProducts().get(0).getPrice(), is(expectedPrice));
        } catch (ParseException pe) {
            pe.printStackTrace();
        }
    }


}
