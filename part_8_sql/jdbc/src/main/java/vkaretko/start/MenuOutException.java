package vkaretko.start;

/**
 * Class for creating MenuOutException
 *
 * @author Karetko Victor
 * @version 1.00
 * @since 18.02.2017
 */
public class MenuOutException extends RuntimeException{

    /**
     * Constructor of MenuOutException
     * @param msg message of exception
     */
    public MenuOutException(String msg) {
        super(msg);
    }
}
