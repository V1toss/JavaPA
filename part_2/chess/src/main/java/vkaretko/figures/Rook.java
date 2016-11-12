package vkaretko.figures;

import vkaretko.game.ChessFigure;

/**
 * Class of Rook figure.
 *
 * @author Karetko Victor
 * @version 1.00
 * @since 04.11.2016
 */
public class Rook extends ChessFigure {
    /**
     * Name of figure.
     */
    private String name = "Rook";
    /**
     * Color of figure.
     */
    private Boolean white;
    /**
     * Constructor of Rook class.
     * @param white - white or black color
     */
    public Rook(Boolean white) {
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
}
