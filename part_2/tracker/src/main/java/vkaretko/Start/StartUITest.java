package vkaretko.Start;

/**
 * Initialization class for test Tracker program
 *
 * @author Karetko Victor
 * @version 1.00
 * @since 05.11.2016
 */
public class StartUITest {
    /**
     * Initialization method for simulating user Actions:
     * 1. Add new item
     * 2. Show result
     * 3. Edit item and show result
     * 4. Add new item, delete first item and show result
     * 5. Find item by Id
     * 6. Add comment and show all
     * 7. Exit program
     * @param args arguments from command line
     */
    public static void main(String[] args) {

        Tracker tracker = new Tracker();
        Input input = new StubInput(new String[] {"0", "name", "desc", "y"});
        new StartUI(input, tracker).init();
        String id = tracker.getAll()[0].getId();

        input = new StubInput(new String[] {"1", "y"});
        new StartUI(input, tracker).init();

        input = new StubInput(new String[] {
                "2", id, "name after edit", "desc after edit", "n", "1", "y"});
        new StartUI(input, tracker).init();

        input = new StubInput(new String[] {
                "0", "second item", "description", "n", "3", id, "n", "1", "y"});
        new StartUI(input, tracker).init();
        id = tracker.getAll()[0].getId();

        input = new StubInput(new String[] {"4", id, "y"});
        new StartUI(input, tracker).init();

        input = new StubInput(new String[] {"6", id, "test comment", "n", "1", "y"});
        new StartUI(input, tracker).init();

        input = new StubInput(new String[] {"7"});
        new StartUI(input, tracker).init();
    }
}
