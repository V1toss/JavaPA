package vkaretko.models;

/**
 * Model Engine. Car engine types like "diesel, petrol".
 *
 * @author Karetko Victor.
 * @version 1.00.
 * @since 23.04.2017.
 */
public class Engine {

    private int id;
    private String name;

    public Engine() { }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
