package vkaretko.Task_3_1;

import org.junit.Test;

import static org.hamcrest.core.Is.is;
import static org.junit.Assert.assertThat;

/**
 * Тест-класс для класс Triangle
 *
 * @author Karetko Victor
 * @version 1.00
 * @since 30.20.2016
 */

public class TriangleTest {
    @Test
    public void whenAddThreeCorrectPointsResultFifty() {
        Point a = new Point(0d,0d),
              b = new Point(10d,0d),
              c = new Point(0d,10d);
        Triangle tri = new Triangle(a,b,c);
        assertThat(tri.area(), is(50d));
    }

    @Test
    public void whenAddThreePointsAndOneSideMoreThenTwoOthersResultZero() {
        Point a = new Point(0d,0d),
              b = new Point(30d,0d),
              c = new Point(60d,0d);
        Triangle tri = new Triangle(a,b,c);
        assertThat(tri.area(), is(0d));
    }
}
