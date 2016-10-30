package vkaretko.Task_3_1;

import org.junit.Test;

import static org.hamcrest.core.Is.is;
import static org.junit.Assert.assertThat;

/**
 * Тест-класс для класса Point
 *
 * @author Karetko Victor
 * @version 1.00
 * @since 30.20.2016
 */
public class PointTest {
    @Test
    public void whenCalculateDistanceBetweenTwoPointsResultTen() {
        Point a = new Point(0d,5d),
              b = new Point(10d,5d);
        assertThat(a.distanceTo(b), is(10d));
    }

}
