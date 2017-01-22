package vkaretko;

import java.util.Iterator;
import java.util.NoSuchElementException;

/**
 * Class LinkedList with synchronize.
 * @author Karetko Victor
 * @version 1.00
 * @since 22.01.2017
 * @param <E> parametrized type.
 */
public class LinkedList<E> implements Iterable<E> {
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
     * Method add element to list.
     * @param e element to add.
     */
    public synchronized void add(E e) {
        Entry<E> last = lastEntry;
        Entry<E> newEntry = new Entry<E>(e, null, null);
        lastEntry = newEntry;
        if (this.firstEntry == null) {
            this.firstEntry = newEntry;
        } else {
            last.next = newEntry;
            newEntry.previous = last;
        }
        size++;
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
         * Current node.
         */
        private Entry<E> currentNode;

        /**
         * Constructor of iterator.
         */
        public Itr() {
            this.currentNode = firstEntry;
        }

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
            if (!hasNext()) {
                throw new NoSuchElementException();
            }
            E item = currentNode.element;
            currentNode = currentNode.next;
            cursor++;
            return item;
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
