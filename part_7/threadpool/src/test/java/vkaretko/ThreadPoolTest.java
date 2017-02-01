package vkaretko;

import org.junit.Test;

/**
 * Class ThreadPoolTest for testing ThreadPool.
 *
 * @author Karetko Victor.
 * @version 1.00.
 * @since 01.02.2017.
 */
public class ThreadPoolTest {

    /**
     * Creates threadpool and adds 50 works to queue.
     */
    @Test
    public void whenStartThreadPoolAndAddWorkThenWorkerMakesWork() {
        ThreadPool threadPool = new ThreadPool();
        for (int index = 0; index < 50; index++) {
            threadPool.add(new Work(index));
        }
        threadPool.shutdown();
    }
}