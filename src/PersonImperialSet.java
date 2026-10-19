/*
PersonImperialSet will hold non-duplicate Person objects with imperial heights and weights
PersonImperialSet will extend a PersonSet
PersonImperialSet will also have individual convert methods for both height and weight
 */

import java.text.DecimalFormat;

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
        return kilograms * 2.20462; // converts kg to lbs
    }

    // toString method
    @Override
    public String toString() {
        String returnString = "***********Imperial Results***********\n";
        returnString += headerString.replace("cm", "in").replace("kg", "lbs");

        // using decimal format for optional decimals (no trailing zeros)
        DecimalFormat df = new DecimalFormat("0.##");

        for (Person person : people) {
            returnString += String.format("%s\t%s\t\t%s\n",
                    person.getName(),
                    df.format(person.getHeight()),
                    df.format(person.getWeight()));
        }

        return returnString;
    }
}