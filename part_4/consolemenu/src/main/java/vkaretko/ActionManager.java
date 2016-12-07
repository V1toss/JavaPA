package vkaretko;

import vkaretko.actions.About;
import vkaretko.actions.Open;
import vkaretko.actions.OpenProject;
import vkaretko.interfaces.Action;

import java.util.ArrayList;

/**
 * Class ActionManager for filling list of actions and selecting them.
 *
 * @author Karetko Victor
 * @version 1.00
 * @since 07.12.2016
 */
public class ActionManager {
    /**
     * List of available actions.
     */
    private final ArrayList<Action> actions = new ArrayList<>();

    /**
     * Init method to fill actions.
     */
    public void init() {
        actions.add(new About());
        actions.add(new Open());
        actions.add(new OpenProject());
    }

    /**
     * Select action from actions list by key.
     * @param key key for action
     */
    public void select(String key) {
        for (Action action : actions) {
            if (action.getKey().equals(key)) {
                action.execute();
                break;
            }
        }
    }

    /**
     * Getter-method for list of available actions.
     * @return list of actions.
     */
    public ArrayList<Action> getActions() {
        return actions;
    }
}
