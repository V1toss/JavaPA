package vkaretko;

import vkaretko.products.Food;
import vkaretko.storageareas.Shop;
import vkaretko.storageareas.StorageArea;
import vkaretko.storageareas.Trash;
import vkaretko.storageareas.Warehouse;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Vitoss.
 */
public class ControllQuality {
    private ArrayList<StorageArea> areas;

    public ControllQuality() {
        initStorageAreas();
    }

    private void initStorageAreas() {
        addNewStorageArea(new Warehouse(0, 0.25));
        addNewStorageArea(new Shop(0.25, 0.75));
        addNewStorageArea(new Trash(0.75, 1));
    }

    public void addNewStorageArea(StorageArea area) {
        this.areas.add(area);
    }

    public void separateProducts(List<Food> products, List<StorageArea> areas) {
        for (Food product : products) {
            for (StorageArea area : areas) {
                if (area.allowToAdd(product)) {
                    area.addProduct(product);
                    break;
                }
            }
        }
    }


}
