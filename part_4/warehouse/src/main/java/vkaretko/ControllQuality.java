package vkaretko;

import vkaretko.products.Food;
import vkaretko.storageareas.Shop;
import vkaretko.storageareas.StorageArea;
import vkaretko.storageareas.Trash;
import vkaretko.storageareas.Warehouse;

import java.util.ArrayList;
import java.util.List;

/**
 * ControllQuality class holds the list of storage areas and separate products to them.
 *
 * @author Karetko Victor.
 * @version 1.00
 * @since 02.12.2016
 */
public class ControllQuality {
    /**
     * List of storage areas.
     */
    private ArrayList<StorageArea> areas;

    /**
     * Constructor of ControllQuality.
     * Call initStorageAreas to fill list of areas.
     */
    public ControllQuality() {
        initStorageAreas();
    }

    /**
     * Method fills list of storage areas.
     */
    private void initStorageAreas() {
        final double twentyFiveExpiryPercent = 0.25;
        final double hundredExpiryPercent = 1;
        final double hugeExpiryPercent = 1000;
        addNewStorageArea(new Warehouse(0, twentyFiveExpiryPercent));
        addNewStorageArea(new Shop(twentyFiveExpiryPercent, hundredExpiryPercent));
        addNewStorageArea(new Trash(hundredExpiryPercent, hugeExpiryPercent));
    }

    /**
     * Method for adding new storage area.
     * @param area area to add.
     */
    public void addNewStorageArea(StorageArea area) {
        this.areas.add(area);
    }

    /**
     * Method to separate products to storage areas.
     * @param products products for adding.
     * @param areas list of storage areas, than can hold products.
     */
    public void separateProducts(List<Food> products, List<StorageArea> areas) {
        for (Food product : products) {
            for (StorageArea area : areas) {
                double percExpiry = product.getPercentExpiry();
                if (area.allowToAdd(percExpiry)) {
                    area.addProduct(product);
                    break;
                }
            }
        }
    }



}
