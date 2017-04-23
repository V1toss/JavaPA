package vkaretko.models;

/**
 * Model Body. Car body types like "sedan, jeep".
 *
 * @author Karetko Victor.
 * @version 1.00.
 * @since 23.04.2017.
 */
public class Image {
    private int id;
    private String url;
    private Order order;

    public Image() { }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }

    public Order getOrder() {
        return order;
    }

    public void setOrder(Order order) {
        this.order = order;
    }
}
