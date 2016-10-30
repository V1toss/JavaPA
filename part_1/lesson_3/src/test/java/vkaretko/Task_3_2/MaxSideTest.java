package vkaretko.Task_3_2;

import org.junit.Test;
import vkaretko.Task_3_1.Point;

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
        Point a = new Point(0d,0d),
              b = new Point(20d,0d),
              c = new Point(10d,10d);
        MaxSide maxSide = new MaxSide();
        assertThat(maxSide.max(a,b,c), is(20d));
    }
}
