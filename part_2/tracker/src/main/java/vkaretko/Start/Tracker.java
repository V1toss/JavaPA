package vkaretko.start;

import vkaretko.models.*;

import java.util.Random;

/**
 * Part 2. OOP
 * Lesson 2. Encapsulation.
 * Task 1. Implement a class Tracker.
 * This class is used as a repository for items.
 * It must have methods: add, edit, delete, get all items, addComments.
 *
 * @author Karetko Victor
 * @version 1.01
 * @since 05.11.2016
 */
public class Tracker {

    private Item[] items = new Item[10];
    private int countItems = 0;
    private static final Random RN = new Random();

    /**
     * Method for adding item to array of items
     * @param item item for adding
     */
    public void add (Item item) {
        item.setId(this.generateId());
        for (int index = 0; index < this.items.length; index ++) {
            if (this.items[index] == null) {
                this.items[index] = item;
                this.countItems++;
                break;
            }
        }
    }
    /**
     * Method for editing item
     * @param item item for edit
     */
    public void edit (Item item) {
        for (int index = 0; index < this.items.length; index++) {
            if ((this.items[index] != null) && (this.items[index].getId().equals(item.getId()))) {
                this.items[index] = item;
                break;
            }
        }
    }

    /**
     * Method for deleting item
     * @param id id of item for deleting
     */
    public void delete (String id) {
        for (int index = 0; index < this.items.length; index++) {
            if ((this.items[index] != null) && (this.items[index].getId().equals(id))) {
                this.items[index] = null;
                this.countItems--;
                break;
            }
        }
    }

    /**
     * Method for finding item by Id key
     * @param id id key for searching
     * @return founded item
     */
    public Item findById(String id) {
        Item result = null;
        for (Item item : this.items) {
            if ((item != null) && (item.getId().equals(id))) {
                result = item;
                break;
            }
        }
        return result;
    }

    /**
     * Method for finding item by name
     * @param name name for searching
     * @return founded item
     */
    public Item findByName(String name) {
        Item result = null;
        for (Item item : this.items) {
            if ((item != null) && (item.getName().equals(name))) {
                result = item;
                break;
            }
        }
        return result;
    }

    /**
     * Method for generating Id key
     * @return generated id key
     */
    private String generateId() {
        return String.valueOf(System.currentTimeMillis() + RN.nextInt());
    }

    /**
     * Method for get all items
     * @return array of items
     */
    public Item[] getAll() {
        Item[] result = new Item[countItems];
        int count = 0;
        for (int index = 0; index < this.items.length; index++) {
            if ((this.items[index] != null)) {
                result[count++] = items[index];
            }
        }
        return result;
    }

    /**
     * Method for adding comment to item
     * @param id id of item for adding comment
     * @param comment new comment for item
     */
    public void addComment (String id, Comment comment) {
        for (int index = 0; index < this.items.length; index++) {
            if ((this.items[index] != null) && (this.items[index].getId().equals(id))) {
                this.items[index].addComment(comment);
                break;
            }
        }
    }

    public void exit () {
       System.exit(0);
    }

}
