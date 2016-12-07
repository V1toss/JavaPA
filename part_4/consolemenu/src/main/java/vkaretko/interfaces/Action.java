package vkaretko.interfaces;

/**
 * Abstract class Action base class for actions in menu.
 *
 * @author Karetko Victor
 * @version 1.00
 * @since 07.12.2016
 */
public abstract class Action implements Key {
    /**
     * Abstract method for executing action.
     */
    public abstract void execute();
}
