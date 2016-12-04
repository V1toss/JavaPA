package vkaretko;

import org.junit.Before;
import org.junit.Test;
import vkaretko.products.Bread;
import vkaretko.products.Food;
import vkaretko.products.Meat;
import vkaretko.products.Milk;
import vkaretko.products.Vegetable;
import vkaretko.storageareas.StorageArea;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;

import static org.hamcrest.core.Is.is;
import static org.junit.Assert.assertNotEquals;
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
    private ArrayList<Food> products;
    /**
     * Format for dates.
     */
    private SimpleDateFormat sdf = new SimpleDateFormat("dd.MM.yyyy");
    /**
     * Control Quality object for tests.
     */
    private ControllQuality control;
    /**
     * FoodReproductor object for tests.
     */
    private FoodReproductor reproductor;
    /**
     * Trash object for tests.
     */
    private StorageArea trash;
    /**
     * Shop object for tests.
     */
    private StorageArea shop;
    /**
     * Warehouse object for tests.
     */
    private StorageArea warehouse;
    /**
     * Refrigerated warehouse object for tests.
     */
    private StorageArea refrigWar;
    /**
     * Price for tests.
     */
    private final double price = 10.0;
    /**
     * Discount for tests.
     */
    private final double discount = 0.7;

    /**
     * Create all fields before tests.
     */
    @Before
    public void createAllFields() {
        final int indexOfRefrigerateWarehouse = 3;
        final int indexOfTrash = 2;
        final int indexOfShop = 1;
        final int indexOfWarehouse = 0;
        this.control = new ControllQuality();
        this.products = new ArrayList<>();
        this.reproductor = new FoodReproductor();
        this.trash = control.getAreas().get(indexOfTrash);
        this.shop = control.getAreas().get(indexOfShop);
        this.warehouse = control.getAreas().get(indexOfWarehouse);
        this.refrigWar = control.getAreas().get(indexOfRefrigerateWarehouse);
    }

    /**
     * Positive test of add product to warehouse.
     */
    @Test
    public void whenAddMilkWithLowPercentOfExpiryThenSeparatedToWarehouse() {
        try {
            Date dateCreate = sdf.parse("01.12.2016");
            Date dateExpiry = sdf.parse("01.01.2017");
            Milk milk = new Milk("Milk", dateExpiry, dateCreate, this.price, this.discount);
            this.products.add(milk);
            control.separateProducts(this.products, control.getAreas());
            assertThat(this.warehouse.getProducts().get(0), is(milk));
        } catch (ParseException pe) {
            pe.printStackTrace();
        }
    }

    /**
     * Positive test of add product to shop.
     */
    @Test
    public void whenAddBreadWithFiftyPercentOfExpiryThenSeparatedToShop() {
        try {
            Date dateCreate = sdf.parse("01.09.2016");
            Date dateExpiry = sdf.parse("01.02.2017");
            Bread bread = new Bread("Bread", dateExpiry, dateCreate, this.price, this.discount);
            this.products.add(bread);
            control.separateProducts(this.products, control.getAreas());
            assertThat(this.shop.getProducts().get(0), is(bread));
        } catch (ParseException pe) {
            pe.printStackTrace();
        }
    }

    /**
     * Positive test of add product to trash.
     */
    @Test
    public void whenAddMeatWithMoreThanHundredPercentOfExpiryThenSeparatedToTrash() {
        try {
            Date dateCreate = sdf.parse("01.09.2016");
            Date dateExpiry = sdf.parse("01.11.2016");
            Meat meat = new Meat("Meat", dateExpiry, dateCreate, this.price, this.discount);
            this.products.add(meat);
            control.separateProducts(this.products, control.getAreas());
            assertThat(this.trash.getProducts().get(0), is(meat));
        } catch (ParseException pe) {
            pe.printStackTrace();
        }
    }

    /**
     * Positive test of add product to shop with discount.
     */
    @Test
    public void whenAddMeatToShopWithNinetyPercentOfExpiryThenPriceWithDiscount() {
        try {
            Date dateCreate = sdf.parse("01.09.2016");
            Date dateExpiry = sdf.parse("01.01.2017");
            final double expectedPrice = 7.0;
            Meat meat = new Meat("Meat", dateExpiry, dateCreate, this.price, this.discount);
            this.products.add(meat);
            control.separateProducts(this.products, control.getAreas());
            assertThat(this.shop.getProducts().get(0).getPrice(), is(expectedPrice));
        } catch (ParseException pe) {
            pe.printStackTrace();
        }
    }

    /**
     * Positive test of add frozen product to refrigerated warehouse.
     */
    @Test
    public void whenAddFreshVegetableThenVegetableInRefrigeratedWarehouse() {
        try {
            Date dateCreate = sdf.parse("01.12.2016");
            Date dateExpiry = sdf.parse("01.02.2017");
            Vegetable apple = new Vegetable("Apple", dateExpiry, dateCreate, this.price, this.discount);
            this.products.add(apple);
            control.separateProducts(this.products, control.getAreas());
            assertThat(this.refrigWar.getProducts().get(0), is(apple));
        } catch (ParseException pe) {
            pe.printStackTrace();
        }
    }

    /**
     * Positive test of add frozen product to refrigerated warehouse.
     */
    @Test
    public void whenReproductTrashProductsThenMeatWillGoToShopWithNewExpiry() {
        try {
            Date dateCreate = sdf.parse("01.12.2016");
            Date dateExpiry = sdf.parse("03.12.2016");
            Meat meat = new Meat("Meat", dateExpiry, dateCreate, this.price, this.discount);
            this.products.add(meat);
            this.control.separateProducts(this.products, this.control.getAreas());
            this.reproductor.separate(this.trash.getProducts(), this.trash, this.control);
            assertNotEquals(meat.getPercentExpiry(), is(this.shop.getProducts().get(0).getPercentExpiry()));
        } catch (ParseException pe) {
            pe.printStackTrace();
        }
    }


}
