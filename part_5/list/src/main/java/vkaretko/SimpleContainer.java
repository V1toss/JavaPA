package vkaretko;

/**
 * Interface for lists for implementing two methods.
 * @author Karetko Victor
 * @version 1.00
 * @since 20.12.2016
 * @param <E> parametrized type.
 */
public interface SimpleContainer<E> extends Iterable<E> {
    /**
     * Add new element to list.
     * @param e element to add.
     */
    void add(E e);
    /**
     * Method get element from list.
     * @param index index of element.
     * @return element of list.
     */
    E get(int index);
}
