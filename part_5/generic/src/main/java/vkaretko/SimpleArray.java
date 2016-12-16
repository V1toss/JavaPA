package vkaretko;

/**
 * Class SimpleArray.
 *
 * @author Karetko Victor
 * @version 1.00
 * @since 16.12.2016
 */
public class SimpleArray<E> {
    /**
     * Array of objects.
     */
    private Object[] objects;
    /**
     * Index of last element.
     */
    private int index = 0;

    /**
     * Constructor of SimpleArray.
     * @param size
     */
    public SimpleArray(int size) {
        this.objects = new Object[size];
    }

    /**
     * Method adds new value in SimpleArray.
     * @param value value to add.
     */
    public void add(E value) {
        this.objects[index++] = value;
    }

    /**
     * Method returns value of Simpley array ny index.
     * @param position position of element array.
     * @return value of array/
     */
    public E get(int position) {
        return (E) this.objects[position];
    }

    /**
     * Update value of array by key.
     * @param position index of element to update.
     * @param value value to update.
     */
    public void update(int position, E value) {
        this.objects[position] = value;
    }

    /**
     * Delete value of SimpleArray.
     * @param position index of element to delete.
     */
    public void delete(int position) {
        System.arraycopy(objects, position + 1, objects, position, objects.length - position - 1);
    }
}
