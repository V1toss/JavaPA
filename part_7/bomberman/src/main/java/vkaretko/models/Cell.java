package vkaretko.models;

/**
 * Class
 *
 * @author Karetko Victor.
 * @version 1.00.
 * @since 05.02.2017.
 */
public class Cell {
    /**
     * Figure in cell.
      */
    private Figure figure;

    /**
     * Getter for figure from cell.
     * @return figure.
     */
    public Figure getFigure() {
        synchronized (this) {
            return this.figure;
        }
    }

    /**
     * Setter for figure in cell.
     * @param figure figure to set in cell.
     */
    public void setFigure(Figure figure) {
        synchronized (this) {
            this.figure = figure;
        }
    }
}
