package vkaretko;

import java.io.File;

/**
 * Created by Vitoss.
 */
public class FileSearch {
    private File[] list;

    public static void main(String[] args) {
        FileSearch fs = new FileSearch();
        if (fs.checkArguments(args)) {
            fs.recursiveSearch(new File(args[1]), args[3], args[4]);
        } else {
            System.out.println("Wrong arguments");
            fs.showHelp();
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

    private void writeLogFile(File[] list) {
    }


}
