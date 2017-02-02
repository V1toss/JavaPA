package vkaretko;

/**
 * Class Simplelock - simple lock implementation.
 *
 * @author Karetko Victor.
 * @version 1.00.
 * @since 02.02.2017.
 */
public class SimpleLock {
    /**
     * Flag locked or not.
     */
    private boolean isLocked = false;

    /**
     * Method locks object.
     */
    public synchronized void lock() {
        while (isLocked) {
            try {
                wait();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
        isLocked = true;
    }

    /**
     * Method unlock object.
     */
    public synchronized void unlock() {
        isLocked = false;
        notify();
    }
}
