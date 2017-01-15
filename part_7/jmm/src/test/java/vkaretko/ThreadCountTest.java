package vkaretko;

import org.junit.Test;

import static org.junit.Assert.assertNotEquals;

/**
 * Class ThreadCountTest.
 *
 * @author Karetko Victor.
 * @version 1.00.
 * @since 15.01.2017.
 */
public class ThreadCountTest {

    /**
     * Test for race condition.
     */
    @Test
    public void whenStartRaceConditionThenResultNotEqualsExpected() {
        ThreadCount threadCount = new ThreadCount();
        threadCount.runRaceConditions();
        final int expectedNumber = 100000000;
        assertNotEquals(threadCount.getCount(), expectedNumber);
    }
}