package vkaretko.actions;

import vkaretko.interfaces.Action;

/**
 * Class Open to open File or Project.
 *
 * @author Karetko Victor
 * @version 1.00
 * @since 07.12.2016
 */
public class Open extends Action {
    /**
     * Overrided method of execute.
     * Executes current action.
     */
    @Override
    public void execute() {
        System.out.println("File Open");
    }

    /**
     * Overrided method of getKey.
     * @return key of action.
     */
    @Override
    public String getKey() {
        return "open";
    }
}
