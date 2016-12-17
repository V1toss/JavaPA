package vkaretko;

/**
 * Interface Store.
 * @author Karetko Victor
 * @version 1.00
 * @since 16.12.2016
 * @param <E> parametrized type.
 */
public interface Store<E extends Base> {
    /**
     * Method add element to store.
     * @param value element to add
     */
    void add(E value);

    /**
     * Method get element from store.
     * @param id id of element.
     * @return element from store.
     */
    E get(String id);

    /**
     * Method update element of store by id.
     * @param id id of element.
     * @param value element to update.
     */
    void update(String id, E value);

    /**
     * Method delete element of store by id.
     * @param id id of element to delete.
     */
    void delete(String id);
}
