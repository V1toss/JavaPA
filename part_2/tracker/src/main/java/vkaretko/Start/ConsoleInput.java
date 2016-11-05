package vkaretko.Start;

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
public class ConsoleInput implements Input{
    private Scanner scanner = new Scanner(System.in);

    @Override
    public String ask(String question) {
        System.out.print(question);
        return scanner.nextLine();
    }
}
