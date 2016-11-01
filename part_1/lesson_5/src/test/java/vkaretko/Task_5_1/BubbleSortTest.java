package vkaretko.Task_5_1;

import org.junit.Test;

import static org.hamcrest.core.Is.is;
import static org.junit.Assert.assertThat;

/**
 * Test-class for BubbleSort (Part_1, Lesson_5, Task_5_1)
 *
 * @author Karetko Victor
 * @version 1.00
 * @since 01.11.2016
 */
public class BubbleSortTest {
    @Test
    public void whenSortUnsortedArrayOfTenIntegersThenResultSortedArrayOfTenIntegers() {
        BubbleSort bubl = new BubbleSort();
        int[] unsortedArray = {5,3,7,9,112,1,6,8,11,4};
        int[] sortedArray = {1,3,4,5,6,7,8,9,11,112};
        assertThat(bubl.sort(unsortedArray), is(sortedArray));
    }
}
