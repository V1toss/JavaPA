package vkaretko;

import java.io.*;

/**
 * Created by Vitoss.
 */
public class FileSearch {
    private File[] list;
    private File logFile;
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

    public static void main(String[] args) {
        FileSearch fs = new FileSearch();
        if (args[0].equals("/help")) {
            fs.showHelp();
        }
        if (fs.checkArguments(args)) {
            fs.setLogFile(args[1], args[6]);
            fs.recursiveSearch(new File(args[1]), args[3], args[4]);
        } else {
            System.out.println("Wrong arguments\r\nTo show help - execute program with key /help");
        }
    }

    private boolean checkArguments(String[] args) {
        return (args.length == 7 && args[0].equals("-d") && args[2].equals("-n") && args[5].equals("-o")
                && (args[4].equals("-m") || args[4].equals("-f") || args[4].equals("-r")));
    }

    private void recursiveSearch(File directory, String name, String filterKey) {
        useFilter(directory, name, filterKey);
        writeLogFile(this.list);
        for (File file : directory.listFiles()) {
            if (file.isDirectory()) {
                recursiveSearch(file, name, filterKey);
            }
        }
    }

    private void showHelp() {
        try (PrintWriter showHelp = new PrintWriter(System.out)) {
            for (String line : this.helpList) {
                showHelp.println(line);
            }
        }
    }

    private void useFilter (File directory, String name, String filterKey) {
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

    private void setLogFile(String path, String name) {
        this.logFile = new File(String.format("%s%s",path,name));
        this.logFile.delete();
    }

    private void writeLogFile(File[] list) {
        try(PrintWriter writer = new PrintWriter(new FileWriter(this.logFile, true), true)) {
            for (File file : list) {
                writer.println(file.getPath());
            }
        } catch (IOException ioe) {
            System.out.println("Error writing logs");
        }
    }


}
