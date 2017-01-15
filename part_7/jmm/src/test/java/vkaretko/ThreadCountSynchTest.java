package vkaretko;

import org.junit.Test;

import static org.hamcrest.core.Is.is;
import static org.junit.Assert.*;

/**
 * Class
 *
 * @author Karetko Victor.
 * @version 1.00.
 * @since 15.01.2017.
 */
public class ThreadCountSynchTest {
    /**
     * Test for race condition.
     */
    @Test
    public void whenStartRaceConditionThenResultNotEqualsExpected() {
        ThreadCountSynch threadCount = new ThreadCountSynch();
        threadCount.run(1);
        final int expectedNumber = 100000000;
        assertThat(threadCount.getCount(), is(expectedNumber));
    }

}