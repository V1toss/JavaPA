package vkaretko.models;

import javax.persistence.*;

/**
 * Model Brand. Car brand like "Audi, BMW".
 *
 * @author Karetko Victor.
 * @version 1.00.
 * @since 23.04.2017.
 */
@Entity
@Table(name = "brand")
public class Brand {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private int id;

    @Column(name = "name", nullable = false)
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
