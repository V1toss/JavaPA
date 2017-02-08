package vkaretko;

import vkaretko.models.Block;
import vkaretko.models.Cell;
import vkaretko.models.Player;
import vkaretko.models.Direction;
import vkaretko.models.Monster;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

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
     *
     */
    private final ExecutorService service;

    /**
     * Constructor of class GameField.
     * @param size of board
     */
    public GameField(int size) {
        this.service = Executors.newCachedThreadPool();
        this.field = new Cell[size][size];
        for (int i = 0; i < size; i++) {
            for (int j = 0; j < size; j++) {
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
            Monster monster = new Monster(field, x, y);
            this.field[x][y].setFigure(monster);
            service.execute(monster);
        }
    }

    /**
     * Method adds new blocks to the field.
     * @param x x coord.
     * @param y y coord.
     */
    public void addBlock(int x, int y) {
        synchronized (this.field) {
            this.field[x][y].setFigure(new Block(field, x, y));
        }
    }

    /**
     * Method adds new player to the field.
     * @param x x coord.
     * @param y y coord.
     */
    public void addPlayer(Player player, int x, int y) {
        synchronized (this.field) {
            this.field[x][y].setFigure(player);
        }
    }

    /**
     * Getter for game field.
     * @return field.
     */
    public Cell[][] getField() {
        return this.field;
    }

    /**
     * Main method - adding 2 monsters, 1 block and player.
     * @param args arguments from command line.
     */
    public static void main(String[] args) {
        GameField field = new GameField(8);
        Player player = new Player(field.getField(), 0, 0);
        field.addBlock(1, 4);
        field.addMonster(1, 1);
        field.addMonster(3, 1);
        field.addPlayer(player, 0, 0);
        player.makeStep(Direction.UP);

    }
}
