package vkaretko;

/**
 * Part 1. Base syntax
 * Lesson 6. Control questions and test task.
 * Task. Create a program, that checks string "sub" is substring of "origin"
 * Do not use methods String.indexOf and String.contains.
 * Convert a string to an array of characters and check.
 *
 * @author Karetko Victor
 * @version 1.00
 * @since 02.11.2016
 */
public class SubString {
    /**
     * Method checks whether the string contains a substring
     *
     * @param origin string in which to search the substring
     * @param sub substring to check
     * @return true if the string contains a substring and false otherwise
     */
    boolean contains(String origin, String sub) {

        boolean result = false;

        char[] originChars = origin.toCharArray();
        char[] subChars = sub.toCharArray();

        for (int i = 0; i < originChars.length - subChars.length; i++) {
            if (originChars[i] == subChars[0]) {
                int count = 0;
                for (int j = 0; j < subChars.length; j++) {
                    if (originChars[i+j] == subChars[j]) {
                        count++;
                    }
                }
                if (count == subChars.length) {
                    result = true;
                }
            }
        }
        return result;
    }
}
