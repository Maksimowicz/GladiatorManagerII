package Model.Tavern.RandomGladiatorGenerator;

import Model.Classes.GladiatorClass;
import Model.Classes.GladiatorClassSubtypes;
import Model.Classes.Mages.MageSubtypes;
import Model.Classes.Mages.MagesFactory;
import Model.Classes.Rogues.RogueSubtypes;
import Model.Classes.Rogues.RoguesFactory;
import Model.Classes.Warriors.WarriorSubtypes;
import Model.Classes.Warriors.WarriorsFactory;
import Model.Gladiator.CommonGladiator;
import Model.Gladiator.Gladiator;
import Model.Gladiator.LegendaryGladiator;
import Model.Gladiator.RareGladiator;
import Model.Races.Race;
import Model.Races.RaceTypes;

import java.util.Random;

public class RandomGladiatorGenerator {
    WarriorsFactory warriorsFactory;
    MagesFactory magesFactory;
    RoguesFactory roguesFactory;

    //RNG provider
    Random random = new Random();

    public RandomGladiatorGenerator()
    {
        warriorsFactory = new WarriorsFactory();
        magesFactory = new MagesFactory();
        roguesFactory = new RoguesFactory();
    }



    protected GladiatorClassSubtypes generateRandomClassSubtype()
    {
        int randomizedClass = random.nextInt(9);

        switch (randomizedClass)
        {
            case 0:
                return WarriorSubtypes.constructDuelist();
            case 1:
                return WarriorSubtypes.constructDefender();
            case 2:
                return WarriorSubtypes.constructBerserker();

            case 3:
                return MageSubtypes.constructIllusionist();
            case 4:
                return MageSubtypes.constructElementalist();
            case 5:
                return MageSubtypes.constructCurser();

            case 6:
                return RogueSubtypes.constructEquilibrist();
            case 7:
                return RogueSubtypes.constructAssassin();
            case 8:
                return  RogueSubtypes.constructArcher();

        }

        return null;
    }

    protected GladiatorClass generateRandomGladiatorClass()
    {
        GladiatorClassSubtypes classSubtype = this.generateRandomClassSubtype();

        if(classSubtype instanceof WarriorSubtypes)
        {
            return warriorsFactory.createGladiatorClass(classSubtype);

        }

        if(classSubtype instanceof MageSubtypes)
        {
            return magesFactory.createGladiatorClass(classSubtype);
        }

        if(classSubtype instanceof  RogueSubtypes)
        {
            return roguesFactory.createGladiatorClass(classSubtype);
        }

        return null;
    }

    protected RaceTypes generateRandomRace()
    {
        int randomizedRace = random.nextInt(5);

        switch (randomizedRace)
        {
            case 0:
                return RaceTypes.Orc;
            case 1:
                return RaceTypes.Elf;
            case 2:
                return RaceTypes.Dwarf;
            case 3:
                return RaceTypes.Kobold;
            case 4:
                return  RaceTypes.Human;
        }

        return null;
    }

    public  Gladiator generateRandomGladiator()
    {
        int gladiatorRarity = random.nextInt(3);
        int gladiatorLevel = random.nextInt(10) + 1;



        switch (gladiatorRarity)
        {
            case 0:
                return new CommonGladiator(Race.createRace(this.generateRandomRace()),
                                                            this.generateRandomGladiatorClass(),
                                                            NameGenerator.instance().generateName(),
                                                            gladiatorLevel);
            case 1:
                return new RareGladiator(Race.createRace(this.generateRandomRace()),
                                                            this.generateRandomGladiatorClass(),
                                                            NameGenerator.instance().generateName(),
                                                            gladiatorLevel);
            case 2:
                return new LegendaryGladiator(Race.createRace(this.generateRandomRace()),
                                                                this.generateRandomGladiatorClass(),
                                                                NameGenerator.instance().generateName(),
                                                                gladiatorLevel);
        }

        return null;
    }




}
