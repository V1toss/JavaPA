package vkaretko;

/**
 * Class OptimisticException.
 *
 * @author Karetko Victor.
 * @version 1.00.
 * @since 05.02.2017.
 */
public class OptimisticException extends RuntimeException {
    /**
     * Constructor of class Optimistic Exception.
     * @param msg msg to send.
     */
    public OptimisticException(String msg) {
        super(msg);
    }
}
