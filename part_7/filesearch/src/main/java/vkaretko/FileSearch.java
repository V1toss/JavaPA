package vkaretko;

import java.io.File;

/**
 * The class FileSearch for search files on local disk with two threads.
 *
 * @author Karetko Victor
 * @version 1.00
 * @since 29.01.2017
 */
public class FileSearch {
    /**
     * IsFinished true if search is finished.
     */
    private Boolean isFinished = false;

    /**
     * The method recursiveSearch checks number of arguments and keys.
     * @param directory directory to search
     * @param name value to search
     */
    private void search(File directory, String name, String key) {
        Thread threadOne = searchThread(directory, name, key);
        Thread threadTwo = searchThread(directory, name, key);
        threadOne.start();
        threadTwo.start();
        try {
            threadOne.join();
            threadTwo.join();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        System.out.println("Search finished");
    }

    /**
     * Search thread
     * @param directory directory to search
     * @param name name to search
     * @param key key of search
     * @return new Thread.
     */

    private Thread searchThread(File directory, String name, String key) {
        return new Thread() {
            @Override
            public void run() {
                recursiveSearch(directory, name);
            }

            private void recursiveSearch(File directory, String name) {
                for (File file : directory.listFiles()) {
                    synchronized (isFinished) {
                        if (!isFinished && file.isDirectory()) {
                            recursiveSearch(file, name);
                        } else if (file.getName().contains(name)) {
                            System.out.println(file.getPath());
                            if (key.equals("-o")) {
                                isFinished = true;
                            }
                        }
                    }
                }
            }
        };
    }

    /**
     * main method for sending arguments from command line.
     * @param args arguments from command line.
     */
    public static void main(String[] args) {
        FileSearch fs = new FileSearch();
        if (args.length == 2) {
            fs.search(new File(args[0]),args[1],"");
        } else {
            fs.search(new File(args[0]),args[1],args[2]);
        }

    }
}
