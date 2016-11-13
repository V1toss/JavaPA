package vkaretko;

import java.io.InputStream;
import java.util.Scanner;

/**
 * Class EvenNumber for checking even numbers is stream.
 *
 * @author Karetko Victor
 * @version 1.00
 * @since 13.11.2016
 */
public class EvenNumber {
    /**
     * Class EvenNumber for checking even numbers is stream.
     * @param in input stream with number
     * @return true if even number and false if odd number
     */
    public boolean isNumber(InputStream in) {
        boolean result = false;
        Scanner sc = new Scanner(in);

        while (sc.hasNextInt()) {
            if (sc.nextInt() % 2 == 0) {
                result = true;
            }
        }
        return result;
    }
}
