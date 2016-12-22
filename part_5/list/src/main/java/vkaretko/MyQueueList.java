package vkaretko;

/**
 * Class MyQueueList.
 * Simple implementation of MyQueueList based on MyLinkedList.
 * @author Karetko Victor
 * @version 1.00
 * @since 22.12.2016
 * @param <E> parametrized type.
 */
public class MyQueueList<E> extends MyLinkedList<E> {
    /**
     * Add element to list.
     * @param e element to add.
     */
    public void offer(E e) {
        add(e);
    }

    /**
     * Get first element from list.
     * @return first element of list.
     */
    public E peek() {
        return this.get(0);
    }

    /**
     * Return first element from queue and remove it from list.
     * @return first element.
     */
    public E poll() {
        E result = this.get(0);
        remove(0);
        return result;
    }
}
