package vkaretko.start;

/**
 * Class for simulating user inputs in program
 *
 * @author Karetko Victor
 * @version 1.00
 * @since 05.11.2016
 */
public class StubInput implements Input {
    private String [] answers;
    private int position = 0;


    public StubInput (String[] answers) {
        this.answers = answers;
    }

    public String ask (String question) {
        return answers[position++];
    }

    public int ask (String question, int[] range) {
        int key = Integer.valueOf(this.ask(question));
        boolean exist = false;
        for (int value : range) {
            if (value == key) {
                exist = true;
                break;
            }
        }
        if (exist) {
            return key;
        } else {
            throw new MenuOutException("Out of menu range");
        }
    }
}
