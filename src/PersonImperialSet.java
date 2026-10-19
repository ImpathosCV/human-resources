/*
PersonImperialSet will hold non-duplicate Person objects with imperial heights and weights
PersonImperialSet will extend a PersonSet
PersonImperialSet will also have individual convert methods for both height and weight
 */

public class PersonImperialSet extends PersonSet {

    @Override
    public void add(Person person) {
        // gather current values and convert them
        double height = person.getHeight();
        double weight = person.getWeight();
        double imperialHeight = toInches(height);
        double imperialWeight = toPounds(weight);

        // set the variables to their converted values
        person.setHeight(imperialHeight);
        person.setWeight(imperialWeight);

        super.add(person); // add the person after converting units using super method
    }

    public static double toInches(double centimeters) {
        return centimeters / 2.54; // converts cm to in
    }

    public static double toPounds(double kilograms) {
        return kilograms * 2.205; // converts kg to lbs
    }

    // toString method
    @Override
    public String toString() {
        String returnString = headerString.replace("cm", "in").replace("kg", "lbs");
        for (Person p : people) {
            returnString += String.format("%s\t%.2f\t\t%.2f\n",
                    p.getName(),
                    p.getHeight(),
                    p.getWeight());
        }

        return returnString;
    }
}