package vkaretko;

/**
 * Class User.
 *
 * @author Karetko Victor.
 * @version 1.00.
 * @since 06.01.2017.
 */
public class User {
    /**
     * Field name.
     */
    public String name;

    /**
     * Constructor of class User.
     * @param name name of user.
     */
    public User(String name) {
        this.name = name;
    }

    /**
     * Overrided finalize
     * @throws Throwable throwable
     */
    @Override
    protected void finalize() throws Throwable {
        super.finalize();
        System.out.println(String.format("Finalize %s", this));
    }

    /**
     * Overrided method string.
     * @return object representation in string line.
     */
    @Override
    public String toString() {
        return String.format("User %s", name);
    }

    /**
     * Tests for gc.
     * @param args arguments from command line.
     */
    public static void main(String[] args) throws InterruptedException {
        for (int index = 0; index < 5000; index++) {
            new User(String.format("name %s", index));
        }
        info();
    }

    /**
     * Print info about memory usage.
     */
    public static void info() {
        int mb = 1024*1024;

        Runtime runtime = Runtime.getRuntime();
        System.out.println("##### Heap utilization statistics [MB] #####");
        System.out.println("Used Memory:"
                + (runtime.totalMemory() - runtime.freeMemory()) / mb);
        System.out.println("Free Memory:"
                + runtime.freeMemory() / mb);
        System.out.println("Total Memory:" + runtime.totalMemory() / mb);
        System.out.println("Max Memory:" + runtime.maxMemory() / mb);
    }
}
