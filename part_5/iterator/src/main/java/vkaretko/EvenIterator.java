package vkaretko;

import java.util.Iterator;

/**
 * Class EvenIterator for iterating even numbers.
 *
 * @author Karetko Victor
 * @version 1.00
 * @since 14.12.2016
 */
public class EvenIterator implements Iterator {
    /**
     * Int values for iterator.
     */
    private final int[] values;
    /**
     * Start index of array.
     */
    private int index = 0;

    /**
     * Constructor of RvenIterator.
     * @param values values to iterate.
     */
    public EvenIterator(int[] values) {
        this.values = values;
    }

    /**
     * Method check that array has even numbers in array.
     * @return true if array has even numbers, false otherwise.
     */
    @Override
    public boolean hasNext() {
        return nextEven() != null;
    }

    /**
     * Method select next even number in Array.
     * @return next even number in array.
     */
    @Override
    public Object next() {
        index++;
        return hasNext() ? nextEven() : null;
    }

    /**
     * Method find next even number.
     * @return even number.
     */
    private Integer nextEven() {
        Integer nextEven = null;
        for (int ind = index; ind < values.length; ind++) {
            if (values[ind] % 2 == 0) {
                nextEven = values[ind];
                break;
            }
        }
        return nextEven;
    }
}
