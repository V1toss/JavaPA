package vkaretko.models;

/**
 * Class Figure.
 *
 * @author Karetko Victor.
 * @version 1.00.
 * @since 05.02.2017.
 */
public abstract class Figure {
    /**
     * Method for makeing steps of figures.
     * @param field game field.
     * @param x x coord.
     * @param y y coord.
     * @param stepX step through x coord.
     * @param stepY step through y coord.
     * @return true if figure made step, false otherwise.
     */
    public boolean makeStep(Cell[][] field, int x, int y, int stepX, int stepY) {
        boolean result = false;
        synchronized (field[x + stepX][y + stepY]) {
            if (field[x + stepX][y + stepY].getFigure() == null) {
                field[x + stepX][y + stepY].setFigure(field[x][y].getFigure());
                field[x][y].setFigure(null);
                result = true;
            }
        }
        return result;
    }
}
