package vkaretko.figures;

import vkaretko.game.ChessBoardException;
import vkaretko.game.ChessFigure;
import vkaretko.game.Move;

/**
 * Class of Queen figure.
 *
 * @author Karetko Victor
 * @version 1.00
 * @since 04.11.2016
 */
public class Queen extends ChessFigure {

    /**
     * Name of figure.
     */
    private String name = "Queen";
    /**
     * Color of figure.
     */
    private Boolean white;

    /**
     * Constructor of Queen class.
     * @param white - white or black color
     */
    public Queen(Boolean white) {
        this.white = white;
    }

    /**
     * Getter of name value.
     * @return name of figure
     */
    public String getName() {
        return name;
    }

    /**
     * Getter of white value.
     * @return color of figure (White = true)
     */
    public boolean isWhite() {
        return white;
    }

    /**
     * Method moving Queen.
     * @param move move of Queen
     * @throws ChessBoardException if move is wrong
     */
    @Override
    public void makeMove(Move move) throws ChessBoardException {
        move.moveQueen();
    }
}
