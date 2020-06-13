package Model.Gladiator.GladiatorDummy;

import Model.Classes.GladiatorClassSubtypes;
import Model.Classes.RandomGladiatorClassGenerator.RandomGladiatorClassGenerator;
import Model.Races.RaceRandomGenerator.RandomRaceGenerator;
import Model.Races.RaceTypes;
import Model.Tavern.RandomGladiatorGenerator.NameGenerator;

import java.util.Random;

public class RandomGladiatorDummyGenerator {
    Random random;
    RandomGladiatorClassGenerator randomGladiatorClassGenerator;
    RandomRaceGenerator randomRaceGenerator;

    public RandomGladiatorDummyGenerator()
    {
        this.random = new Random();
        randomGladiatorClassGenerator = new RandomGladiatorClassGenerator();
        randomRaceGenerator = new RandomRaceGenerator();

    }

    private GladiatorClassSubtypes generateRandomClassSubtype()
    {
       return randomGladiatorClassGenerator.getRandomGladiatorClassSubtypes();
    }

    private RaceTypes generateRandomRaceType()
    {
        return randomRaceGenerator.getRandomRaceType();
    }

    private int generateGladiatorLevel()
    {
        return random.nextInt(10)+1;

    }

    private int generateGladiatorRarity()
    {
        return random.nextInt(3);
    }

    public String getRandomName()
    {
        return NameGenerator.instance().generateName();
    }

    public GladiatorDummy generateRandomGladiatorDummy()
    {
        return new GladiatorDummy(this.getRandomName(), this.generateRandomClassSubtype(), this.generateRandomRaceType(), this.generateGladiatorLevel(), this.generateGladiatorRarity());
    }


}
