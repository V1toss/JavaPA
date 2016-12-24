package vkaretko.handbook;
/**
 * Interface SimpleMap for creating maps for task 5.5.8.
 * @author Karetko Victor
 * @version 1.00
 * @since 24.12.2016
 * @param <T> parametrized type for key.
 * @param <V> parametrized type for value.
 */
public interface SimpleMap<T, V> extends Iterable {
    /**
     * Method adds new pair key value.
     * @param key key.
     * @param value value.
     * @return true if inserted, false otherwise.
     */
    boolean insert(T key, V value);
    /**
     * Get value by key.
     * @param key key to search.
     * @return value.
     */
    V get(T key);
    /**
     * Delete element from map.
     * @param key key of element to delete.
     * @return true if deleted, false otherwise.
     */
    boolean delete(T key);
}
