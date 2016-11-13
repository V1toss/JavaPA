package vkaretko.figures;

import vkaretko.game.ChessBoardException;
import vkaretko.game.ChessFigure;
import vkaretko.game.Move;

/**
 * Class of Knight figure.
 *
 * @author Karetko Victor
 * @version 1.00
 * @since 04.11.2016
 */
public class Knight extends ChessFigure {
    /**
     * Name of figure.
     */
    private String name = "Knight";
    /**
     * Color of figure.
     */
    private Boolean white;

    /**
     * Number of steps of knight figure.
     */
    private final int steps = 3;

    /**
     * Constructor of Knight class.
     * @param white - white or black color
     */
    public Knight(Boolean white) {
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
     * Getter of Knight steps.
     * @return value of steps
     */
    public int getSteps() {
        return steps;
    }

    /**
     * Method moving Knight.
     * @param move move of Knight
     * @throws ChessBoardException if move is wrong
     */
    @Override
    public void makeMove(Move move) throws ChessBoardException {
        move.moveKnight();
    }
}
