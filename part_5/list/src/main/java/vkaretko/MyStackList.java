package vkaretko;

/**
 * Class MyStackList.
 * Simple implementation of MyStackList based on MyLinkedList.
 * @author Karetko Victor
 * @version 1.00
 * @since 22.12.2016
 * @param <E> parametrized type.
 */
public class MyStackList<E> extends MyLinkedList<E> {
    /**
     * Method gets last element in list.
     * @return last element.
     */
    public E peek() {
        return this.get(size() - 1);
    }

    /**
     * Method returns last element and removes it from list.
     * @return last element.
     */
    public E pop() {
        E result = get(size() - 1);
        remove(size() - 1);
        return result;
    }

    /**
     * Add method for stack.
     * @param e element to add.
     */
    public void push(E e) {
        add(e);
    }
}
