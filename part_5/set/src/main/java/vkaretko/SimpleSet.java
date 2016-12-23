package vkaretko;

/**
 * Interface for set with one method.
 * @author Karetko Victor
 * @version 1.00
 * @since 22.12.2016
 * @param <E> parametrized type.
 */
public interface SimpleSet<E> extends Iterable<E> {
    /**
     * Method add element to set.
     * @param e element to add.
     */
    void add(E e);
}
