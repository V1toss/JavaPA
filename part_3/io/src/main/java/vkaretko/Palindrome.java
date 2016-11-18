package vkaretko;

import java.util.Scanner;

/**
 * Class Palindrome for checking that word is palindrome.
 *
 * @author Karetko Victor
 * @version 1.00
 * @since 17.11.2016
 */
public class Palindrome {

    /**
     * Method checks word for palindrome.
     */
    public void init() {
        final int MAX_LENGTH_OF_WORD = 5;
        try (Scanner sc = new Scanner(System.in)) {
            String line = sc.nextLine();
            if (line.length() == MAX_LENGTH_OF_WORD) {
                StringBuilder sbReverseWord = new StringBuilder();
                for (int i = line.length() - 1; i >= 0; i--) {
                    sbReverseWord.append(line.charAt(i));
                }
                if (line.toLowerCase().equals(sbReverseWord.toString().toLowerCase())) {
                    print(line, "is palindrome");
                } else {
                    print(line, "is NOT palindrome");
                }
            } else {
                print(line, "has not 5 symbols");
            }
        }
    }

    /**
     * Method to print word and message.
     * @param word - entered word from console
     * @param msg - message to user
     */
    private void print(String word, String msg) {
        System.out.println(String.format("%s %s", word, msg));
    }
}
