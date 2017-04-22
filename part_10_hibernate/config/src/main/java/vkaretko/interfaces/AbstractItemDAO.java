package vkaretko.interfaces;

import vkaretko.models.Item;

import java.util.List;

/**
 * Abstract item dao interface.
 *
 * @author Karetko Victor.
 * @version 1.00.
 * @since 22.04.2017.
 */
public interface AbstractItemDAO {
    /**
     * Get all items from DB.
     * @param isDone flag for filtering by item status.
     * @return list of items.
     */
    List<Item> getAllItems(boolean isDone);

    /**
     * Delete item from db.
     * @param id of item.
     */
    void deleteItem(int id);

    /**
     * Update item status in db by id.
     * @param isDone status of item.
     * @param id id of item.
     */
    void updateStatus(int id, boolean isDone);

    /**
     * Add item in database.
     * @param desc description of item.
     */
    void addItem(String desc);
}
