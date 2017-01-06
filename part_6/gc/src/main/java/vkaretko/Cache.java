package vkaretko;

import java.io.File;
import java.io.FileNotFoundException;
import java.lang.ref.SoftReference;
import java.util.HashMap;
import java.util.Scanner;

/**
 * Class Cache.
 *
 * @author Karetko Victor.
 * @version 1.00.
 * @since 06.01.2017.
 */
public class Cache {

    /**
     * Map for holding text files in memory with SoftReference.
     */
    private HashMap<String, SoftReference<String>> files = new HashMap<>();

    /**
     * Path to package.
     */
    private final String path;

    /**
     * Constructor of class Cache.
     * @param path path to package.
     */
    public Cache(String path) {
        this.path = path;
    }

    /**
     * Select file from package.
     * @param fileName file to select.
     * @return text from file.
     */
    public String select(String fileName) {
        SoftReference<String> file = files.get(fileName);
        if (file == null) {
            file = new SoftReference<>(readFile(fileName));
            files.put(fileName, file);
        }
        return file.get();
    }

    /**
     * Utility method to read lines.
     * @param file file to read.
     * @return line.
     */
    public String readFile(String file) {
        String pathFile = String.format("%s/%s", path, file);
        StringBuilder lines = new StringBuilder();
        try (Scanner sc = new Scanner(new File(pathFile))) {
            while (sc.hasNextLine()) {
                lines.append(sc.nextLine());
                lines.append(System.getProperty("line.separator"));
            }
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
        return lines.toString();
    }

}
