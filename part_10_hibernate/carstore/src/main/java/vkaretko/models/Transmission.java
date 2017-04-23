package vkaretko.models;

/**
 * Model Transmission. Car transmission types like "mechanical, auto".
 *
 * @author Karetko Victor.
 * @version 1.00.
 * @since 23.04.2017.
 */
public class Transmission {

    private int id;

    private String name;

    public Transmission() { }

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
