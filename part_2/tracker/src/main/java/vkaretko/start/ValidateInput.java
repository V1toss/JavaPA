package vkaretko.start;

/**
 * Class for validating input, extends from ConsoleInput
 *
 * @author Karetko Victor
 * @version 1.00
 * @since 05.11.2016
 */
public class ValidateInput extends ConsoleInput {

    /**
     * Method for asking questions to users and shows messages about wrong inputs
     *
     * @param question question to print in console
     * @param range range of actions
     * @return user answer
     */
    @Override
    public int ask(String question, int[] range) {
        boolean isInvalid = true;
        int value = -1;
        do {
            try {
                value = super.ask(question, range);
                isInvalid = false;
            } catch (NumberFormatException nfe) {
                System.out.println("Please enter validate data again.");
            } catch (MenuOutException moe) {
                System.out.println("Please select key from menu.");
            }
        } while (isInvalid);
        return value;
    }
}
