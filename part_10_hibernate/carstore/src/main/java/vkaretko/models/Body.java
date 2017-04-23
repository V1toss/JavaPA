package vkaretko.models;

/**
 * Model Body. Car body types like "sedan, jeep".
 *
 * @author Karetko Victor.
 * @version 1.00.
 * @since 23.04.2017.
 */
public class Body {
    private int id;
    private String name;

    public Body() { }

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
