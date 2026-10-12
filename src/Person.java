/*
Person class for organizing HR data.
Stores the name, height and weight
of a given person
 */

import java.util.Objects;

public class Person {

    // Variables
    private String name;
    private double height;
    private double weight;

    // Constructor
    public Person(String name, double height, double weight) {
        this.name = name;
        this.height = height;
        this.weight = weight;
    }

    // Setters
    public void setName(String name) {
        this.name = name;
    }
    public void setHeight(double height) {
        this.height = height;
    }
    public void setWeight(double weight) {
        this.weight = weight;
    }

    // Getters
    public String getName() {
        return name;
    }
    public double getHeight() {
        return height;
    }
    public double getWeight() {
        return weight;
    }

    // To-string Method
    @Override
    public String toString() {
        return name + "\t" + height + "\t" + weight;
    }

    // Equals method
    @Override
    public boolean equals(Object obj) {
        if (obj == null) {
            return false;
        }

        if (obj == this) {
            return true;
        }

        if (!(obj instanceof Person)) {
            return false;
        }

        Person p = (Person) obj;

        return Objects.equals(name, p.name)
                && height == p.height
                && weight == p.weight;
    }

    // Hash Code method
    @Override
    public int hashCode() {
        return Objects.hash(name, height, weight);
    }
}