package vkaretko.start;

import vkaretko.models.Item;
import vkaretko.templates.BaseAction;

/**
 * Part 2. OOP
 * Lesson 4. Inner classes.
 * Task 1. Implement all inner classes in MenuTracker.
 *
 * @author Karetko Victor
 * @version 1.03
 * @since 18.02.2017
 */
public class MenuTracker {

    private Input input;
    private Tracker tracker;
    public UserAction[] actions = new UserAction[8];
    private int position = 0;
    public enum actionKey {ADD, SHOW, EDIT, DELETE, FIND_BY_ID, ADD_COMMENT}

    /**
     * Constructor of MenuTracker
     * @param input input stream from user
     * @param tracker tracker object
     */
    public MenuTracker(Input input, Tracker tracker) {
        this.input = input;
        this.tracker = tracker;
    }

    /**
     * Method for displaying start menu
     */
    public void show() {
        for (UserAction action : this.actions) {
            if (action != null) {
                System.out.println(action.info());
            }
        }
    }

    /**
     * Method for selecting action by key
     * @param key key of action
     */
    public void select(int key) {
        this.actions[key].execute(this.input, tracker);

    }

    /**
     * Method for filling action list
     */
    public void fillActions() {
        this.actions[position++] = this.new AddItem("Add the new Item.", actionKey.ADD.ordinal());
        this.actions[position++] = new ShowItems("Show all items.", actionKey.SHOW.ordinal());
        this.actions[position++] = this.new EditItem("Edit item.", actionKey.EDIT.ordinal());
        this.actions[position++] = this.new DeleteItem("Delete item.", actionKey.DELETE.ordinal());
        this.actions[position++] = this.new FindItemById("Find item by Id.", actionKey.FIND_BY_ID.ordinal());
        this.actions[position++] = this.new AddComment("Add comment to item.", actionKey.ADD_COMMENT.ordinal());
    }

    public void addAction(UserAction action) {
        this.actions[position++] = action;
    }

    /**
     * Inner class for executing "Add the new item" action
     */
    private class AddItem extends BaseAction {
        private AddItem(String nameAction, int keyAction) {
            super(nameAction, keyAction);
        }

        @Override
        public void execute(Input input, Tracker tracker) {
            String name = input.ask("Please enter the task's name: ");
            String desc = input.ask("Please enter the task's desk: ");
            tracker.add(new Item(name, desc, System.currentTimeMillis()));
        }
    }

    /**
     * Inner static class for executing "Show all items" action
     */
    private static class ShowItems extends BaseAction {
        private ShowItems(String nameAction, int keyAction) {
            super(nameAction, keyAction);
        }

        @Override
        public void execute(Input input, Tracker tracker) {
            for (Item item : tracker.getAll()) {
                System.out.println(String.format("%s. %s %s", item.getId(), item.getName(), item.getDescription()));
            }
        }
    }

    /**
     * Inner class for executing "Edit item" action
     */
    private class EditItem extends BaseAction {
        private EditItem(String nameAction, int keyAction) {
            super(nameAction, keyAction);
        }

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
     * Inner class for executing "Delete item" action
     */
    private class DeleteItem extends BaseAction {
        private DeleteItem(String nameAction, int keyAction) {
            super(nameAction, keyAction);
        }

        @Override
        public void execute(Input input, Tracker tracker) {
            int id = Integer.parseInt(input.ask("Please, enter the task's id: "));
            tracker.delete(id);
        }
    }

    /**
     * Inner class for executing "Find item by Id" action
     */
    private class FindItemById extends BaseAction {
        private FindItemById(String nameAction, int keyAction) {
            super(nameAction, keyAction);
        }

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
     * Inner class for executing "Add comment to item" action
     */
    private class AddComment extends BaseAction {
        private AddComment(String nameAction, int keyAction) {
            super(nameAction, keyAction);
        }

        @Override
        public void execute(Input input, Tracker tracker) {
            int id = Integer.parseInt(input.ask("Please, enter the task's id: "));
            String commentRead = input.ask("Please, enter the comment: ");
            tracker.addComment(id, commentRead);
        }
    }

}
