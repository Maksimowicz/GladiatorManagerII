package Model.Tavern.RandomGladiatorGenerator;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Random;
import java.util.Scanner;

public class NameGenerator {

    private static NameGenerator instance = null;
    ArrayList<String> namesList;
    Random randomizer = new Random();
    private NameGenerator()
    {
        namesList = new ArrayList<String>();

        try {
            File myObj = new File("src/NAMES");
            Scanner myReader = new Scanner(myObj);
            while (myReader.hasNextLine()) {
                namesList.add(myReader.nextLine());
            }
            myReader.close();
        } catch (FileNotFoundException e) {
            System.out.println("An error occurred.");
            e.printStackTrace();
        }
    }

    public static synchronized NameGenerator instance() {
        if (instance == null) {
            instance = new NameGenerator();
        }
        return instance;
    }

    public String generateName()
    {
        int name = randomizer.nextInt(namesList.size()+1);

        return namesList.get(name);
    }
}
