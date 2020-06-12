package Model.Gladiator;

import org.jetbrains.annotations.NotNull;


public final class GladiatorStatisticsClass {
    private int strength;
    private int agility;
    private int intelligence;
    private int defence;

    private int strengthModifier;
    private int agilityModifier;
    private int intelligenceModifier;
    private int defenceModifier;

    public GladiatorStatisticsClass(int strength, int agility, int intelligence, int defence)
    {
        this.strength = strength;
        this.agility = agility;
        this.intelligence = intelligence;
        this.defence = defence;

        this.strengthModifier = 0;
        this.agilityModifier = 0;
        this.intelligenceModifier = 0;
        this.defenceModifier = 0;
    }

    private int getStrength()
    {
        return this.strength;
    }

    private int getAgility()
    {
        return this.agility;
    }

    private int getIntelligence()
    {
        return this.intelligence;
    }

    private int getDefence()
    {
        return this.defence;
    }

    public int getStatistic(@NotNull GladiatorStatistic gladiatorStatistic)
    {
        switch(gladiatorStatistic)
        {
            case Strength:
                return this.getStrength() + strengthModifier;
            case Agility:
                return this.getAgility() + agilityModifier;
            case Intelligence:
                return this.getIntelligence() + intelligenceModifier;
            case Defence:
                return this.getDefence() + defenceModifier;
            case None:
                return -1;
        }

        return -1;
    }

    private void addStrength(int strengthToAdd)
    {
        this.strength += strengthToAdd;
    }

    private void addAgility(int agilityToAdd)
    {
        this.agility += agilityToAdd;
    }

    private void addIntelligence(int intelligenceToAdd)
    {
        this.intelligence += intelligenceToAdd;
    }

    private void addDefence(int defenceToAdd)
    {
        this.defence += defenceToAdd;
    }

    public void addStatistic(@NotNull GladiatorStatistic gladiatorStatistic, int statisticToAdd)
    {
        switch (gladiatorStatistic)
        {
            case Strength:
                this.addStrength(statisticToAdd);
                break;
            case Agility:
                this.addAgility(statisticToAdd);
                break;
            case Intelligence:
                this.addIntelligence(statisticToAdd);
                break;
            case None:
                break;
        }
    }

    //Separate methods for better reading of code
    private void addStrengthModifier(int strengthToAdd)
    {
        this.strengthModifier += strengthToAdd;
    }

    private void addAgilityModifier(int agilityToAdd)
    {
        this.agilityModifier += agilityToAdd;
    }

    private void addIntelligenceModifier(int intelligenceToAdd)
    {
        this.intelligenceModifier += intelligenceToAdd;
    }

    private void addDefenceModifier(int defenceToAdd)
    {
        this.defenceModifier += defenceToAdd;
    }

    public void addStatisticModifier(@NotNull GladiatorStatistic gladiatorStatistic, int modifierToAdd)
    {
        switch (gladiatorStatistic)
        {
            case Strength:
                this.addStrengthModifier(modifierToAdd);
                break;
            case Agility:
                this.addAgilityModifier(modifierToAdd);
                break;
            case Intelligence:
                this.addIntelligenceModifier(modifierToAdd);
                break;
            case None:
                break;
        }
    }

    //Used after fight to clear stats
    public void clearModifiers()
    {
        this.strengthModifier = 0;
        this.agilityModifier = 0;
        this.intelligenceModifier = 0;
        this.defenceModifier = 0;
    }


    public void addLevelUp(GladiatorStatisticsClass statsToAdd)
    {
        this.strength += statsToAdd.strength;
        this.agility += statsToAdd.agility;
        this.defence += statsToAdd.defence;
        this.intelligence += statsToAdd.intelligence;
    }




}
