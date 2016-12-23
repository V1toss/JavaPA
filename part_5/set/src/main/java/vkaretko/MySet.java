package vkaretko;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

/**
 * Class MySet.
 * Simple implementation of Set.
 * @author Karetko Victor
 * @version 1.00
 * @since 22.12.2016
 * @param <E> parametrized type.
 */
public class MySet<E> implements SimpleSet<E> {
    /**
     * List of elements.
     */
    private List<E> elements;

    /**
     * Empty constructor basedOnArrayList.
     */
    public MySet() {
        this.elements = new ArrayList<E>();
    }

    /**
     * Constructor with specific List.
     * @param list list.
     */
    public MySet(List<E> list) {
        this.elements = list;
    }

    /**
     * Method add element to set.
     * @param e element to add.
     */
    @Override
    public void add(E e) {
        int position = 0;
        if (size() > 0) {
            position = hasDuplicates(e, 0, elements.size() - 1);
        }
        if (position != -1) {
            elements.add(position, e);
        }
    }
    /**
     * Method checks duplicates in array.
     * Binary search with recursion.
     * @param element element to compare.
     * @param start start of range.
     * @param end end of range.
     * @return true if has duplicates, false otherwise.
     */
    private int hasDuplicates(E element, int start, int end) {
        int result;
        int middle = ((end - start) >> 1) + start;
        if (start == end && element.hashCode() != elements.get(middle).hashCode()) {
            result = middle;
        } else if (element.hashCode() == elements.get(middle).hashCode()) {
            result = -1;
        } else if (element.hashCode() > elements.get(middle).hashCode()) {
            result = hasDuplicates(element, middle + 1, end);
        } else {
            result = hasDuplicates(element, start, middle);
        }
        return result;
    }
    /**
     * Method return size of set.
     * @return size.
     */
    public int size() {
        return this.elements.size();
    }

    /**
     * Method for creating iterator.
     * @return Iterator.
     */
    @Override
    public Iterator<E> iterator() {
        return new Itr();
    }

    /**
     * Private class for iterator.
     */
    private class Itr implements Iterator<E> {
        /**
         * Iterator of elements.
         */
        private Iterator<E> iterator = elements.iterator();

        /**
         * hasNext method for iterator.
         * @return true if has next, false otherwise.
         */
        @Override
        public boolean hasNext() {
            return iterator.hasNext();
        }

        /**
         * Next method of iterator.
         * @return return next element in set.
         */
        @Override
        public E next() {
            return iterator.next();
        }
    }
}
