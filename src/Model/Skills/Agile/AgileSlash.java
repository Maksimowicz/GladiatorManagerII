package Model.Skills.Agile;

import Model.Gladiator.Gladiator;
import Model.Gladiator.GladiatorStatistic;
import Model.Skills.Skill;

public class AgileSlash extends AgileSkill{
    public AgileSlash(Gladiator owner)
    {
        super(owner, GladiatorStatistic.Agility);
    }

    @Override
    public String getName() {
        return "Agile slash";
    }

    @Override
    public String getDescription() {
        return "Slash fast using your agi";
    }

    @Override
    public int getSkillDamage() {
        return 3*owner.getGladiatorStatisticsClass().getStatistic(statisticMultiper);
    }

    @Override
    public int getSkillHeal() {
        return 0;
    }

    @Override
    public int getStatisticBoost() {
        return 0;
    }

    @Override
    public GladiatorStatistic getBoostedStatistics() {
        return GladiatorStatistic.None;
    }

    @Override
    public boolean getIsSelfDamage() {
        return false;
    }

    @Override
    public Skill getNewInstance() {
        return new AgileSlash(null);
    }

    @Override
    public int getCost() {
        return 600;
    }

}
