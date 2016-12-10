package vkaretko;

/**
 * Class WrongKeyException for displaying when there are unnecessary keys in keymap.
 *
 * @author Karetko Victor
 * @version 1.00
 * @since 10.12.2016
 */
public class WrongKeyException extends RuntimeException {
    /**
     * Constructor of class WrongKeyException.
     * @param msg message to show.
     */
    public WrongKeyException(String msg) {
        super(msg);
    }
}
