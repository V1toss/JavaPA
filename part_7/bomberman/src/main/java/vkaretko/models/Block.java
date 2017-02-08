package vkaretko.models;

/**
 * Class Block - inactive blocks on game field.
 *
 * @author Karetko Victor.
 * @version 1.00.
 * @since 05.02.2017.
 */
public class Block extends Figure {

    /**
     * Constructor of class Block.
     * @param x X coord.
     * @param y Y coord.
     * @param field game field.
     */
    public Block(Cell[][] field, int x, int y) {
        super(field, x, y);
    }

    /**
     * Always return false, because Block cant move.
     * @param dir direction to step.
     * @return false.
     */
    @Override
    public boolean makeStep(Direction dir) {
        return false;
    }
}
