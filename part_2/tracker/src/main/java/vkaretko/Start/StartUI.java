package vkaretko.start;

import vkaretko.templates.BaseAction;

/**
  * Initialization class
  *
  * @author Karetko Victor
  * @version 1.01
  * @since 05.11.2016
 */
public class StartUI {

     private Input input;
     private Tracker tracker;

    /**
     * Constructor of StartUI class
     *
     * @param input input stream
     * @param tracker tracker object
     */
     public StartUI (Input input, Tracker tracker) {
         this.input = input;
         this.tracker = tracker;
     }

    /**
     * Method, that initialized from main method when program launched
     * Method drawing user menu and selecting item of menu     *
     */
     public void init() {

         MenuTracker menu = new MenuTracker(this.input, tracker);

         int[] range = new int[menu.actions.length];
         for (int index = 0; index < menu.actions.length; index++) {
                 range[index] = index;
         }
         menu.fillActions();

         int ExitActionKey = 7;

         UserAction exitAction = new BaseAction("Exit Program.", ExitActionKey) {
             /**
              * Anonymous inner class for executing "Exit program"
              */
             @Override
             public void execute(Input input, Tracker tracker) {
                 tracker.exit();
             }
         };
         menu.addAction(exitAction);

         do {
             menu.show();
             try {
                 menu.select(input.ask("Select: ", range));
             }
             catch (MenuOutException moe) {
                 moe.printStackTrace();
             }
        } while(!"y".equals(this.input.ask("Exit?(y): ")));
     }

    /**
     * Initialization method of program
     * @param args arguments from command line
     */
     public static void main(String[] args) {
         Input input = new ValidateInput();
         Tracker tracker = new Tracker();
         new StartUI(input, tracker).init();
     }
 }

