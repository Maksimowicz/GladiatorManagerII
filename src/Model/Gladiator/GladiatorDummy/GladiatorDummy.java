package Model.Gladiator.GladiatorDummy;

import Model.Classes.*;
import Model.Classes.GladiatorClassFactory.GladiatorClassAbstractFactory;
import Model.Classes.Mages.*;
import Model.Classes.Rogues.*;
import Model.Classes.Warriors.*;
import Model.Gladiator.Gladiator;
import Model.Gladiator.GladiatorFactory.CommonGladiatorFactory;
import Model.Gladiator.GladiatorFactory.GladiatorAbstractFactory;
import Model.Gladiator.GladiatorFactory.LegendaryGladiatorFactory;
import Model.Gladiator.GladiatorFactory.RareGladiatorFactory;
import Model.Races.Race;
import Model.Races.RaceTypes;
import Model.Skills.Agile.AgileSlash;
import Model.Skills.Agile.ArcherFocus;
import Model.Skills.Agile.AssassinStrike;
import Model.Skills.Agile.EquilibristicDance;
import Model.Skills.Arcane.ArchontStrike;
import Model.Skills.Arcane.GranIllusion;
import Model.Skills.Arcane.MindWreck;
import Model.Skills.Arcane.SiphonLife;
import Model.Skills.Common.Punch;
import Model.Skills.Physical.DiamondArmor;
import Model.Skills.Physical.DuelistFineness;
import Model.Skills.Physical.FrenzyStrike;
import Model.Skills.Physical.LunaticRush;

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

    public int  getCost()
    {
        int multiplier = (rarity+1) * 100;

        return multiplier*this.level;
    }

    public Gladiator convertIntoGladiator(boolean isArena)
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


        Gladiator gladiator = gladiatorAbstractFactory.createGladiator(race, gladiatorClass, name, level);
        gladiator.addSkill(new Punch(gladiator));
        if(isArena) {
            addSkillBasedOnClass(gladiator);
        }
        return gladiator;
    }

    private void addSkillBasedOnClass(Gladiator gladiator)
    {
        if(gladiator.getGladiatorClassType() instanceof Mage)
        {
            gladiator.addSkill(new MindWreck(gladiator));

            if(gladiator.getGladiatorClassType() instanceof Illusionist)
            {
                gladiator.addSkill(new GranIllusion(gladiator));
            }
            else if(gladiator.getGladiatorClassType() instanceof Elementalist)
            {
                gladiator.addSkill(new ArchontStrike(gladiator));
            }
            else if(gladiator.getGladiatorClassType() instanceof Curser)
            {
                gladiator.addSkill(new SiphonLife(gladiator));
            }

        }

        if(gladiator.getGladiatorClassType() instanceof Rogue)
        {
            gladiator.addSkill(new AgileSlash(gladiator));

            if(gladiator.getGladiatorClassType() instanceof Assassin)
            {
                gladiator.addSkill(new AssassinStrike(gladiator));
            }
            else if(gladiator.getGladiatorClassType() instanceof Archer)
            {
                gladiator.addSkill(new ArcherFocus(gladiator));
            }
            else if(gladiator.getGladiatorClassType() instanceof Equilibrist)
            {
                gladiator.addSkill(new EquilibristicDance(gladiator));
            }

        }

        if(gladiator.getGladiatorClassType() instanceof Warrior)
        {
            gladiator.addSkill(new FrenzyStrike(gladiator));

            if(gladiator.getGladiatorClassType() instanceof Berserker)
            {
                gladiator.addSkill(new LunaticRush(gladiator));
            }
            else if(gladiator.getGladiatorClassType() instanceof Defender)
            {
                gladiator.addSkill(new DiamondArmor(gladiator));
            }
            else if(gladiator.getGladiatorClassType() instanceof Duelist)
            {
                gladiator.addSkill(new DuelistFineness(gladiator));
            }

        }
    }





}
