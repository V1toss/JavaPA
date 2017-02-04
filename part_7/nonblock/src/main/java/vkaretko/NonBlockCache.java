package vkaretko;

import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

/**
 * Class NonBlockCache - simple implementation of non blocking cache using Concurrent Hash Map.
 *
 * @author Karetko Victor.
 * @version 1.00.
 * @since 04.02.2017.
 * @param <K> parametrized type for key.
 * @param <V> parametrized type for value.
 */
public class NonBlockCache<K, V extends Model> {
    /**
     * Map for cache.
     */
    private final Map<K, V> cache = new ConcurrentHashMap<>();

    /**
     * Method for adding key and value to map.
     * @param key key to add
     * @param value value to add
     */
    public void add(K key, V value) {
        this.cache.putIfAbsent(key, value);
    }

    /**
     * Method deletes value by key.
     * @param key key of element.
     */
    public void delete(K key) {
        this.cache.computeIfPresent(key, (k, v) -> null);
    }

    /**
     * Method update value by key.
     * @param key key to update.
     * @param value value to update.
     * @throws OptimisticException if another version.
     * @return updated item.
     */
    public V update(K key, V value) throws OptimisticException {
        if (value.getVersion() == get(key).getVersion()) {
            value.update();
        } else {
            throw new OptimisticException("Another version");
        }
        return this.cache.computeIfPresent(key, (k, v) -> value);
    }

    /**
     * Get value by key.
     * @param key key to search.
     * @return value.
     */
    public V get(K key) {
        return this.cache.getOrDefault(key, null);
    }
}
