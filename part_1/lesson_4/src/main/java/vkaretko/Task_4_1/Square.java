package vkaretko.Task_4_1;

/**
 * Часть 1. Базовый синтаксис.
 * Урок 4.1. Создать программу вычисляющую формулу квадратного уравнения
 * Класс для создания объекта типа "Square".
 *
 * @author Karetko Victor
 * @version 1.00
 * @since 31.10.2016
 */
public class Square {

    private float a, b, c;

    /**
     * Конструктор класса Square
     *
     * @param a значение a в формуле квадратного уравнения
     * @param b значение b в формуле квадратного уравнения
     * @param c значение c в формуле квадратного уравнения
     */
    public Square (float a, float b, float c) {
        this.a = a;
        this.b = b;
        this.c = c;
    }

    /**
     * Метод для подсчёта квадратного уравнения
     *
     * @param x значение x в формуле квадратного уравнения
     * @return результат вычисления по формуле квадратного уравнения
     */
    public float calculate (int x) {
        return (float) ((this.a*Math.pow(x,2)) + (this.b * x) + this.c);
    }

    /**
     * Метод для задания диапазон параметров "x" для выполнения расчётов
     * по формуле квадратного уравнения и вывода результатов на консоль
     *
     * @param start начальное значение "x"
     * @param finish конечное значение "x"
     * @param step шаг увеличениz значения "x" в диапазоне от start до finish
     */
    public void show (int start, int finish, int step) {
        for (int i = start; i <= finish; i+= step) {
            System.out.println(calculate(i));
        }
    }
}
