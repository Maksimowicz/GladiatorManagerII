package Model.Skills.Agile;

import Model.Classes.GladiatorClass;
import Model.Classes.Rogues.Archer;
import Model.Gladiator.Gladiator;
import Model.Gladiator.GladiatorStatistic;
import Model.Races.Race;
import Model.Skills.Skill;

public class ArcherFocus extends AgileSkill{


    public ArcherFocus(Gladiator owner)
    {
        super(owner, GladiatorStatistic.Agility);
    }

    @Override
    public boolean canBeLearned(GladiatorClass gladiatorClass, Race race)
    {
        if(gladiatorClass instanceof Archer)
        {
            return true;
        }

        return false;
    }


    @Override
    public String getName() {
        return "Archer focus";
    }

    @Override
    public String getDescription() {
        return "Focus and get massive agillity buff";
    }

    @Override
    public int getSkillDamage() {
        return 0;
    }

    @Override
    public int getSkillHeal() {
        return 0;
    }

    @Override
    public int getStatisticBoost() {
        return 60;
    }

    @Override
    public GladiatorStatistic getBoostedStatistics() {
        return GladiatorStatistic.Agility;
    }

    @Override
    public boolean getIsSelfDamage() {
        return false;
    }

    @Override
    public Skill getNewInstance() {
        return new ArcherFocus(null);
    }

    @Override
    public int getCost() {
        return 900;
    }

    @Override
    public String getWhoCanLearn()
    {
        return "Archer";
    }
}
