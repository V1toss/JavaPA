package vkaretko.storageareas;

/**
 * Trash area class extended from Storage area.
 *
 * @author Karetko Victor.
 * @version 1.00
 * @since 02.12.2016
 */
public class Trash extends StorageArea {
    /**
     * Constructor of Trash.
     * @param startRangeExpiry start percent of expiry date for adding products.
     * @param endRangeExpiry end percent of expiry date for adding products.
     */
    public Trash(double startRangeExpiry, double endRangeExpiry) {
        super(startRangeExpiry, endRangeExpiry);
    }
}
