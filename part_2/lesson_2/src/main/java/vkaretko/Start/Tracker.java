package vkaretko.Start;

import vkaretko.Models.*;

import java.util.Random;

/**
 * Part 2. OOP
 * Lesson 2. Encapsulation.
 * Task 1. Implement a class Tracker.
 * This class is used as a repository for items.
 * It must have methods: add, edit, delete, get all items, addComments.
 *
 * @author Karetko Victor
 * @version 1.00
 * @since 04.11.2016
 */
public class Tracker {

    private Item[] items = new Item[10];
    private int position = 0;
    private static final Random RN = new Random();

    /**
     * Method for adding item to array of items
     * @param item item for adding
     */
    public void add (Item item) {
        item.setId(this.generateId());
        this.items[position++] = item;
    }

    /**
     * Method for editing item
     * @param item item for edit
     */
    public void edit (Item item, Item editedItem) {
        for (int index = 0; index < this.position; index++) {
            if (this.items[index].getId().equals(item.getId())) {
                this.items[index] = editedItem;
                break;
            }
        }
    }

    /**
     * Method for deleting item
     * @param item item for deleting
     */
    public void delete (Item item) {
        for (int index = 0; index < this.position; index++) {
            if (this.items[index].getId().equals(item.getId())) {
                this.items[index] = null;
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
        for (Item item : items) {
            if (item != null && item.getId().equals(id)) {
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
        for (Item item : items) {
            if (item != null && item.getName().equals(name)) {
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
        Item[] result = new Item[this.position];
        for (int index = 0; index != this.position; index++) {
            result[index] = items[index];
        }
        return result;
    }

    /**
     * Method for adding comment to item
     * @param item item for adding comment
     * @param comment new comment for item
     */
    public void addComment (Item item, Comment comment) {
        for (int index = 0; index < this.position; index++) {
            if (this.items[index].getId().equals(item.getId())) {
                this.items[index].addComment(comment);
                break;
            }
        }
    }

}
