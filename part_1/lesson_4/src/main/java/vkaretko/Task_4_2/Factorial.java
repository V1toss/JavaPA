package vkaretko.Task_4_2;

/**
 * Часть 1. Базовый синтаксис.
 * Урок 4.2. Создать программу вычисляющую факториал
 *
 * @author Karetko Victor
 * @version 1.00
 * @since 31.10.2016
 */
public class Factorial {
    private int n;
    /**
     * Конструктор класса Factorial
     *
     * @param n значение, для которого будет считаться факториал
     */
    public Factorial (int n) {
        this.n = n;
    }

    /**
     * Метод для вычисления факториала для значения n
     * Факториал - произведение всех натуральных чисел от 1 до n включительно.
     * @return результат вычисления факториала
     */
    public long calculate() {
        long result = 1;

        if (this.n >= 0) {
            for (int i = 1; i <= this.n; i++) {
                result *= i;
            }
        }
        else {
            System.out.println("Non positive number");
            result = 0;
        }
        return result;
    }
}
