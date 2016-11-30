package vkaretko;

import java.util.ArrayList;

/**
 * Class ActionManager for managing Calculator operations.
 *
 * @author Karetko Victor
 * @version 1.00
 * @since 30.11.2016
 */
public class ActionManager {
    /**
     * ArrayList of actions.
     */
    private ArrayList<Action> actions = new ArrayList<>();

    /**
     * Constructor of ActionManager.
     * fillActions while creating.
     */
    public ActionManager() {
        fillActions();
    }

    /**
     * Select action from list.
     * @param keyAction key of Action.
     * @return selected action.
     */
    public Action select(int keyAction) {
        return this.actions.get(keyAction);
    }

    /**
     * Getter method to return size of action list.
     * @return size of action list.
     */
    public int getActionsLength() {
        return this.actions.size();
    }

    /**
     * Method fills list of actions.
     */
    private void fillActions() {
        int actionKey = 1;
        this.actions.add(new AddAction("Add '+'", actionKey++));
        this.actions.add(new SubtractAction("Subtract '-'", actionKey++));
        this.actions.add(new MultipleAction("Multiple '*'", actionKey++));
        this.actions.add(new DivisionAction("Division '/'", actionKey));
    }

    /**
     * Method for displaying menu to User.
     */
    public void showMenu() {
        System.out.println("Calculator menu");
        System.out.println("0. Exit");
        for (Action action : this.actions) {
            System.out.println(String.format("%s. %s", action.getKeyAction(), action.getNameAction()));
        }
    }

    /**
     * Private inner class for action add.
     */
    private class AddAction extends Action {
        /**
         * Constructor of AddAction class.
         * @param nameAction name of action.
         * @param keyAction key of action.
         */
        private AddAction(String nameAction, int keyAction) {
            super(nameAction, keyAction);
        }
        @Override
        public void execute(Calculator calc, double numberOne, double numberTwo) {
            calc.add(numberOne, numberTwo);
        }
    }

    /**
     * Private inner class for action subtract.
     */
    private class SubtractAction extends Action {
        /**
         * Constructor of SubtractAction class.
         * @param nameAction name of action.
         * @param keyAction key of action.
         */
        private SubtractAction(String nameAction, int keyAction) {
            super(nameAction, keyAction);
        }
        @Override
        public void execute(Calculator calc, double numberOne, double numberTwo) {
            calc.substtruct(numberOne, numberTwo);
        }
    }

    /**
     * Private inner class for action multiply.
     */
    private class MultipleAction extends Action {
        /**
         * Constructor of MultipleAction class.
         * @param nameAction name of action.
         * @param keyAction key of action.
         */
        private MultipleAction(String nameAction, int keyAction) {
            super(nameAction, keyAction);
        }
        @Override
        public void execute(Calculator calc, double numberOne, double numberTwo) {
            calc.multiple(numberOne, numberTwo);
        }
    }

    /**
     * Private inner class for action division.
     */
    private class DivisionAction extends Action {
        /**
         * Constructor of DivisionAction class.
         * @param nameAction name of action.
         * @param keyAction key of action.
         */
        private DivisionAction(String nameAction, int keyAction) {
            super(nameAction, keyAction);
        }
        @Override
        public void execute(Calculator calc, double numberOne, double numberTwo) {
            calc.div(numberOne, numberTwo);
        }
    }
}
