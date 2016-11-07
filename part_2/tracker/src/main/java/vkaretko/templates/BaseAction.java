package vkaretko.templates;

import vkaretko.start.*;

/**
 * Part 2. OOP
 * Lesson 6. Abstract classes.
 * Task 1. Implement BaseAction class and extend all action classes from that abstract class
 *
 * @author Karetko Victor
 * @version 1.00
 * @since 07.11.2016
 */
public abstract class BaseAction implements UserAction {

    private String nameAction;
    private int keyAction;

    /**
     * Constructor of BaseAction
     * @param nameAction name of action to show in menu
     * @param keyAction key of action
     */
    public BaseAction(String nameAction, int keyAction) {
        this.nameAction = nameAction;
        this.keyAction = keyAction;
    }

    /**
     * Abstract method of executing actions, that need to implement
     */
    public abstract void execute(Input input, Tracker tracker);

    /**
     * Method for getting info for items in menu
     * @return formatted string of item menu
     */
    public String info() {
        return String.format("%s. %s", this.keyAction, this.nameAction);
    }
}
