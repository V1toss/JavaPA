package vkaretko;

import java.util.ArrayDeque;
import java.util.Queue;

/**
 * Class ThreadPool. Simple implementation of Thread Pool.
 *
 * @author Karetko Victor.
 * @version 1.00.
 * @since 31.01.2017.
 */
public class ThreadPool {

    /**
     * Amount of processors.
     */
    private final int processors = Runtime.getRuntime().availableProcessors();
    /**
     * Queue of works.
     */
    private final Queue<Runnable> queue;
    /**
     * Array of Worker threads.
     */
    private final Worker[] threads;

    /**
     * Constructor of ThreadPool class.
     * Fill array with threads and start them.
     */
    public ThreadPool() {
        this.queue = new ArrayDeque<>();
        this.threads = new Worker[processors];

        for (int index = 0; index < processors; index++) {
            threads[index] = new Worker();
            threads[index].start();
        }
    }

    /**
     * Method adds work to queue.
     * @param work work to do.
     */
    public void add(Work work) {
        synchronized (queue) {
            queue.add(work);
            queue.notify();
        }
    }

    /**
     * Method shutdown pool when queue is empty for some time.
     */
    public void shutdown() {
        while (!queue.isEmpty()) {
            try {
                Thread.sleep(1000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
        for (Thread worker : threads) {
           worker.interrupt();
        }
    }

    /**
     * Class Worker for creating threads.
     */
    private class Worker extends Thread {
        /**
         * Method takes and runs works from queue until queue has elements and thread is not interrupted.
         */
        @Override
        public void run() {
            Runnable work;
            while (!isInterrupted()) {
                synchronized (queue) {
                    while (queue.isEmpty()) {
                        try {
                            System.out.println(String.format("%s waiting for work", Thread.currentThread().getName()));
                            queue.wait();
                        } catch (InterruptedException ie) {
                            System.out.println(String.format("%s interrupted", Thread.currentThread().getName()));
                            return;
                        }
                    }
                    work = queue.poll();
                }
                try {
                    work.run();
                } catch (RuntimeException e) {
                    e.printStackTrace();
                }
            }
        }
    }
}
