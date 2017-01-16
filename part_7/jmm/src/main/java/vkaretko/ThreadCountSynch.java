package vkaretko;

/**
 * Class ThreadCount.
 *
 * @author Karetko Victor.
 * @version 1.00.
 * @since 15.01.2017.
 */
public class ThreadCountSynch {

    /**
     * Field to increment.
     */
    private int count = 0;

    /**
     * Method that increment count.
     */
    private synchronized void incrementCount(int value) {
        this.count += value;
    }

    /**
     * Getter for count.
     * @return count.
     */
    public synchronized int getCount() {
        return count;
    }

    /**
     * Method that starts two threads.
     */
    public void run(int value) {
        Thread threadOne = createThread(value);
        Thread threadTwo = createThread(value);
        threadOne.start();
        threadTwo.start();
        try {
            threadOne.join();
            threadTwo.join();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        System.out.println(getCount());
    }

    /**
     * Method that create thread.
     * @return new thread.
     */
    private Thread createThread(int value) {
        return new Thread() {
            @Override
            public void run() {
                for (int i = 0; i < 50000000; i++) {
                    incrementCount(value);
                }
            }
        };
    }

}
