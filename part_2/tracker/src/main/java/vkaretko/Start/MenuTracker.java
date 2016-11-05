package vkaretko.Start;

import vkaretko.Models.*;

/**
 * Part 2. OOP
 * Lesson 4. Inner classes.
 * Task 1. Implement all inner classes in MenuTracker.
 *
 * @author Karetko Victor
 * @version 1.02
 * @since 05.11.2016
 */
public class MenuTracker {

    private Input input;
    private Tracker tracker;
    public UserAction[] actions = new UserAction[8];

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
        this.actions[0] = this.new AddItem();
        this.actions[1] = new MenuTracker.ShowItems();
        this.actions[2] = this.new EditItem();
        this.actions[3] = this.new DeleteItem();
        this.actions[4] = this.new FindItemById();
        this.actions[5] = this.new FindItemByName();
        this.actions[6] = this.new AddComment();
        this.actions[7] = this.new ExitProgram();

    }

    /**
     * Inner class for executing "Add the new item" action
     */
    private class AddItem implements UserAction {
        @Override
        public int key() {
            return 0;
        }

        @Override
        public void execute(Input input, Tracker tracker) {
            String name = input.ask("Please enter the task's name: ");
            String desc = input.ask("Please enter the task's desk: ");
            tracker.add(new Task(name, desc, System.currentTimeMillis()));
        }

        @Override
        public String info() {
            return String.format("%s. %s", this.key(), "Add the new item.");
        }
    }

    /**
     * Inner static class for executing "Show all items" action
     */
    private static class ShowItems implements UserAction {
        @Override
        public int key() {
            return 1;
        }

        @Override
        public void execute(Input input, Tracker tracker) {
            for (Item item : tracker.getAll()) {
                System.out.println(String.format("%s. %s %s", item.getId(), item.getName(), item.getDescription()));
                if (item.getComments().length > 0) {
                    System.out.println("Comments: ");
                    for (Comment comment : item.getComments()) {
                        System.out.println(comment.getComment());
                    }
                }
            }
        }

        @Override
        public String info() {
            return String.format("%s. %s", this.key(), "Show all items.");
        }
    }

    /**
     * Inner class for executing "Edit item" action
     */
    private class EditItem implements UserAction {
        @Override
        public int key() {
            return 2;
        }

        @Override
        public void execute(Input input, Tracker tracker) {
            String id = input.ask("Please, enter the task's id: ");
            String name = input.ask("Please enter the task's name: ");
            String desc = input.ask("Please enter the task's desk: ");
            Task task = new Task(name, desc, System.currentTimeMillis());
            task.setId(id);
            tracker.edit(task);
        }

        @Override
        public String info() {
            return String.format("%s. %s", this.key(), "Edit item.");
        }
    }

    /**
     * Inner class for executing "Delete item" action
     */
    private class DeleteItem implements UserAction {
        @Override
        public int key() {
            return 3;
        }

        @Override
        public void execute(Input input, Tracker tracker) {
            String id = input.ask("Please, enter the task's id: ");
            tracker.delete(id);
        }

        @Override
        public String info() {
            return String.format("%s. %s", this.key(), "Delete item.");
        }
    }

    /**
     * Inner class for executing "Find item by Id" action
     */
    private class FindItemById implements UserAction {
        @Override
        public int key() {
            return 4;
        }

        @Override
        public void execute(Input input, Tracker tracker) {
            String id = input.ask("Please, enter the task's id: ");
            Item item = tracker.findById(id);
            System.out.println(String.format("%s. %s %s", item.getId(), item.getName(), item.getDescription()));

        }

        @Override
        public String info() {
            return String.format("%s. %s", this.key(), "Find item by Id.");
        }
    }

    /**
     * Inner class for executing "Find item by name" action
     */
    private class FindItemByName implements UserAction {
        @Override
        public int key() {
            return 5;
        }

        @Override
        public void execute(Input input, Tracker tracker) {
            String name = input.ask("Please, enter the task's name: ");
            Item item = tracker.findByName(name);
            System.out.println(String.format("%s. %s %s", item.getId(), item.getName(), item.getDescription()));

        }

        @Override
        public String info() {
            return String.format("%s. %s", this.key(), "Find item by name.");
        }
    }

    /**
     * Inner class for executing "Add comment to item" action
     */
    private class AddComment implements UserAction {
        @Override
        public int key() {
            return 6;
        }

        @Override
        public void execute(Input input, Tracker tracker) {
            String id = input.ask("Please, enter the task's id: ");
            String commentRead = input.ask("Please, enter the comment: ");
            Comment comment = new Comment(commentRead);
            tracker.addComment(id, comment);
        }

        @Override
        public String info() {
            return String.format("%s. %s", this.key(), "Add comment to item.");
        }
    }

    private class ExitProgram implements UserAction {
        @Override
        public int key() {
            return 7;
        }

        @Override
        public void execute(Input input, Tracker tracker) {
            tracker.exit();
        }

        @Override
        public String info() {
            return String.format("%s. %s", this.key(), "Exit program");
        }
    }


}
