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
     * X coordinate.
     */
    private int x;

    /**
     * Y coordinate.
     */
    private int y;

    /**
     * Game field.
     */
    private Cell[][] field;

    /**
     * COnstructor of class Figure.
     * @param x x coord.
     * @param y y coord.
     */

    public Figure(Cell[][] field, int x, int y) {
        this.x = x;
        this.y = y;
        this.field = field;
    }

    /**
     * Method for makeing steps of figures.
     * @param dir direction to go.
     * @return true if figure made step, false otherwise.
     */
    public boolean makeStep(Direction dir) {
        boolean result;
        final int destX = this.x + dir.get()[0];
        final int destY = this.y + dir.get()[1];
        if (destX >= field.length || destY >= field.length || destX < 0 || destY < 0) {
            result = false;
        } else {
            synchronized (field[destX][destY]) {
                if (field[destX][destY].getFigure() == null) {
                    field[destX][destY].setFigure(this);
                    System.out.println(String.format("%s %s:%s", Thread.currentThread().getName(), destX, destY));
                    field[x][y].setFigure(null);
                    this.x = destX;
                    this.y = destY;
                    result = true;
                } else {
                    result = false;
                }
            }
        }
        return result;
    }
}
