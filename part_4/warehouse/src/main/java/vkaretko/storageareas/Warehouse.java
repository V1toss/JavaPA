package vkaretko.storageareas;

/**
 * Warehouse area class extended from Storage area.
 *
 * @author Karetko Victor.
 * @version 1.00
 * @since 02.12.2016
 */
public class Warehouse extends StorageArea {
    /**
     * Constructor of Warehouse.
     * @param startRangeExpiry start percent of expiry date for adding products.
     * @param endRangeExpiry end percent of expiry date for adding products.
     */
    public Warehouse(double startRangeExpiry, double endRangeExpiry) {
        super(startRangeExpiry, endRangeExpiry);
    }
}
