package vkaretko;

/**
 * Position class.
 * @author Karetko Victor
 * @version 1.00
 * @since 16.12.2016
 */
public class Position {
    /**
     * X coordinate.
     */
    private int x;

    /**
     * Y coordinate.
     */
    private int y;

    /**
     * Constructor of position.
     * @param x x coordinate.
     * @param y y coordinate.
     */
    public Position(int x, int y) {
        this.x = x;
        this.y = y;
    }

    /**
     * Getter method for x.
     * @return x.
     */
    public int getX() {
        return this.x;
    }

    /**
     * Getter method for y.
     * @return y.
     */
    public int getY() {
        return this.y;
    }
}
