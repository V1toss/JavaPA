package vkaretko;

/**
 * Class ThreadCount.
 *
 * @author Karetko Victor.
 * @version 1.00.
 * @since 15.01.2017.
 */
public class ThreadCount {

    /**
     * Field to increment.
     */
    private int count = 0;

    /**
     * Method that increment count.
     */
    private void incrementCount() {
        this.count++;
    }

    /**
     * Getter for count.
     * @return count.
     */
    public int getCount() {
        return count;
    }

    /**
     * Method that starts two threads.
     */
    public void runRaceConditions() {
        Thread threadOne = createThread();
        Thread threadTwo = createThread();
        threadOne.start();
        threadTwo.start();
        try {
            threadOne.join();
            threadTwo.join();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        System.out.println(count);
    }

    /**
     * Method that create thread.
     * @return new thread.
     */
    private Thread createThread() {
        return new Thread() {
            @Override
            public void run() {
                for (int i = 0; i < 50000000; i++) {
                    incrementCount();
                }
            }
        };
    }

}
