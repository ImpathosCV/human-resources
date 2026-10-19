/*
This code is provided to give you a
starting place. It should be modified.
No further imports are needed.
To earn full credit, you must also
answer the following questions:

Q1: Car and Engine are related
by which, Inheritance or Composition?
A1: Composition

Q2: Color and Red are related
by which, Inheritance or Composition?
A2: Inheritance

Q3: Shirt and Clothing are related
by which, Inheritance or Composition?
A3: Inheritance

Q4: Furniture and Desk are related
by which, Inheritance or Composition?
A4: Inheritence

Q5: CellPhone and Battery are related
by which, Inheritance or Composition?
A5: Composition

*/

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.Scanner;

public class Main
{
    public static void main(String[] args)
    {

        System.out.println();

        // Create PersonSet
        PersonSet people = new PersonOrderedSet();

        // Read file
        Scanner fileReader = null;
        Path path = null;
        try {
            path = Paths.get(args[0]);
        } catch (ArrayIndexOutOfBoundsException e) {
            System.out.println("Please provide a file!");
        }

        // Initialize scanner and check for invalid path
        try {
            fileReader = new Scanner(path);
        } catch (IOException e) {
            System.out.println("IO Error: "+e.getMessage());
            System.exit(1);
        }

        // Instantiate Variables
        String headers = fileReader.nextLine(); // get past headers

        // Create People for each user
        try {
            while(fileReader.hasNextLine()) {
                String name = fileReader.next();
                double height = fileReader.nextInt();
                double weight = fileReader.nextInt();

                Person person = new Person(name, height, weight);
                people.add(person);
            }
        } catch (java.util.InputMismatchException e) {
            e.printStackTrace();
            System.out.println("\n"+e+"\n");
        }

        fileReader.close();

        System.out.println(headers);
        System.out.println(people.toString());


		/*
		try
		{
			FileWriter fileWriterOrder = new FileWriter("outputfile.txt");
			fileWriterOrder.write("testing");
			fileWriterOrder.close();
		}
		catch(IOException e)
		{
			e.printStackTrace();
			System.out.println(e);
			System.exit(1);
		}*/
    }
}
