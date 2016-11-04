package vkaretko.Start;

import vkaretko.Models.*;

/**
 * Initialization class
 *
 * @author Karetko Victor
 * @version 1.00
 * @since 04.11.2016
 */
public class StartUi {
    public static void main(String[] args) {
        Tracker tracker = new Tracker();
        tracker.add(new Task("first task", "first desc", 123L));
        tracker.add(new Task("second task", "second desc", 123L));
        for (Item item : tracker.getAll()) {
            System.out.println(String.format("%s %s %d", item.getName(), item.getDescription(), item.getCreate()));
        }
    }
}
