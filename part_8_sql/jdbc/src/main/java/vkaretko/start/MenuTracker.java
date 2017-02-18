package vkaretko.start;

import vkaretko.models.Item;
import vkaretko.templates.BaseAction;

import java.util.ArrayList;
import java.util.List;

/**
 * Menutracker class have list of all available actions in tracker.
 *
 * @author Karetko Victor
 * @version 1.03
 * @since 18.02.2017
 */
public class MenuTracker {

    /**
     * Input for MenuTracker.
     */
    private Input input;
    /**
     * Tracker.
     */
    private Tracker tracker;
    /**
     * Available list of actions.
     */
    private List<UserAction> actions;

    /**
     * Method for getting size of actions list.
     * @return size of actions list.
     */
    public int getActionsSize() {
        return actions.size();
    }

    /**
     * Constructor of MenuTracker.
     * @param input input stream from user
     * @param tracker tracker object
     */
    public MenuTracker(Input input, Tracker tracker) {
        this.input = input;
        this.tracker = tracker;
        this.actions = new ArrayList<>();
    }

    /**
     * Method for displaying start menu.
     */
    public void show() {
        for (UserAction action : this.actions) {
            if (action != null) {
                System.out.println(action.info());
            }
        }
    }

    /**
     * Method for selecting action by key.
     * @param key key of action.
     */
    public void select(int key) {
        this.actions.get(key).execute(this.input, tracker);

    }

    /**
     * Method for filling action list.
     */
    public void fillActions() {
        this.actions.add(new AddItem("Add the new Item.", 0));
        this.actions.add(new ShowItems("Show all items.", 1));
        this.actions.add(new EditItem("Edit item.", 2));
        this.actions.add(new DeleteItem("Delete item.", 3));
        this.actions.add(new FindItemById("Find item by Id.", 4));
        this.actions.add(new AddComment("Add comment to item.", 5));
    }

    /**
     * Inner class for executing "Add the new item" action.
     */
    private class AddItem extends BaseAction {
        /**
         * Constructor of AddItem inner class.
         * @param nameAction name of action.
         * @param keyAction key of action.
         */
        private AddItem(String nameAction, int keyAction) {
            super(nameAction, keyAction);
        }

        /**
         * Method executes current action.
         * @param input input.
         * @param tracker tracker.
         */
        @Override
        public void execute(Input input, Tracker tracker) {
            String name = input.ask("Please enter the task's name: ");
            String desc = input.ask("Please enter the task's desk: ");
            tracker.add(new Item(name, desc, System.currentTimeMillis()));
        }
    }

    /**
     * Inner static class for executing "Show all items" action.
     */
    private static class ShowItems extends BaseAction {
        /**
         * Constructor of class ShowItems.
         * @param nameAction name of action.
         * @param keyAction key of action.
         */
        private ShowItems(String nameAction, int keyAction) {
            super(nameAction, keyAction);
        }

        /**
         * Method executes current action.
         * @param input input.
         * @param tracker tracker.
         */
        @Override
        public void execute(Input input, Tracker tracker) {
            for (Item item : tracker.getAll()) {
                System.out.println(String.format("%s. %s %s", item.getId(), item.getName(), item.getDescription()));
            }
        }
    }

    /**
     * Inner class for executing "Edit item" action.
     */
    private class EditItem extends BaseAction {
        /**
         * Constructor of class EditItem.
         * @param nameAction name of action.
         * @param keyAction key of action.
         */
        private EditItem(String nameAction, int keyAction) {
            super(nameAction, keyAction);
        }

        /**
         * Method executes current action.
         * @param input input.
         * @param tracker tracker.
         */
        @Override
        public void execute(Input input, Tracker tracker) {
            int id = Integer.parseInt(input.ask("Please, enter the task's id: "));
            String name = input.ask("Please enter the task's name: ");
            String desc = input.ask("Please enter the task's desk: ");
            Item item = new Item(name, desc, System.currentTimeMillis());
            item.setId(id);
            tracker.edit(item);
        }
    }

    /**
     * Inner class for executing "Delete item" action.
     */
    private class DeleteItem extends BaseAction {
        /**
         * Constructor of class DeleteItem.
         * @param nameAction name of action.
         * @param keyAction key of action.
         */
        private DeleteItem(String nameAction, int keyAction) {
            super(nameAction, keyAction);
        }

        /**
         * Method executes current action.
         * @param input input.
         * @param tracker tracker.
         */
        @Override
        public void execute(Input input, Tracker tracker) {
            int id = Integer.parseInt(input.ask("Please, enter the task's id: "));
            tracker.delete(id);
        }
    }

    /**
     * Inner class for executing "Find item by Id" action.
     */
    private class FindItemById extends BaseAction {
        /**
         * Constructor of class FindByItem.
         * @param nameAction name of action.
         * @param keyAction key of action.
         */
        private FindItemById(String nameAction, int keyAction) {
            super(nameAction, keyAction);
        }

        /**
         * Method executes current action.
         * @param input input.
         * @param tracker tracker.
         */
        @Override
        public void execute(Input input, Tracker tracker) {
            int id = Integer.parseInt(input.ask("Please, enter the task's id: "));
            Item item = tracker.findById(id);
            System.out.println(String.format("%s. %s %s", item.getId(), item.getName(), item.getDescription()));
            for (String line : tracker.getComments(id)) {
                System.out.println(line);
            }
        }
    }

    /**
     * Inner class for executing "Add comment to item" action.
     */
    private class AddComment extends BaseAction {
        /**
         * Constructor of class AddComment.
         * @param nameAction name of action.
         * @param keyAction key of action.
         */
        private AddComment(String nameAction, int keyAction) {
            super(nameAction, keyAction);
        }

        /**
         * Method executes current action.
         * @param input input.
         * @param tracker tracker.
         */
        @Override
        public void execute(Input input, Tracker tracker) {
            int id = Integer.parseInt(input.ask("Please, enter the task's id: "));
            String commentRead = input.ask("Please, enter the comment: ");
            tracker.addComment(id, commentRead);
        }
    }

}
