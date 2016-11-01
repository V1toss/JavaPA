package vkaretko.Task_3_2;

import org.junit.Test;

import static org.hamcrest.core.Is.is;
import static org.junit.Assert.assertThat;

/**
 * Тест-класс для класса MaxSide
 *
 * @author Karetko Victor
 * @version 1.00
 * @since 30.10.2016
 */
public class MaxSideTest {
    @Test
    public void whenAddThreePointsLengthOfMaxSideIsTwenty() {
        MaxSide maxSide = new MaxSide();
        assertThat(maxSide.max(10d,20d,15d), is(20d));
    }
}
