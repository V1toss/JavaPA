package vkaretko.chat;

import java.io.File;
import java.io.IOException;
import java.io.BufferedWriter;
import java.io.FileWriter;
import java.util.ArrayList;
import java.util.Scanner;

/**
 * Class ConsoleChat.
 *
 * User enter a phrase, the program takes a random phrase from a text file
 * and displays it in the answer.The program stops if the user enters word
 * "stop" while it may continue to send messages in chat. If the user enters
 * the word "continue", the program again begins to respond. If the user
 * enters the word "end" the program terminates. The whole dialogue and
 * commands are written to the log file.
 *
 * @author Karetko Victor
 * @version 1.00
 * @since 18.11.2016
 */
public class ConsoleChat {
    /**
     * Field to check status paused chat or not.
     */
    private boolean isPaused = false;
    /**
     * If this field become true - program terminates.
     */
    private boolean isExit = false;
    /**
     * File with BOT phrases.
     */
    private File phrases;
    /**
     * File for save chat log.
     */
    private File logFile;
    /**
     * FilePath to phrases dictionary for default constructors.
     */
    private final String filePathPhrase = String.format("%s%s%s", System.getProperty("user.dir"),
            File.separator, "part_3/io/src/main/java/vkaretko/chat/resources/phrases.txt");
    /**
     * FilePath to log file for default constructors.
     */
    private final String filePathLog = String.format("%s%s%s", System.getProperty("user.dir"),
            File.separator, "part_3/io/src/main/java/vkaretko/chat/logs/log.txt");
    /**
     * List that filling at beginning, contains list of phrases.
     */
    private ArrayList<String> phraseList = new ArrayList<>();

    /**
     * Default constructor without parameters.
     * @throws IOException if file not found
     */
    public ConsoleChat() throws IOException {
       this.phrases = new File(this.filePathPhrase);
       this.logFile = new File(this.filePathLog);
    }

    /**
     * Constructor with two parameters.
     * @param pathToDictionary path to dictionary file
     * @param pathToLogFile path to log file
     * @throws IOException if file not found
     */
    public ConsoleChat(String pathToDictionary, String pathToLogFile) throws IOException {
        this.phrases = new File(pathToDictionary);
        this.logFile = new File(pathToLogFile);
    }

    /**
     * Method for initiate console chat.
     * @throws IOException if file not found
     */
    public void init() throws IOException {
        fillPhrasesList();
        try (Scanner sc = new Scanner(System.in);
             BufferedWriter writer = new BufferedWriter(new FileWriter(this.logFile))) {
            while (!isExit && sc.hasNext()) {
                String line = sc.nextLine();
                checkConsoleChatStatus(line);
                writer.write(String.format("User: %s\r\n", line));
                if (!isPaused && !isExit) {
                    writer.write(String.format("PC: %s\r\n", getNextRandomPhrase()));
                }
            }
        }
    }

    /**
     * Method for filling phrase list with values from phrases file.
     * @throws IOException if file not found
     */
    private void fillPhrasesList() throws IOException {
        try (Scanner sc = new Scanner(this.phrases)) {
            while (sc.hasNext()) {
                this.phraseList.add(sc.nextLine());
            }
        }
    }

    /**
     * Method for getting random line from list of phrases.
     * @throws IOException if file not found
     * @return random line from phrases list
     */
    private String getNextRandomPhrase() throws IOException {
        int linePosition = (int) (Math.random() * phraseList.size());
        String line = this.phraseList.get(linePosition);
        System.out.println(line);
        return line;
    }

    /**
     * Method for checking console chat status.
     * Compare entered word with key words to stop, continue or terminate program.
     * @param line entered line from user
     */
    private void checkConsoleChatStatus(String line) {
        this.isExit = line.equals("end");
        if (line.equals("stop")) {
            this.isPaused = true;
        } else if (line.equals("continue")) {
            this.isPaused = false;
        }
    }
}
