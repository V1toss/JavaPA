package vkaretko.Task_3_1;

/**
 * Часть 1. Базовый синтаксис.
 * Урок 3.1. Создать программу вычисления площади треугольника.
 * Класс для создания объекта "Треугольник".
 *
 * @author Karetko Victor
 * @version 1.00
 * @since 30.10.2016
 */

public class Triangle {
    public Point a;
    public Point b;
    public Point c;

    /**
     * Конструктор для создания экземпляра класса
     * @param a точка a
     * @param b точка b
     * @param c точка b
     */
    public Triangle(Point a, Point b, Point c) {
        this.a = a;
        this.b = b;
        this.c = c;
    }

    /**
     * Метод для подсчёта площади треугольника
     * Проверка существования треугольника производится условием: сумма любых двух сторон больше третьей
     * Площадь треугольника вычисляется по формуле Герона через полупериметр (halfP)
     * @return площадь треугольника
     */
    public double area() {
        double result = 0;
        double sideAB = this.a.distanceTo(b);
        double sideBC = this.b.distanceTo(c);
        double sideAC = this.a.distanceTo(c);
        double halfP = (sideAB + sideAC + sideBC)/2.0d;

        if ((sideAB < (sideBC + sideAC)) && (sideBC < (sideAC + sideAB)) && (sideAC < (sideBC + sideAC))) {
            result = Math.sqrt(halfP * (halfP - sideAB) * (halfP - sideAC) * (halfP - sideBC));
        } else {
            System.out.println("Треугольника не существует");
        }
        return result;
    }
}
