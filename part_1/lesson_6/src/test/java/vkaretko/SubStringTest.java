package vkaretko;

import org.junit.Test;

import static org.hamcrest.core.Is.is;
import static org.junit.Assert.assertThat;

/**
 * Test-class for SubString (Part_1, Lesson_6)
 *
 * @author Karetko Victor
 * @version 1.00
 * @since 01.11.2016
 */
public class SubStringTest {
    @Test
    public void whenStringFromAToZContainsSubstringStuThenResultTrue() {
        SubString subStr = new SubString();
        String testString = "abcdefghijklmnopqrstuvwxyz";
        String testSubString = "stu";
        assertThat(subStr.contains(testString,testSubString), is(true));
    }

    @Test
    public void whenStringFromAToZContainsSubstringMnopqThenResultTrue() {
        SubString subStr = new SubString();
        String testString = "abcdefghijklmnopqrstuvwxyz";
        String testSubString = "mnopq";
        assertThat(subStr.contains(testString,testSubString), is(true));
    }

    @Test
    public void whenStringFromAToZNotContainsSubstringStunThenResultFalse() {
        SubString subStr = new SubString();
        String testString = "abcdefghijklmnopqrstuvwxyz";
        String testSubString = "stun";
        assertThat(subStr.contains(testString,testSubString), is(false));
    }

}
