package vkaretko;

import java.util.Queue;
import java.util.concurrent.LinkedBlockingQueue;

/**
 * Class ProducerCustomer.
 *
 * @author Karetko Victor.
 * @version 1.00.
 * @since 29.01.2017.
 */
public class ProducerCustomer {

    /**
     * Production queue.
     */
    private final Queue<Integer> queue;

    /**
     * Max queue size.
     */
    private final int maxQueueSize;

    /**
     * Maximum products.
     */
    private final int maxProducts;

    /**
     * isFinish if production finished.
     */
    private boolean isFinish = false;

    /**
     * Getter for isFinish.
     * @return true if finished.
     */
    private synchronized boolean isFinish() {
        return this.isFinish;
    }

    /**
     * Setter for isFinish.
     * @param finish finish.
     */
    private synchronized void setFinish(boolean finish) {
        this.isFinish = finish;
    }

    /**
     * Constructor of ProducerCustomer class.
     * @param maxQueueSize max queue size.
     * @param maxProducts max products to produce.
     */
    public ProducerCustomer(int maxQueueSize, int maxProducts) {
        this.maxProducts = maxProducts;
        this.maxQueueSize = maxQueueSize;
        this.queue = new LinkedBlockingQueue<>();
    }

    /**
     * Thread for Customer.
     * @return new customer thread.
     */
    public Thread customerThread() {
        return new Thread(() -> {
            while (!isFinish()) {
                consume();
            }
        });
    }

    /**
     * Method for getting products from queue.
     */
    private void consume() {
        synchronized (queue) {
            while (queue.size() == 0) {
                System.out.println("Queue is empty");
                try {
                    queue.wait();
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
            System.out.println(String.format("Customer get : %s", queue.poll()));
            queue.notify();
        }
    }

    /**
     * Thread for producer.
     * @return new producer thread.
     */
    public Thread producerThread() {
        return new Thread(() -> {
            for (int product = 0; product < maxProducts; product++) {
                produce(product);
            }
            setFinish(true);
        });
    }

    /**
     * Method produce products.
     * @param product product to produce
     */
   private void produce(int product) {
        synchronized (queue) {
            while (queue.size() == maxQueueSize) {
                System.out.println("Queue is full");
                try {
                    queue.wait();
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
            queue.add(product);
            System.out.println(String.format("Producer put: %s", product));
            queue.notify();
        }
    }
}
