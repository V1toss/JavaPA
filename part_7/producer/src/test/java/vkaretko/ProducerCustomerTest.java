package vkaretko;

import org.junit.Test;

/**
 * Class for testinf ProducerCustomer.
 *
 * @author Karetko Victor.
 * @version 1.00.
 * @since 30.01.2017.
 */
public class ProducerCustomerTest {

    /**
     * Main test.
     * @throws Exception excpetion
     */
    @Test
    public void whenRunTwoThreadsThenResultQueueEmptyAndFill() throws Exception {
        ProducerCustomer prodCus = new ProducerCustomer(3, 10);
        Thread threadProducer = prodCus.producerThread();
        Thread threadCustomer = prodCus.customerThread();
        threadCustomer.start();
        threadProducer.start();
        threadCustomer.join();
        threadProducer.join();
    }

}