package vkaretko.models;

import javax.persistence.*;

/**
 * Model Body. Car body types like "sedan, jeep".
 *
 * @author Karetko Victor.
 * @version 1.00.
 * @since 23.04.2017.
 */
@Entity
@Table(name = "images")
public class Image {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private int id;

    @Column(name = "url", nullable = false)
    private String url;

    @ManyToOne
    @JoinColumn(name = "id_order")
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
