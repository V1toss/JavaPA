package vkaretko;

import java.io.IOException;
import java.io.File;
import java.io.PrintWriter;
import java.io.FileWriter;

/**
 * The class FileSearch for search files on local disk by mask, name or regular expression.
 *
 * @author Karetko Victor
 * @version 1.00
 * @since 26.11.2016
 */
public class FileSearch {

    /**
     * Arguments from commandLine.
     */
    private String[] args;

    /**
     * Enum for selecting arguments.
     */
    enum Arg { DIR_KEY, PATH, NAME_KEY, NAME, FIND_KEY, OUT_KEY, LOG_FILE }
    /**
     * List of files.
     */
    private File[] list;
    /**
     * Log file.
     */
    private File logFile;
    /**
     * Help list.
     */
    private String[] helpList = {"Execute program java -jar find.jar with arguments:",
            "-d <path_to_search> -n <filename or mask or regex> <key = -m/-f/-r> -o <name_of_logfile>",
            "Where:",
            "<path_to_search> is path where you want to search file",
            "<filename or mask or regex> value depends from <key>",
            "key -m search files by mask",
            "key -f search file by full name",
            "key -r search files by regular expression",
            "Example: java -jar find.jar -d d:/ -n *.txt -m -o log.txt",
            "It searches all files by mask *.txt on local disk d:/ and write log to d:/log.txt"};
    /**
     * Constructor of FileSearch.
     * @param args arguments from command line
     */
    public FileSearch(String[] args) {
        this.args = args;
    }

    /**
     * Getter for argument by number from args.
     * @param numOfArgument number of argument
     * @return name
     */
    private String get(int numOfArgument) {
        return this.args[numOfArgument];
    }

    /**
     * The Main method for executing program.
     * Calls help, checkArguments and recursiveSearch methods.
     * @param args arguments from command line
     */
    public static void main(String[] args) {
        FileSearch fs = new FileSearch(args);
        if (fs.isValid()) {
            fs.setLogFile(fs.get(Arg.PATH.ordinal()), fs.get(Arg.LOG_FILE.ordinal()));
            fs.recursiveSearch(new File(fs.get(Arg.PATH.ordinal())),
                    fs.get(Arg.NAME.ordinal()), fs.get(Arg.FIND_KEY.ordinal()));
        } else if (args.length == 1 && args[0].equals("/help")) {
            fs.showHelp();
        } else {
            System.out.println("Wrong arguments\r\nTo show help - execute program with key /help");
        }
    }

    /**
     * The method chackArguments checks number of arguments and keys.
     * @return true if arguments are correct and false otherwise
     */
    private boolean isValid() {
        final int countOfArg = 7;
        return (this.args.length == countOfArg && this.get(Arg.DIR_KEY.ordinal()).equals("-d")
                && this.get(Arg.NAME_KEY.ordinal()).equals("-n")  && this.get(Arg.OUT_KEY.ordinal()).equals("-o")
                && (this.get(Arg.FIND_KEY.ordinal()).equals("-m") || this.get(Arg.FIND_KEY.ordinal()).equals("-f")
                || this.get(Arg.FIND_KEY.ordinal()).equals("-r")));
    }

    /**
     * The method recursiveSearch checks number of arguments and keys.
     * @param directory directory to search
     * @param name value to search
     * @param filterKey key to select filter
     */
    private void recursiveSearch(File directory, String name, String filterKey) {
        useFilter(directory, name, filterKey);
        writeLogFile(this.list);
        for (File file : directory.listFiles()) {
            if (file.isDirectory()) {
                recursiveSearch(file, name, filterKey);
            }
        }
    }

    /**
     * The method showHelp prints help in console.
     */
    private void showHelp() {
        try (PrintWriter showHelp = new PrintWriter(System.out)) {
            for (String line : this.helpList) {
                showHelp.println(line);
            }
        }
    }

    /**
     * The method useFilter apply filter depends of key.
     * @param directory directory to search
     * @param name value to search
     * @param filterKey key to select filter
     */
    private void useFilter(File directory, String name, String filterKey) {
        if (filterKey.equals("-m")) {
            String extension = name.substring(1);
            this.list = directory.listFiles((dir, fileName) -> fileName.endsWith(extension));
        }
        if (filterKey.equals("-f")) {
            this.list = directory.listFiles((dir, fileName) -> fileName.equals(name));
        }
        if (filterKey.equals("-r")) {
            this.list = directory.listFiles((dir, fileName) -> fileName.matches(name));
        }
    }

    /**
     * The method setLogFile for creating log file.
     * @param path path to save
     * @param name name of log file
     */
    private void setLogFile(String path, String name) {
        this.logFile = new File(String.format("%s%s", path, name));
        this.logFile.delete();
    }

    /**
     * The method writeLogFile for writing log of search result.
     * @param list list of files for write to log.
     */
    private void writeLogFile(File[] list) {
        try (PrintWriter writer = new PrintWriter(new FileWriter(this.logFile, true), true)) {
            for (File file : list) {
                writer.println(file.getPath());
            }
        } catch (IOException ioe) {
            System.out.println("Error writing logs");
        }
    }
}
