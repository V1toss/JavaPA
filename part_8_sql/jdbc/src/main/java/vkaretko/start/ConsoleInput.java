package vkaretko.start;

import java.util.Scanner;

/**
 *
 *
 * @author Karetko Victor
 * @version 1.00
 * @since 18.02.2017
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
