package vkaretko.models;

/**
 * Class Monster.
 *
 * @author Karetko Victor.
 * @version 1.00.
 * @since 05.02.2017.
 */
public class Monster extends Figure implements Runnable{

    @Override
    public void run() {
        while (!Thread.currentThread().isInterrupted()) {
            try {
                Thread.sleep(1000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            move();
        }
    }

    public void move() {
        //if (makeStep())
    }

}
