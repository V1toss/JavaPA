package vkaretko.start;

/**
 * Interface Input
 *
 * @author Karetko Victor
 * @version 1.00
 * @since 18.02.2017
 */
public interface Input {
    String ask(String question);

    int ask(String question, int[] range);
}
