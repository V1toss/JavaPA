package vkaretko;

import org.junit.Test;

import static org.hamcrest.core.Is.is;
import static org.junit.Assert.*;

/**
 * Тест-класс для программы Calculator
 *
 * @author Karetko Victor
 * @version 1.00
 * @since 30.20.2016
 */

public class CalculatorTest {
    @Test
    public void whenAddFirstToSecondThenResultTwo() {
        Calculator calc = new Calculator();
        calc.add(1d, 1d);
        assertThat(calc.result, is(2d));
    }

    @Test
    public void whenSubstractSecondFromFirstThenResultOne() {
        Calculator calc = new Calculator();
        calc.substtruct(2d, 1d);
        assertThat(calc.result, is(1d));
    }

    @Test
    public void whenDivisionFirstOnSecondThenResultTwo() {
        Calculator calc = new Calculator();
        calc.div(6d, 3d);
        assertThat(calc.result, is(2d));
    }

    @Test
    public void whenMultipleFirstAndSecondThenResultSix() {
        Calculator calc = new Calculator();
        calc.multiple(3d, 2d);
        assertThat(calc.result, is(6d));
    }

}
