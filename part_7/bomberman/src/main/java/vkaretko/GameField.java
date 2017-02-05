package vkaretko;

import vkaretko.models.Block;
import vkaretko.models.Cell;
import vkaretko.models.Monster;
import vkaretko.models.Player;

/**
 * Class GameField.
 *
 * @author Karetko Victor.
 * @version 1.00.
 * @since 05.02.2017.
 */
public class GameField {
    /**
     * Field with cells.
     */
    private final Cell[][] field;

    /**
     * Constructor of class GameField.
     * @param x width of board
     * @param y height of board.
     */
    public GameField(int x, int y) {
        this.field = new Cell[x][y];
        for (int i = 0; i < x; i++) {
            for (int j = 0; j < y; j++) {
                this.field[i][j] = new Cell();
            }
        }
    }

    /**
     * Method adds new monsters to the field.
     * @param x x coord.
     * @param y y coord.
     */
    public void addMonster(int x, int y) {
        synchronized (this.field) {
            this.field[x][y].setFigure(new Monster());
        }
    }

    /**
     * Method adds new blocks to the field.
     * @param x x coord.
     * @param y y coord.
     */
    public void addBlock(int x, int y) {
        synchronized (this.field) {
            this.field[x][y].setFigure(new Block());
        }
    }

    /**
     * Method adds new player to the field.
     * @param x x coord.
     * @param y y coord.
     */
    public void addPlayer(Player player, int x, int y) {
        synchronized (this.field) {
            this.field[x][y].setFigure(new Player());
        }
    }

    /**
     * Getter for game field.
     * @return field.
     */
    public Cell[][] getField() {
        return this.field;
    }

    public static void main(String[] args) {
        GameField field = new GameField(5, 5);
        Player player = new Player();
        field.addBlock(1, 4);
        field.addMonster(1, 1);
        field.addPlayer(player, 0, 0);
        player.makeStep(field.getField(), 0, 0, 0, 1);
    }
}
