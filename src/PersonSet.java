/*
PersonSet will hold non-duplicate Person objects for accessing
PersonSet will have an add and get method
PersonSet will also have a toString method that will print every Set item
 */

import java.util.ArrayList;

public class PersonSet {
    protected ArrayList<Person> people;

    // Create a new array list of people
    public PersonSet() {
        this.people = new ArrayList<>();
    }

    // add person to array list
    public void add(Person person) {
        if (people.contains(person)) {
            return;
        }

        people.add(person);
    }

    // get person in array list
    public Person get(int index) {
        return people.get(index);
    }

    // remove person in array list
    public void remove(int index) {
        people.remove(index);
    }
    public void remove(Person obj) {
        people.remove(obj);
    }

    // toString method
    @Override
    public String toString() {
        String returnString = "";

        for (Person p : people) {
            returnString += p.toString() + "\n";
        }

        return returnString;
    }
}