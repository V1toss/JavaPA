package vkaretko.domain;

import javax.persistence.Entity;
import javax.persistence.Table;
import javax.persistence.Id;
import javax.persistence.GeneratedValue;
import javax.persistence.Column;
import javax.persistence.GenerationType;
import javax.persistence.ManyToOne;
import javax.persistence.JoinColumn;

/**
 * Model Car.
 *
 * @author Karetko Victor.
 * @version 1.00.
 * @since 23.04.2017.
 */
@Entity
@Table(name = "cars")
public class Car {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private int id;

    @Column(name = "engine_power")
    private int enginePower;

    @Column(name = "year")
    private int year;

    @Column(name = "color")
    private String color;

    @Column(name = "mileage")
    private int mileage;

    @ManyToOne
    @JoinColumn(name = "id_body", nullable = false)
    private Body body;

    @ManyToOne
    @JoinColumn(name = "id_model", nullable = false)
    private Model model;

    @ManyToOne
    @JoinColumn(name = "id_engine", nullable = false)
    private Engine engine;

    @ManyToOne
    @JoinColumn(name = "id_drive", nullable = false)
    private Drive drive;

    @ManyToOne
    @JoinColumn(name = "id_transmission", nullable = false)
    private Transmission transmission;

    public Car() {
    }

    public Car(int id) {
        this.id = id;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getEnginePower() {
        return enginePower;
    }

    public void setEnginePower(int enginePower) {
        this.enginePower = enginePower;
    }

    public int getYear() {
        return year;
    }

    public void setYear(int year) {
        this.year = year;
    }

    public String getColor() {
        return color;
    }

    public void setColor(String color) {
        this.color = color;
    }

    public int getMileage() {
        return mileage;
    }

    public void setMileage(int mileage) {
        this.mileage = mileage;
    }

    public Body getBody() {
        return body;
    }

    public void setBody(Body body) {
        this.body = body;
    }

    public Model getModel() {
        return model;
    }

    public void setModel(Model model) {
        this.model = model;
    }

    public Engine getEngine() {
        return engine;
    }

    public void setEngine(Engine engine) {
        this.engine = engine;
    }

    public Drive getDrive() {
        return drive;
    }

    public void setDrive(Drive drive) {
        this.drive = drive;
    }

    public Transmission getTransmission() {
        return transmission;
    }

    public void setTransmission(Transmission transmission) {
        this.transmission = transmission;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Car car = (Car) o;

        if (id != car.id) return false;
        if (enginePower != car.enginePower) return false;
        if (year != car.year) return false;
        return mileage == car.mileage;
    }

    @Override
    public int hashCode() {
        int result = id;
        result = 31 * result + enginePower;
        result = 31 * result + year;
        result = 31 * result + mileage;
        return result;
    }
}
