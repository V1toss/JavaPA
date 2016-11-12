package vkaretko.game;

/**
 * Class of Cell.
 *
 * @author Karetko Victor
 * @version 1.00
 * @since 04.11.2016
 */
public class Cell {
    /**
     * Figure in cell.
     */
    private ChessFigure figure;

    /**
     * Setter of figure.
     * @param figure chess figure
     */
    public void setFigure(ChessFigure figure) {
        this.figure = figure;
    }

    /**
     * Getter of figure from cell.
     * @return figure
     */
    public ChessFigure getFigure() {
        return this.figure;
    }

    /**
     * Getter of Cell status.
     * @return true if cell empty
     */
    public boolean isEmpty() {
        return this.figure == null;
    }
}