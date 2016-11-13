package vkaretko.figures;

import vkaretko.game.ChessBoardException;
import vkaretko.game.ChessFigure;
import vkaretko.game.Move;

/**
 * Class of Pawn figure.
 *
 * @author Karetko Victor
 * @version 1.00
 * @since 04.11.2016
 */
public class Pawn extends ChessFigure {
    /**
     * Name of figure.
     */
    private String name = "Pawn";
    /**
     * Color of figure.
     */
    private Boolean white;
    /**
     * First move of figure or not.
     */
    private Boolean isFirstMove = true;

    /**
     * Constructor of Pawn class.
     * @param white - white or black color
     */
    public Pawn(Boolean white) {
        this.white = white;
    }

    /**
     * Getter of name value.
     * @return name of figure
     */
    public String getName() {
        return this.name;
    }

    /**
     * Getter of white value.
     * @return color of figure (White = true)
     */
    public boolean isWhite() {
        return white;
    }

    /**
     * Getter of first move value.
     * @return status of first move
     */
    public Boolean isFirstMove() {
        return isFirstMove;
    }

    /**
     * Setter of first move value.
     * @param firstMove status of first move
     */
    public void setFirstMove(Boolean firstMove) {
        isFirstMove = firstMove;
    }

    /**
     * Method moving Pawn.
     * @param move move of Pawn
     * @throws ChessBoardException if move is wrong
     */
    @Override
    public void makeMove(Move move) throws ChessBoardException {
        move.movePawn();
    }
}
