package Model.Arenas.Qualifier.RandomQualifierGenerator;

import Model.Arenas.Qualifier.ArenaQualifier;
import Model.Arenas.Qualifier.ClassQualifier;
import Model.Arenas.Qualifier.LevelQualifier;
import Model.Arenas.Qualifier.QualifierEnum.QualifierEnum;
import Model.Arenas.Qualifier.RaceQualifier;
import Model.Classes.GladiatorClassSubtypes;
import Model.Classes.RandomGladiatorClassGenerator.RandomGladiatorClassGenerator;
import Model.Races.RaceRandomGenerator.RandomRaceGenerator;
import Model.Races.RaceTypes;

import java.util.HashSet;
import java.util.Random;

public class RandomQualifierGenerator {
    Random random;
    RandomRaceGenerator randomRaceGenerator;
    RandomGladiatorClassGenerator randomGladiatorClassGenerator;
    RandomQualifierGenerator randomQualifierGenerator;

    public RandomQualifierGenerator()
    {
        random = new Random();
        randomRaceGenerator = new RandomRaceGenerator();
        randomGladiatorClassGenerator = new RandomGladiatorClassGenerator();
    }


    protected HashSet<RaceTypes> generateRandomRacesSet()
    {
        HashSet raceTypesSet = new HashSet<RaceTypes>();
        int sizeOfSet = random.nextInt(4) +1;

        while (raceTypesSet.size() != sizeOfSet)
        {
            raceTypesSet.add(randomRaceGenerator.getRandomRaceType());
        }

        return raceTypesSet;
    }

    protected HashSet<GladiatorClassSubtypes> generateRandomClassSubtypeSet()
    {
        HashSet classSubtypesSet = new HashSet<GladiatorClassSubtypes>();
        int sizeOfSet = random.nextInt(8) +1;

        while (classSubtypesSet.size() != sizeOfSet)
        {
            classSubtypesSet.add(randomGladiatorClassGenerator.getRandomGladiatorClassSubtypes());
        }

        return classSubtypesSet;
    }

    protected int getRandomLevel()
    {
        return random.nextInt(9) + 1;
    }

    protected QualifierEnum getQualifierType()
    {
        int radomizedQualifierType = random.nextInt(QualifierEnum.values().length);

        return QualifierEnum.values()[radomizedQualifierType];
    }




    public ArenaQualifier generateRandomQualifier()
    {
        QualifierEnum randomizedQualifierType = this.getQualifierType();

        switch (randomizedQualifierType)
        {
            case Level:
                return new LevelQualifier(getRandomLevel());
            case Race:
                return new RaceQualifier(generateRandomRacesSet());
            case Class:
                return new ClassQualifier(generateRandomClassSubtypeSet());
        }

        return null;
    }


}
