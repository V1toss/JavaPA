package vkaretko;

import org.junit.Test;

import static org.hamcrest.core.Is.is;
import static org.junit.Assert.assertThat;

/**
 * Test-class for ExtraArrayTask
 *
 * @author Karetko Victor
 * @version 1.00
 * @since 03.11.2016
 */
public class ExtraArrayTaskTest {
    @Test
    public void whenMergeTwoSortedArraysInOneThenResultOneSortedArray() {
        ExtraArrayTask array = new ExtraArrayTask();
        int[] array1 = {1, 2, 3, 4, 9, 11, 14};
        int[] array2 = {2, 4, 5, 7, 8};
        int[] mergedArray = {1, 2, 2, 3, 4, 4, 5, 7, 8, 9, 11, 14};
        assertThat(array.merge(array1,array2), is(mergedArray));
    }
}
