package Model.Skills.Agile;

import Model.Classes.GladiatorClass;
import Model.Classes.Rogues.Equilibrist;
import Model.Gladiator.Gladiator;
import Model.Gladiator.GladiatorStatistic;
import Model.Races.Race;
import Model.Skills.Skill;

public class EquilibristicDance extends AgileSkill{
    public EquilibristicDance(Gladiator owner)
    {
        super(owner, GladiatorStatistic.Agility);
    }

    @Override
    public boolean canBeLearned(GladiatorClass gladiatorClass, Race race)
    {
        if(gladiatorClass instanceof Equilibrist)
        {
            return true;
        }

        return false;
    }


    @Override
    public String getName() {
        return "Equilibristic dance";
    }

    @Override
    public String getDescription() {
        return "Deal damage based on agi, str and get defence boost.";
    }

    @Override
    public int getSkillDamage() {
        return (owner.getGladiatorStatisticsClass().getStatistic(statisticMultiper)) +
                (owner.getGladiatorStatisticsClass().getStatistic(GladiatorStatistic.Strength))
                ;
    }

    @Override
    public int getSkillHeal() {
        return 0;
    }

    @Override
    public int getStatisticBoost() {
        return 10;
    }

    @Override
    public GladiatorStatistic getBoostedStatistics() {
        return GladiatorStatistic.Defence;
    }

    @Override
    public boolean getIsSelfDamage() {
        return false;
    }

    @Override
    public Skill getNewInstance() {
        return new EquilibristicDance(null);
    }

    @Override
    public int getCost() {
        return 500;
    }

    @Override
    public String getWhoCanLearn()
    {
        return "Equilibrist";
    }

}
