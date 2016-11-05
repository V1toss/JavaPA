package vkaretko.Start;

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
}
