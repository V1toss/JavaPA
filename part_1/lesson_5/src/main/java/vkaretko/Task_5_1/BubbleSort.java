package vkaretko.Task_5_1;

/**
 * Part 1. Base syntax
 * Lesson 5. Arrays
 * Task 1. Create a program for bubble sort
 *
 * @author Karetko Victor
 * @version 1.00
 * @since 01.11.2016
 */
public class BubbleSort {
    /**
     * Bubble sort method
     *
     * @param values unsorted array of int
     * @return sorted array of int
     */
    public int[] sort (int[] values) {
        for (int i = values.length-1; i >= 0; i--) {
            for (int j = 0; j < i; j++) {
                if (values[j] > values[j+1]) {
                    int tempValue = values[j];
                    values[j] = values[j+1];
                    values[j+1] = tempValue;
                }
            }
        }
        return values;
    }
}
