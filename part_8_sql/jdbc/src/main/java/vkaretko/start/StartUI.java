package vkaretko.start;

/**
  * Initialization class.
  *
  * @author Karetko Victor
  * @version 1.01
  * @since 18.02.2017
 */
public class StartUI {

    /**
     * Input.
     */
     private Input input;

    /**
     * Tracker.
     */
    private Tracker tracker;

    /**
     * Constructor of StartUI class.
     *
     * @param input input stream.
     * @param tracker tracker object.
     */
     public StartUI(Input input, Tracker tracker) {
         this.input = input;
         this.tracker = tracker;
     }

    /**
     * Method, that initialized from main method when program launched.
     * Method drawing user menu and selecting item of menu.
     */
     public void init() {
         MenuTracker menu = new MenuTracker(this.input, tracker);
         menu.fillActions();
         int[] range = new int[menu.getActionsSize()];
         for (int index = 0; index < menu.getActionsSize(); index++) {
             range[index] = index;
         }

         tracker.losdProperties();
         tracker.connectToDB();
         do {
             menu.show();
             try {
                 menu.select(input.ask("Select: ", range));
             } catch (MenuOutException moe) {
                 moe.printStackTrace();
             }
        } while (!"y".equals(this.input.ask("Exit?(y): ")));
        tracker.disconnect();
     }

    /**
     * Initialization method of program.
     * @param args arguments from command line.
     */
     public static void main(String[] args) {
         Input input = new ValidateInput();
         Tracker tracker = new Tracker();
         new StartUI(input, tracker).init();
     }
 }

