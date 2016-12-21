package vkaretko;

import java.util.Iterator;
import java.util.NoSuchElementException;

/**
 * Class MyLinkedList.
 * Simple implementation of LinkedList class with methods add and get.
 * @author Karetko Victor
 * @version 1.00
 * @since 20.12.2016
 * @param <E> parametrized type.
 */
public class MyLinkedList<E> implements SimpleContainer<E> {
    /**
     * Size of list.
     */
    private int size = 0;
    /**
     * First entry in list.
     */
    private Entry<E> firstEntry;
    /**
     * Last entry in list.
     */
    private Entry<E> lastEntry;

    /**
     * Get method of list.
     * Method call search method with index argument.
     * @param index index of element.
     * @return element.
     */
    @Override
    public E get(int index) {
        return search(index).element;
    }

    /**
     * Method add element to list.
     * @param e element to add.
     */
    @Override
    public void add(E e) {
        Entry<E> newEntry = new Entry<>(e, null, this.lastEntry);
        if (this.lastEntry == null) {
            this.firstEntry = newEntry;
        } else {
            newEntry.next = newEntry;
        }
        this.lastEntry = newEntry;
        size++;
     }

    /**
     * Getter-method for field size.
     * @return size of list.
     */
    public int size() {
        return this.size;
    }

    /**
     * Method search element by index in list.
     * @param index index of element.
     * @return element.
     */
    private Entry<E> search(int index) {
        Entry<E> element;
        if (index < 0 || index > size()) {
            throw new IndexOutOfBoundsException("No element with such index");
        }
        if (index < (size >> 1)) {
            element = this.firstEntry;
            for (int ind = 0; ind < index; ind++) {
                element = element.next;
            }
        } else {
            element = this.lastEntry;
            for (int ind = size - 1; ind > index; ind--) {
                element = element.previous;
            }
        }
        return element;
    }

    /**
     * Overrided method, creates new Iterator for MyLinkedList.
     * @return iterator.
     */
    @Override
    public Iterator iterator() {
        return new Itr();
    }

    /**
     * Private class Itr, implementing Iterator for MyLinkedList.
     */
    private class Itr implements Iterator<E> {
        /**
         * Cursor of element.
         */
        private int cursor = 0;
        /**
         * Method check if list has next element.
         * @return true if has next element, false otherwise.
         */
        @Override
        public boolean hasNext() {
            return cursor != size;
        }

        /**
         * Method for selection next element in list.
         * @return next element.
         */
        @Override
        public E next() {
            try {
                cursor++;
                return get(cursor - 1);
            } catch (NullPointerException npe) {
                throw new NoSuchElementException("No more elements in list");
            }
        }
    }


    /**
     * Private class for creating Double-linked entries in MyLinkedList.
     * @param <E> parametrized type.
     */
    private class Entry<E> {
        /**
         * Element - field, that holds data of type E in entry.
         */
        private E element;
        /**
         * Field next holds link of next element in list.
         */
        private Entry<E> next;
        /**
         * Field previous holds link of previous element in list.
         */
        private Entry<E> previous;
        /**
         * Constructor of class Entry.
         * @param element data to save in entry.
         * @param next link of next element.
         * @param previous link of previous element.
         */
        Entry(E element, Entry<E> next, Entry<E> previous) {
            this.element = element;
            this.next = next;
            this.previous = previous;
        }
    }


}
