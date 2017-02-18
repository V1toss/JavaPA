package vkaretko.start;

/**
 * Interface Input.
 *
 * @author Karetko Victor
 * @version 1.00
 * @since 18.02.2017
 */
public interface Input {
    /**
     * Method for asking question.
     * @param question question to ask.
     * @return answer.
     */
    String ask(String question);

    /**
     * Method for asking.
     * @param question question to ask.
     * @param range range of menu items.
     * @return selected menu item/
     */
    int ask(String question, int[] range);
}
