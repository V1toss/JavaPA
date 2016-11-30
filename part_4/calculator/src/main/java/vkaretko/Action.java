package vkaretko;

/**
 * Abstract class Action.
 * This abstract class helps to wrap old Calculator methods for better flexibility.
 *
 * @author Karetko Victor
 * @version 1.00
 * @since 30.11.2016
 */
public abstract class Action {
    /**
     * Name of action.
     */
    private String nameAction;
    /**
     * Key of action.
     */
    private int keyAction;

    /**
     * Constructor of Action.
     * @param nameAction name of action.
     * @param keyAction key of action.
     */
    public Action(String nameAction, int keyAction) {
        this.nameAction = nameAction;
        this.keyAction = keyAction;
    }

    /**
     * Abstract method of executing actions, that need to implement.
     * @param calc Calculator.
     * @param numberOne first number.
     * @param numberTwo second number.
     */
    public abstract void execute(Calculator calc, double numberOne, double numberTwo);

    /**
     * Getter-method for name of action.
     * @return name of action.
     */
    public String getNameAction() {
        return this.nameAction;
    }

    /**
     * Getter-method for key of action.
     * @return key of action.
     */
    public int getKeyAction() {
        return this.keyAction;
    }
}
