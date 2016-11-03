package vkaretko;

/**
 * Part 1. Base syntax
 * Lesson 6. Control questions and test task.
 * ExtraTask. Merge two sorted arrays in one sorted array.
 *
 * @author Karetko Victor
 * @version 1.00
 * @since 03.11.2016
 */
public class ExtraArrayTask {

    /**
     * Method merges two sorted arrays in one
     *
     * @param array1 first sorted array
     * @param array2 second sorted array
     * @return merged sorted array
     */
    public int[] merge (int[] array1, int[] array2) {
        int[] resultArray = new int[array1.length + array2.length];
        int indexArray1 = 0;
        int indexArray2 = 0;

        for (int i = 0; i < resultArray.length; i++) {
            if ((indexArray1 < array1.length) && (indexArray2 < array2.length)) {
                resultArray[i] = array1[indexArray1] < array2[indexArray2] ? array1[indexArray1++] : array2[indexArray2++];
            } else if (indexArray1 == array1.length) {
                resultArray[i] = array2[indexArray2++];
            } else if (indexArray2 == array2.length) {
                resultArray[i] = array1[indexArray1++];
            }
        }
        return resultArray;
    }
}
