package vkaretko;

/**
 * Class for checking Bracket sequence.
 *
 * @author Karetko Victor
 * @version 1.00
 * @since 13.11.2016
 */

public class BracketCheck {
    /**
     * Method for checking Bracket sequence.
     * @param line - line with bracket sequence
     * @return result of check
     */
    public boolean checkLine(String line) {
        String[] arrayOfBrackets = line.split("");

        int flag = 0;
        boolean result = true;
        for (String element : arrayOfBrackets) {
            if (element.equals("(")) {
                flag++;
            } else if (element.equals(")")) {
                flag--;
            }
            if (flag < 0) {
                result = false;
            }
        }
        return result;
    }
}
