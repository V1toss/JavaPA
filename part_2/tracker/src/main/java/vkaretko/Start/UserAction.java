package vkaretko.start;

/**
 * Interface for User Actions
 *
 * @author Karetko Victor
 * @version 1.00
 * @since 05.11.2016
 */
public interface UserAction {

    /**
     * Abstract method for executing actions
     *
     * @param input input stream from user
     * @param tracker tracker object
     */
    void execute(Input input, Tracker tracker);

    /**
     * Abstract method for print information about action in menu
     * @return name of menu line
     */
    String info();
}
