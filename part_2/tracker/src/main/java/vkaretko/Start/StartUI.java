package vkaretko.Start;

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

     public StartUI (Input input, Tracker tracker) {
         this.input = input;
         this.tracker = tracker;
     }

     public void init() {
         MenuTracker menu = new MenuTracker(this.input, tracker);
         menu.fillActions();
         do {
             menu.show();
             String key = input.ask("Select: ");
             menu.select(Integer.valueOf(key));
        } while(!"y".equals(this.input.ask("Exit?(y): ")));
     }

     public static void main(String[] args) {
         Input input = new ConsoleInput();
         Tracker tracker = new Tracker();
         new StartUI(input, tracker).init();
     }
 }

