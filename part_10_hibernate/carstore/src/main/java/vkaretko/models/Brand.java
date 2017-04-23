package vkaretko.models;

/**
 * Model Brand. Car brand like "Audi, BMW".
 *
 * @author Karetko Victor.
 * @version 1.00.
 * @since 23.04.2017.
 */
public class Brand {
    private int id;
    private String name;

    public Brand() { }

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
