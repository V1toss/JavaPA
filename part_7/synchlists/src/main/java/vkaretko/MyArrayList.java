package vkaretko;

import java.util.Arrays;
import java.util.Iterator;
import java.util.NoSuchElementException;

/**
 * Class MyArrayList with synchronize.
 * @author Karetko Victor
 * @version 1.00
 * @since 22.01.2017
 * @param <E> parametrized type.
 */
public class MyArrayList<E> implements Iterable<E>{
    /**
     * Count of element.
     */
    private int count = 0;
    /**
     * Array of elements.
     */
    private Object[] elementData;
    /**
     * Deafault capacity of array.
     */
    private static final int DEFAULT_CAPACITY = 10;
    /**
     * Empty constructor. Create new array with default capacity.
     */
    public MyArrayList() {
        this.elementData = new Object[DEFAULT_CAPACITY];
    }
    /**
     * Constructor with initial capacity.
     * @param initialCapacity size of array.
     */
    public MyArrayList(int initialCapacity) {
        this.elementData = new Object[initialCapacity];
    }
    /**
     * Get method for taking elements from MyArrayList.
     * @param index
     * @return
     */
    public synchronized E get(int index) {
        return (E) this.elementData[index];
    }
    /**
     * Method add new element to list.
     * @param e
     */
    public synchronized void add(E e) {
        ensureCapacity(count + 1);
        this.elementData[count++] = e;
    }
    /**
     * Iterator of MyArrayList.
     * @return iterator.
     */
    public Iterator<E> iterator() {
        return new Itr();
    }

    /**
     * Method create new array, if old array is full.
     * @param count size of current array + 1.
     */
    private synchronized void ensureCapacity(int count) {
        if (count > this.elementData.length) {
            elementData = Arrays.copyOf(elementData, count * 2);
        }
    }
    /**
     * Method returns length of list.
     * @return length of list.
     */
    public synchronized int length() {
        return this.count;
    }
    /**
     * Iterator class for MyArrayList.
     */
    private class Itr implements Iterator<E> {
        /**
         * Cursor of iterator.
         */
        private int cursor = 0;

        /**
         * Method checks array has next element.
         * @return true if has element, false otherwise
         */
        public boolean hasNext() {
            return cursor < count;
        }
        /**
         * Method return next element of array.
         * @return next element.
         */
        public E next() {
            try {
                cursor++;
                E next = get(cursor - 1);
                return next;
            } catch (IndexOutOfBoundsException iofbe) {
                throw new NoSuchElementException("No more elements in list");
            }
        }
    }
}
