package vkaretko.start;

/**
 * Interface Input
 *
 * @author Karetko Victor
 * @version 1.00
 * @since 05.11.2016
 */
public interface Input {
    String ask(String question);

    int ask (String question, int[] range);
}
