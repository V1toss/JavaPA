package vkaretko;

/**
 * Class calculator from part_1.
 * Differences are: comments on english and getter for result field.
 *
 * @author Karetko Victor
 * @version 1.00
 * @since 30.11.2016
 */
public class Calculator {

    /**
     * Field holding result of operation.
     */
    private double result;
    /**
     * Method for adding one number to another.
     * @param first first number.
     * @param second second number.
     */
    public void add(double first, double second) {
        this.result = first + second;
    }

    /**
     * Method for subtracting second number from first.
     * @param first first number.
     * @param second second number.
     */
    public void substtruct(double first, double second) {
        this.result = first - second;
    }

    /**
     * Method for divisioning first number on second.
     * @param first first number.
     * @param second second number.
     */
    public void div(double first, double second) {
        this.result = first / second;
    }

    /**
     * Method for multiplying first number on second.
     * @param first first number.
     * @param second second number.
     */
    public void multiple(double first, double second) {
        this.result = first * second;
    }

    /**
     * Getter method for field result.
     * @return result of operation.
     */
    public double getResult() {
        return this.result;
    }
}
