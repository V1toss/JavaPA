package vkaretko.server;

import java.io.IOException;

/**
 * The Action class - server side part of the Network file manager.
 * The abstract class for creating Actions in the ActionManager class.
 *
 * @author Karetko Victor
 * @version 1.00
 * @since 20.11.2016
 */
public abstract class Action {
    /**
     * Key of action.
     */
    private String key;
    /**
     * Information about action.
     */
    private String info;

    /**
     * The constructor of the Action class.
     * @param key key of action
     * @param info information about action
     */
    Action(String key, String info) {
        this.key = key;
        this.info = info;
    }

    /**
     * Getter method for field key.
     * @return key of action
     */
    String getKey() {
        return this.key;
    }

    /**
     * Getter method for field info.
     * @return information about action
     */
    String getInfo() {
        return this.info;
    }

    /**
     * Abstract method for executing action.
     * @param parameters parameters of actionf
     * @throws IOException if execute failed
     */
    public abstract void execute(String[] parameters) throws IOException;
}
