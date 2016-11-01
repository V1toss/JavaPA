package vkaretko.Task_3_2;

import vkaretko.Task_3_1.Point;

/**
 * Часть 1. Базовый синтаксис.
 * Урок 3.2. Создать метод вычисления максимально числа.
 * Класс для вычисления самой длинной стороны треугольника.
 *
 * @author Karetko Victor
 * @version 1.00
 * @since 30.10.2016
 */
public class MaxSide {
    /**
     * Метод для определения самой длинной стороны треугольник
     * @param a точка a
     * @param b точка b
     * @param c точка c
     * @return самая длинная сторона
     */
   public double max (Point a, Point b, Point c) {
       double sideAB = a.distanceTo(b);
       double sideBC = b.distanceTo(c);
       double sideAC = a.distanceTo(c);

       return (sideAB > sideBC && sideAB > sideAC) ? sideAB : (sideBC > sideAC) ? sideBC : sideAC;

   }
}
