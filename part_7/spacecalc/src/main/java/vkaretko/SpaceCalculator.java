package vkaretko;

/**
 * Class SpaceCalculator.
 *
 * @author Karetko Victor.
 * @version 1.00.
 * @since 08.01.2017.
 */
public class SpaceCalculator {

    /**
     * Method for calculating spaces and words.
     * @param text text to find.
     */
    public void parse(String text, boolean pause) throws InterruptedException {
        System.out.println("White space calculator");
        Thread threadWords = wordCountThread(text);
        Thread threadSpaces = spaceCountThread(text);
        threadSpaces.start();
        threadWords.start();
        if (pause) {
            threadSpaces.join(1000);
            threadWords.join(1000);
            interruptThreads(threadSpaces, threadWords);
        }
        System.out.println("Finish");
    }

    /**
     * Method for interrupting threads.
     * @param threads threads to interrrupt.
     */
    private void interruptThreads(Thread... threads) {
        for (Thread thread : threads) {
            if (thread.isAlive()) {
                thread.interrupt();
            }
        }
    }

    /**
     * Method for calculating words in line.
     * @param text line.
     * @throws InterruptedException InterruptedException
     */
    private Thread wordCountThread(String text) throws InterruptedException {
        return new Thread() {
            @Override
            public void run() {
                System.out.println(String.format("Words: %s", text.split(" ").length));
            }
        };
    }

    /**
     * Method for calculating spaces in line.
     * @param text line.
     * @throws InterruptedException InterruptedException
     */
    private Thread spaceCountThread(String text) throws InterruptedException {
         return new Thread() {
             @Override
             public void run() {
                 System.out.println(String.format("Spaces: %s", text.replaceAll("[^ ]", "").length()));
             }
         };
    }
}
