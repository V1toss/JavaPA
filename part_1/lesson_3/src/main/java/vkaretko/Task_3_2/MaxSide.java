package vkaretko.Task_3_2;

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
     * Метод для определения самой длинной стороны
     * @param sideLengths список всех длин сторон
     * @return самая длинная сторона
     */
   public double max (double... sideLengths) {      
       double maxLength = 0;
       for (double length : sideLengths) {
	    if (length > maxLength) {
	   	maxLength = length;
	    }
       }
       return maxLength;
   }
}
