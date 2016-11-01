package vkaretko.Task_5_3;

/**
 * Part 1. Base syntax
 * Lesson 5. Arrays
 * Task 3. Create a program for remove duplicates from String array
 *
 * @author Karetko Victor
 * @version 1.00
 * @since 01.11.2016
 */
public class StringDuplicates {

    /**
     * Method removes duplicates from String array
     *
     * @param array array of string
     * @return array of string without duplicates
     */
    public String[] remove (String[] array) {

        int countDuplicates = 0;
        for (int i = 0; i < array.length-1; i++) {
            if (array[i] != null) {
                for (int j = i + 1; j < array.length; j++) {
                    if (array[i].equals(array[j])) {
                        array[j] = null;
                        countDuplicates++;
                    }
                }
            }
        }

        String[] resultArray = new String[array.length-countDuplicates];
        int index = 0;
        for (String element : array) {
            if (element != null) {
                resultArray[index] = element;
                index++;
            }
        }
        return resultArray;
    }
}
