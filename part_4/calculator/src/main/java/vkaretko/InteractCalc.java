package vkaretko;

import java.util.Scanner;

/**
 * Class InteractCalc for creating dialog with user.
 *
 * @author Karetko Victor
 * @version 1.00
 * @since 30.11.2016
 */
public class InteractCalc {
    /**
     * Scanner for getting input from User.
     */
    private Scanner sc = new Scanner(System.in);
    /**
     * Flag for exiting program.
     */
    private boolean isExit = false;

    /**
     * Method for create dialog with user.
     */
    public void initDialog() {
        Calculator calc = new Calculator();
        ActionManager manager = new ActionManager();
        while (!isExit) {
            manager.showMenu();
            int userAction = askUserAction(manager.getActionsLength());
            isExit = userAction == 0;
            if (!isExit) {
                Action action = manager.select(userAction - 1);
                double numberOne = askUserNumber("first");
                double numberTwo = askUserNumber("second");
                action.execute(calc, numberOne, numberTwo);
                printResult(calc, action);
                while (sc.hasNextLine() && sc.nextLine().equals("y")) {
                    action.execute(calc, calc.getResult(), numberTwo);
                    printResult(calc, action);
                }
            }
        }
    }

    /**
     * Method for asking User action from menu.
     * @param maxActions to check range of actions.
     * @return number of selected action/
     */
    private int askUserAction(int maxActions) {
        System.out.println("Select action (0-4): ");
        int result = 0;
        while (sc.hasNextLine()) {
            String line = sc.nextLine();
            if (isPositiveInt(line) && Integer.valueOf(line) <= maxActions) {
                result = Integer.valueOf(line);
                break;
            } else {
                System.out.println("Wrong action, plz repeat:");
            }
        }
        return result;
    }

    /**
     * Method for asking numbers from User for calculate.
     * @param number first or second number.
     * @return number from input.
     */
    private double askUserNumber(String number) {
        System.out.println(String.format("Enter %s number: ", number));
        double result = 0;
        while (sc.hasNextLine()) {
            String line = sc.nextLine();
            if (isDouble(line)) {
                result = Double.valueOf(line);
                break;
            } else {
                System.out.println("Wrong number, plz repeat:");
            }
        }
        return result;
    }

    /**
     * Method checks that string line is double number.
     * @param str line from input.
     * @return true if it double, false otherwise
     */
    private boolean isDouble(String str) {
        return str.matches("[+-]?\\d*\\.?\\d+");
    }

    /**
     * Method checks that string line is positive int number.
     * @param str line from input.
     * @return true if it positive int number, false otherwise.
     */
    private boolean isPositiveInt(String str) {
        return str.matches("\\d+");
    }

    /**
     * Method to print result.
     * @param calc calculator for get result
     * @param action action for get name of action
     */
    private void printResult(Calculator calc, Action action) {
        System.out.println(String.format("Result of %s operation is %s",
                action.getNameAction().toLowerCase(), calc.getResult()));
        System.out.println("Repeat last operation? y/n");
    }
}
