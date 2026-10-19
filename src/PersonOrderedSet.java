/*
PersonOrderedSet will hold non-duplicate Person objects in alphabetical order for accessing
PersonOrderedSet will extend a PersonSet
PersonOrderedSet will also have a sort method that uses insertion sort
 */

import java.util.ArrayList;

public class PersonOrderedSet extends PersonSet {

    @Override
    public void add(Person person) {
        // Already sorted with the only 1 person
        if (people.isEmpty()) {
            people.add(person);
            return;
        }

        // Check for duplicates before continuing
        if (people.contains(person)) {
            return;
        }

        // Add the person then sort using insertion sort
        people.add(person);

        int addedIndex = people.size() - 1; // subtract 1 because count starts at 1, not 0
        Person addedPerson = people.get(addedIndex);
        String addedName = addedPerson.getName().toLowerCase();
        // lowercase name because upper and lower case letters are sorted separately

        int pointer = addedIndex - 1;

        // loop through people and shift each person until a spot for the added person is found
        while (pointer >= 0) {
            Person pointerPerson = people.get(pointer);
            String pointerName = pointerPerson.getName().toLowerCase();
            // lowercase here as well for the same reason

            /*
            if pointer name comes after added name,
            the returned value will be greater than 0
            example: banana comes after apple so
            banana.compareTo(apple) will be greater than 0
             */
            if (pointerName.compareTo(addedName) > 0) {
                people.set(pointer + 1, pointerPerson); // copy the person up an index
                pointer--;
            } else {
                break;
            }
        }

        // set the new position of the added person once a spot has been made
        people.set(pointer + 1, addedPerson);

    }
}