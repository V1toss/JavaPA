package vkaretko;

/**
 * Class Model.
 *
 * @author Karetko Victor.
 * @version 1.00.
 * @since 05.02.2017.
 */
public class Model {
    /**
     * Name of model.
     */
    private String name;

    /**
     * Version of model.
     */
    private volatile int version = 0;

    /**
     * Constructor of model.
     * @param name name of model.
     */
    public Model(String name) {
        this.name = name;
    }

    /**
     * Getter for version.
     * @return version.
     */
    public int getVersion() {
        return version;
    }

    /**
     * Method update version of model.
     */
    public void update() {
        this.version++;
    }
}
