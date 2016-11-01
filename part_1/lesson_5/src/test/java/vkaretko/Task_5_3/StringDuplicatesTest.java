package vkaretko.Task_5_3;

import org.junit.Test;

import static org.hamcrest.core.Is.is;
import static org.junit.Assert.assertThat;

/**
 * Test-class for StringDuplicates (Part_1, Lesson_5, Task_5_3)
 *
 * @author Karetko Victor
 * @version 1.00
 * @since 01.11.2016
 */
public class StringDuplicatesTest {
    @Test
    public void whenStringDuplicateRemoveFromStringArrayThenResultStringArrayWithoutDuplicates() {
        StringDuplicates stringDup = new StringDuplicates();
        String[] array = {"test1", "test2", "test1", "test3", "test2", "test4"};
        String[] arrayWithoutDuplicates = {"test1", "test2", "test3", "test4"};
        assertThat(stringDup.remove(array), is(arrayWithoutDuplicates));
    }

}
