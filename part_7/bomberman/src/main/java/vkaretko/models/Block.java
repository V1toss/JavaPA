package vkaretko.models;

/**
 * Class
 *
 * @author Karetko Victor.
 * @version 1.00.
 * @since 05.02.2017.
 */
public class Block extends Figure {

    /**
     * Always return false, because Block cant move.
     * @param field game field.
     * @param x x coord.
     * @param y y coord.
     * @param stepX step through x coord.
     * @param stepY step through y coord.
     * @return false.
     */
    @Override
    public boolean makeStep(Cell[][] field, int x, int y, int stepX, int stepY) {
        return false;
    }
}
