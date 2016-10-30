package vkaretko.Task_3_1;

/**
 * Часть 1. Базовый синтаксис.
 * Урок 3.1. Создать программу вычисления площади треугольника.
 * Класс для создания объекта "Точка".
 *
 * @author Karetko Victor
 * @version 1.00
 * @since 30.10.2016
 */

public class Point {
    public double x;
    public double y;

    /**
     * Конструктор для создания экземпляра класса
     * @param x координата точки по оси X
     * @param y координата точки по оси Y
     */
    public Point(double x, double y) {
        this.x = x;
        this.y = y;
    }

    /**
     * Метод для подсчёта расстояния между двумя точками this point и other point
     * Расстояние между двумя точками вычисляется, как корень квадратный из суммы квадратов
     * разностей координат по каждой оси.
     * @param point other point
     * @return растояние между двумя точками
     */
    public double distanceTo(Point point) {
        return Math.sqrt(Math.pow(point.x - this.x,2) + Math.pow(point.y - this.y,2));
    }
}
