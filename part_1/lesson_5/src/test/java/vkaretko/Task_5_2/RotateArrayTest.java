package vkaretko.Task_5_2;

import org.junit.Test;

import static org.hamcrest.core.Is.is;
import static org.junit.Assert.assertThat;

/**
 * Test-class for RotateArray (Part_1, Lesson_5, Task_5_2)
 *
 * @author Karetko Victor
 * @version 1.00
 * @since 01.11.2016
 */
public class RotateArrayTest {
    @Test
    public void whenRotateTwoDimensionalArrayWithThreeRowsAndColumnsThenResultRotatedArray() {
        RotateArray rot = new RotateArray();
        int[][] array = {
                {1,2,3},
                {4,5,6},
                {7,8,9}
        };
        int[][] rotatedArray = {
                {7,4,1},
                {8,5,2},
                {9,6,3}
        };
        assertThat(rot.rotate(array), is(rotatedArray));
    }
}
