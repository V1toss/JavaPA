package vkaretko;

/**
 * Часть 1. Базовый синтаксис.
 * Урок 2. Создать программу калькулятор.
 *
 * @author Karetko Victor
 * @version 1.00
 * @since 30.20.2016
 */
public class Calculator {

    /**
     * Поле result объявлено public, т.к. по требованиям задачи сказано про 4 метода, Getter не использовал.
     */
    public double result;

    /**
     * Метод для сложение двух чисел
     * @param first первое число
     * @param second второе число
     */
    public void add(double first, double second){
        this.result = first + second;
    }

    /**
     * Метод для вычитания одного числа из другого
     * @param first число, из которого вычитают
     * @param second число, которое вычитают
     */
    public void substtruct (double first, double second) {
        this.result = first - second;
    }

    /**
     * Метод для деления одного числа на другое
     * Предупреждение: в данном версии  методе отсутствует проверка деления на 0
     * @param first число, которое будем делить
     * @param second число, делитель
     */
    public void div (double first, double second) {
        this.result = first/second;
    }

    /**
     * Метод для умножения двух чисел
     * @param first число, которое будем делить
     * @param second число, делитель
     */
    public void multiple (double first, double second) {
        this.result = first * second;
    }

}
