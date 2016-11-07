package vkaretko.start;

import java.util.Scanner;

/**
 * Part 2. OOP
 * Lesson 3. Polymorphism.
 * Task 1. Implement class ConsoleInput, that will be used by class StartUI.
 * User can exit the application and perform all the actions described in the first task.
 *
 * @author Karetko Victor
 * @version 1.00
 * @since 05.11.2016
 */
public class ConsoleInput implements Input {
    private Scanner scanner = new Scanner(System.in);

    /**
     * Method for asking questions to users
     *
     * @param question question to print in console
     * @return user answer in String format
     */
    @Override
    public String ask(String question) {
        System.out.print(question);
        return scanner.nextLine();
    }

    /**
     * Method for asking questions to users
     *
     * @param question question to print in console
     * @param range range of actions
     * @return user answer
     */
    @Override
    public int ask(String question, int[] range) {
        int key = Integer.valueOf(this.ask(question));
        boolean exist = false;
        for (int value : range) {
            if (value == key) {
                exist = true;
                break;
            }
        }
        if (exist) {
            return key;
        } else {
            throw new MenuOutException("Out of menu range");
        }
    }
}
