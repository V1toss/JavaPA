package vkaretko.models;

import javax.persistence.*;

/**
 * Model Drive. Car drive types like "front, back".
 *
 * @author Karetko Victor.
 * @version 1.00.
 * @since 23.04.2017.
 */
@Entity
@Table(name = "drive")
public class Drive {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private int id;

    @Column(name = "name", nullable = false)
    private String name;

    public Drive() { }

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
