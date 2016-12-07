package vkaretko.actions;

import vkaretko.interfaces.Action;

/**
 * Class About to show information about developers.
 *
 * @author Karetko Victor
 * @version 1.00
 * @since 07.12.2016
 */
public class About extends Action {
    /**
     * Overrided method of execute.
     * Executes current action.
     */
    @Override
    public void execute() {
        System.out.println("HelpAbout");
    }

    /**
     * Overrided method of getKey.
     * @return key of action.
     */
    @Override
    public String getKey() {
        return "ab";
    }
}
