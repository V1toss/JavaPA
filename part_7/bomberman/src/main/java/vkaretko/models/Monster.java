package vkaretko.models;

/**
 * Class Monster.
 *
 * @author Karetko Victor.
 * @version 1.00.
 * @since 05.02.2017.
 */
public class Monster extends Figure implements Runnable{
    /**
     * Default direction.
     */
    private Direction direction = Direction.UP;

    /**
     * Constructor of class Monster.
     * @param x X coord.
     * @param y Y coord.
     * @param field gamefield.
     */
    public Monster(Cell[][] field, int x, int y) {
        super(field, x, y);
    }

    /**
     * Method run move
     */
    @Override
    public void run() {
        while (!Thread.currentThread().isInterrupted()) {
            if (!makeStep(direction)) {
                this.direction = direction.changeDir();
                System.out.println("Monster change direction: " + direction);
                try {
                    Thread.sleep(5000);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            } else {
                try {
                    Thread.sleep(500);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        }
    }
}
