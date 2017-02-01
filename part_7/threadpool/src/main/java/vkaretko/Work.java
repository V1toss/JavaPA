package vkaretko;

/**
 * Class Work for creating work objects, that we can add to queue in ThreadPool.
 *
 * @author Karetko Victor.
 * @version 1.00.
 * @since 01.02.2017.
 */
public class Work implements Runnable {

    /**
     * Number of work.
     */
    private int index;

    /**
     * Constructor of work.
     * @param index index of work.
     */
    public Work(int index) {
        this.index = index;
    }

    /**
     * Method prints information about work and current thread.
     */
    public void run() {
        System.out.println(String.format("%s work %s", Thread.currentThread().getName(), index));
    }
}
