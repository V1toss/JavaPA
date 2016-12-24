package vkaretko.handbook;

import java.util.Iterator;
import java.util.NoSuchElementException;

/**
 * Handbook class implements simple map with 3 methods.
 * @author Karetko Victor
 * @version 1.00
 * @since 24.12.2016
 * @param <T> parametrized type for key.
 * @param <V> parametrized type for value.
 */
public class HandBook<T, V> implements SimpleMap<T, V> {
    /**
     * Array of elements.
     */
    private Entry[] elements;

    /**
     * Size of map.
     */
    private static final int DEFAULT_SIZE = 10;

    /**
     * Constructor of HandBook.
     */
    public HandBook() {
        this.elements = new Entry[DEFAULT_SIZE];
        fillNull();
    }

    /**
     * Constructor of HandBook with size.
     * @param size size of map.
     */
    public HandBook(int size) {
        this.elements = new Entry[size];
        fillNull();
    }

    /**
     * Fill array with nulls.
     */
    private void fillNull() {
        for (int index = 0; index < elements.length; index++) {
            elements[index] = null;
        }
    }
     /**
     * Delete element from map.
     * @param key key of element to delete.
     * @return true if deleted, false otherwise.
     */
    @Override
    public boolean delete(T key) {
        boolean result = true;
        int index = getIndexByHashingKey(key);
        if (key != null && index != -1) {
            elements[index] = null;
        } else {
            result = false;
        }
        return result;
    }
    /**
     * Method adds new pair key value.
     * @param key key.
     * @param value value.
     * @return true if inserted, false otherwise.
     */
    @Override
    public boolean insert(T key, V value) {
        boolean result = true;
        int index = getIndexByHashingKey(key);
        if (key != null && index != -1) {
            elements[index] = new Entry(key, value);
        } else {
            result = false;
        }
        return result;
    }
    /**
     * Get value by key.
     * @param key key to search.
     * @return value.
     */
    @Override
    public V get(T key) {
        int index = getIndexByHashingKey(key);
        if (key != null && index != -1) {
            return (V) elements[index].getValue();
        } else {
            throw new NoSuchElementException("No such element");
        }
    }

    /**
     * Method calculates index from key hashcode.
     * @param key key of element
     * @return index of element
     */
    private int getIndexByHashingKey(T key) {
        int index = key.hashCode() % elements.length;
        while (elements[index] != null && elements[index].getKey() != key) {
            index = (index + 1) % elements.length;
        }
        return index;
    }

    /**
     * Method calculate size of map.
     * @return size of map.
     */
    public int getSize() {
        int count = 0;
        for (int index = 0; index < elements.length; index++) {
            if (elements[index] != null) {
                count++;
            }
        }
        return count;
    }

    /**
     * Method for creating iterator of HandBook.
     * @return new iterator.
     */
    @Override
    public Iterator iterator() {
        return new Itr();
    }

    /**
     * Private class for iterator.
     */
    private class Itr implements Iterator {
        /**
         * Cursor of element.
         */
        private int cursor = 0;

        /**
         * hasNext method of iterator.
         * @return true if has next elements, false otherwise.
         */
        @Override
        public boolean hasNext() {
            boolean result = false;
            for (int index = cursor; index < elements.length; index++) {
                if (elements[index] != null) {
                    result = true;
                    break;
                }
            }
            return result;
        }

        /**
         * Method returns next element.
         * @return next element.
         */
        @Override
        public Object next() {
            while (elements[cursor] == null) {
                cursor++;
            }
            return elements[cursor++];
        }
    }

    /**
     * Private class for entry in HandBook.
     * @param <T> parametrized type for keys.
     * @param <V> parametrized type for values.
     */
    private class Entry<T, V> {
        /**
         * Key of Entry.
         */
        private T key;

        /**
         * Value of entry.
         */
        private V value;

        /**
         * Constructor of entry.
         * @param key key.
         * @param value value.
         */
        Entry(T key, V value) {
            this.key = key;
            this.value = value;
        }

        /**
         * Getter for key.
         * @return key.
         */
        public T getKey() {
            return key;
        }

        /**
         * Getter for values.
         * @return values.
         */
        public V getValue() {
            return value;
        }

        /**
         * Overrided method toString for better visible results.
         * @return
         */
        @Override
        public String toString() {
            return String.format("Key: %s Value: %s", this.getKey(), this.getValue());
        }
    }
}
