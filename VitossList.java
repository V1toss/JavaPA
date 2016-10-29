package VitossList;

/**
 * Created by Vitoss on 29.10.2016.
 */
public class VitossList {

    private int[] array;
    private int index;
    private int defaultSize = 6;
    private int size = defaultSize;

    public VitossList() {
        array = new int[defaultSize];
        }

    public void add(int value) {

        if (index == size) {
            size = index*2;
            int[] bufArray = new int[size];
            System.arraycopy(array, 0, bufArray, 0, index);
            array = bufArray;
        }
        array[index] = value;
        index++;
    }

    public int get(int item) {
        return array[item];
       }

    public void set(int index, int element) {
        array[index] = element;
    }

    public int size() {
        return index;
    }

    public int[] remove(int item) {

        int[] bufArray = new int[index];
        System.arraycopy(array, 0, bufArray, 0, item);
        System.arraycopy(array, item + 1, bufArray, item, index - item);
        array = bufArray;
        index--;
        return array;
    }

    public void clean() {

        array = new int[defaultSize];
        index = 0;
    }

}
