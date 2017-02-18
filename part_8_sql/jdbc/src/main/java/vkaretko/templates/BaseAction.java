package vkaretko.templates;

import vkaretko.start.Input;
import vkaretko.start.Tracker;
import vkaretko.start.UserAction;

/**
 * BaseAction is base class for all actions.
 *
 * @author Karetko Victor
 * @version 1.00
 * @since 18.02.2017
 */
public abstract class BaseAction implements UserAction {

    /**
     * Name of action.
     */
    private String nameAction;
    /**
     * Key of action.
     */
    private int keyAction;

    /**
     * Constructor of BaseAction.
     * @param nameAction name of action to show in menu.
     * @param keyAction key of action.
     */
    public BaseAction(String nameAction, int keyAction) {
        this.nameAction = nameAction;
        this.keyAction = keyAction;
    }

    /**
     * Abstract method for executing actions.
     * @param input input stream from user.
     * @param tracker tracker object.
     */
    public abstract void execute(Input input, Tracker tracker);

    /**
     * Method for getting info for items in menu.
     * @return formatted string of item menu.
     */
    public String info() {
        return String.format("%s. %s", this.keyAction, this.nameAction);
    }
}
