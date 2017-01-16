package vkaretko;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

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
        final ExecutorService executor = Executors.newFixedThreadPool(2);
        executor.submit(wordCountThread(text));
        executor.submit(spaceCountThread(text));
        if (pause && !executor.awaitTermination(1, TimeUnit.SECONDS)) {
            executor.shutdownNow();
        }
        System.out.println("Finish");
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
                int count = 0;
                Pattern p = Pattern.compile("[a-zA-Zа-яА-Я]+");
                Matcher m = p.matcher(text);
                while(!isInterrupted() && m.find()) {
                    count++;
                }
                if (isInterrupted()) {
                    System.out.println("Thread Interrupted");
                }
                System.out.println(String.format("Words: %s", count));
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
                 int count = 0;
                 int index = 0;
                 while (!isInterrupted() && index < text.length()) {
                     if (text.charAt(index) == ' ') {
                         count++;
                     }
                     index++;
                 }
                 if (isInterrupted()) {
                     System.out.println("Thread Interrupted");
                 }
                 System.out.println(String.format("Spaces: %s", count));
             }
         };
    }
}
