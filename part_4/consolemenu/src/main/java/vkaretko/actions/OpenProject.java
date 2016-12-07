package vkaretko.actions;

import vkaretko.interfaces.Action;

/**
 * Class OpenProject to open Project.
 *
 * @author Karetko Victor
 * @version 1.00
 * @since 07.12.2016
 */
public class OpenProject extends Action {
    @Override
    public void execute() {
        System.out.println("OpenProject");
    }

    @Override
    public String getKey() {
        return "opr";
    }
}
