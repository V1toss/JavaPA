package vkaretko.models;

/**
 * Class Player.
 *
 * @author Karetko Victor.
 * @version 1.00.
 * @since 05.02.2017.
 */
public class Player extends Figure {
    /**
     * Constructor of player class.
     * @param x X coord.
     * @param y Y coord.
     * @param field Game Field.
     */
    public Player(Cell[][] field, int x, int y) {
        super(field, x, y);
    }
}
