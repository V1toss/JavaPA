package vkaretko;

import java.util.NoSuchElementException;

/**
 * Abstract classes BaseStore for implementing behaviors of extended stores.
 * @author Karetko Victor
 * @version 1.00
 * @since 16.12.2016
 * @param <E> parametrized type.
 */
public abstract class BaseStore<E extends Base> implements Store<E> {
    /**
     * Size of store.
     */
    private final int storeSize = 10;

    /**
     * Array of stores.
     */
    private SimpleArray<E> stores = new SimpleArray<>(storeSize);

    /**
     * Method add new element to list of stores.
     * @param value element to add.
     */
    @Override
    public void add(E value) {
        stores.add(value);
    }

    /**
     * Method get element by id.
     * @param id of element to get.
     * @return element.
     */
    @Override
    public E get(String id) {
        return stores.get(findById(id));
    }

    /**
     * Update element of store by id.
     */
    @Override
    public void update(String id, E value) {
        this.stores.update(findById(id), value);
    }

    /**
     * Delete element by id.
     * @param id id of element to delete.
     */
    @Override
    public void delete(String id) {
        this.stores.delete(findById(id));
    }

    /**
     * Find index of element by id.
     * @param id id to find.
     * @return index of element in store.
     */
    private Integer findById(String id) {
       Integer result = null;
       for (int index = 0; index < storeSize; index++) {
          if (stores.get(index) != null && stores.get(index).getId().equals(id)) {
              result = index;
              break;
          } else if (index == storeSize - 1) {
              throw new NoSuchElementException("No element with such id.");
          }
       }
       return result;
    }
}
