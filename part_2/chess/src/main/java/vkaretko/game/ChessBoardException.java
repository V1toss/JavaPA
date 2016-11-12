package vkaretko.game;

/**
 * Class of Rook figure, extends from RuntimeException.
 *
 * @author Karetko Victor
 * @version 1.00
 * @since 04.11.2016
 */
public class ChessBoardException extends RuntimeException {
    /**
     * Constructor of ChessBoardException class.
     * @param msg message of exception
     */
    public ChessBoardException(String msg) {
        super(msg);
    }
}
