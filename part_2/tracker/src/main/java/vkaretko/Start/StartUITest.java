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
     * Initialization method     *
     * @param args arguments from command line
     */
    public static void main(String[] args) {
        Input input = new StubInput(new String[] {"create stub task"});
        Tracker tracker = new Tracker();
        new StartUI(input, tracker).init();
    }
}
