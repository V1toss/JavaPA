package vkaretko.Task_5_2;

/**
 * Part 1. Base syntax
 * Lesson 5. Arrays
 * Task 2. Create a program for rotate two-dimensional arrays
 *
 * @author Karetko Victor
 * @version 1.00
 * @since 01.11.2016
 */
public class RotateArray {

    /**
     * Method rotates two-dimensional array
     *
     * @param values two-dimensional array of int
     * @return rotated array
     */
    public int[][] rotate (int[][] values) {
        int[][] rotatedArray = new int[values.length][values.length];

        for (int i = 0; i < values.length; i++) {
            for (int j = 0; j < values.length; j++) {
                    rotatedArray[i][j] = values[values.length - j - 1][i];
                }
            }
        return rotatedArray;
    }
}
