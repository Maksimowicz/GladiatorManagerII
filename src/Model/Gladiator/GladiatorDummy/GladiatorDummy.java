package Model.Gladiator.GladiatorDummy;

import Model.Classes.GladiatorClass;
import Model.Classes.GladiatorClassFactory.GladiatorClassAbstractFactory;
import Model.Classes.GladiatorClassSubtypes;
import Model.Classes.Mages.MageSubtypes;
import Model.Classes.Mages.MagesFactory;
import Model.Classes.Rogues.RogueSubtypes;
import Model.Classes.Rogues.RoguesFactory;
import Model.Classes.Warriors.WarriorSubtypes;
import Model.Classes.Warriors.WarriorsFactory;
import Model.Gladiator.Gladiator;
import Model.Gladiator.GladiatorFactory.CommonGladiatorFactory;
import Model.Gladiator.GladiatorFactory.GladiatorAbstractFactory;
import Model.Gladiator.GladiatorFactory.LegendaryGladiatorFactory;
import Model.Gladiator.GladiatorFactory.RareGladiatorFactory;
import Model.Races.Race;
import Model.Races.RaceTypes;

public class GladiatorDummy {
    String name;
    GladiatorClassSubtypes className;
    RaceTypes raceTypes;
    int level;
    int rarity;

    public GladiatorDummy(String name, GladiatorClassSubtypes className, RaceTypes raceTypes, int level, int rarity)
    {
        this.name = name;
        this.className = className;
        this.raceTypes = raceTypes;
        this.level = level;
        this.rarity = rarity;

    }

    public String getRarity()
    {
        switch (rarity)
        {
            case 0:
                return "Common";
            case 1:
                return "Rare";
            case 2:
                return "Legendary";
        }

        return "";
    }

    public String getName()
    {
        return this.name;
    }

    public GladiatorClassSubtypes getClassName()
    {
        return this.className;
    }

    public RaceTypes getRaceTypes()
    {
        return this.raceTypes;
    }

    public int getLevel()
    {
        return this.level;
    }

    public double  getCost()
    {
        int multiplier = 100 + rarity * 50;

        return multiplier*this.level;
    }

    public Gladiator convertIntoGladiator()
    {
        GladiatorClassAbstractFactory gladiatorClassAbstractFactory = null;
        GladiatorAbstractFactory gladiatorAbstractFactory = null;

        GladiatorClass gladiatorClass;
        Race race = null;

        if(this.getClassName() instanceof RogueSubtypes)
        {
            gladiatorClassAbstractFactory = new RoguesFactory();
        }

        if(this.getClassName() instanceof MageSubtypes)
        {
            gladiatorClassAbstractFactory = new MagesFactory();
        }

        if(this.getClassName() instanceof WarriorSubtypes)
        {
            gladiatorClassAbstractFactory = new WarriorsFactory();
        }

        switch (rarity)
        {
            case 0:
                gladiatorAbstractFactory = new CommonGladiatorFactory();
                break;
            case 1:
                gladiatorAbstractFactory = new RareGladiatorFactory();
                break;
            case 2:
                gladiatorAbstractFactory = new LegendaryGladiatorFactory();
                break;
        }

        gladiatorClass = gladiatorClassAbstractFactory.createGladiatorClass(this.className);
        race = Race.createRace(this.raceTypes);

        return gladiatorAbstractFactory.createGladiator(race, gladiatorClass, name, level);
    }




}
