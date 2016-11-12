package vkaretko.figures;

import vkaretko.game.ChessFigure;

/**
 * Class of King figure.
 *
 * @author Karetko Victor
 * @version 1.00
 * @since 04.11.2016
 */

public class King extends ChessFigure {
    /**
     * Max step of king figure.
     */
    private final int maxStep = 1;
    /**
     * Name of figure.
     */
    private String name = "King";
    /**
     * Color of figure.
     */
    private Boolean white;

    /**
     * Constructor of King class.
     * @param white - white or black color
     */
    public King(Boolean white) {
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
        return this.white;
    }

    /**
     * Getter of max step value.
     * @return max step value
     */
    public int getMaxStep() {
        return this.maxStep;
    }
}
