package vkaretko;

import java.util.Iterator;
import java.util.NoSuchElementException;

/**
 * Class ConverterIterator for iterating throw multiple iterators with integer numbers.
 *
 * @author Karetko Victor
 * @version 1.00
 * @since 15.12.2016
 */
public class ConverterIterator implements Iterator<Integer>, Converter {

    /**
     * Iterator of iterators.
     */
    private Iterator<Iterator<Integer>> iterators;
    /**
     * Current selected iterator.
     */
    private Iterator<Integer> currentIterator = null;

    /**
     * Method convert iterator of iterators to ConverterIterator.
     * @param it iterator of iterators.
     * @return new iterator.
     */
    @Override
    public Iterator<Integer> convert(Iterator<Iterator<Integer>> it) {
        this.iterators = it;
        if (it.hasNext()) {
            this.currentIterator = it.next();
        }
        return this;
    }

    /**
     * Method checks, that ConverterIterator has iterator or currentIterator has numbers.
     * @return true if iterator has other iterators or currentIterator has numbers.
     */
    @Override
    public boolean hasNext() {
        return currentIterator.hasNext() || iterators.hasNext();
    }

    /**
     * Method select next number in current iterator or next number in next iterator.
     * @return next number in currentIterator.
     */
    @Override
    public Integer next() {
        Integer result;
        if (currentIterator.hasNext()) {
            result = currentIterator.next();
        } else if (iterators.hasNext()) {
            currentIterator = iterators.next();
            result = currentIterator.next();
        } else {
            throw new NoSuchElementException("No numbers in iterators.");
        }
        return result;
    }
}
