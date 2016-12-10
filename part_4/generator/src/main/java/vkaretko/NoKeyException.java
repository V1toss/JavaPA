package vkaretko;

/**
 * Class NoKeyException for displaying when no key in keymap.
 *
 * @author Karetko Victor
 * @version 1.00
 * @since 07.12.2016
 */
public class NoKeyException extends RuntimeException {
    /**
     * Constructor of class NoKeyException.
     * @param msg message to show.
     */
    public NoKeyException(String msg) {
        super(msg);
    }
}
