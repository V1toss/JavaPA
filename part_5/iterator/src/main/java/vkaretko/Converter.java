package vkaretko;

import java.util.Iterator;

/**
 * Interface Converter for converting multiple iterators into one iterator.
 *
 * @author Karetko Victor
 * @version 1.00
 * @since 15.12.2016
 */
public interface Converter {
    /**
     * Method convert multiple iterators to one iterator.
     * @param it iterator of iterators.
     * @return new iterator.
     */
    Iterator<Integer> convert(Iterator<Iterator<Integer>> it);
}
