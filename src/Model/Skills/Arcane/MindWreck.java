package Model.Skills.Arcane;

import Model.Gladiator.Gladiator;
import Model.Gladiator.GladiatorStatistic;
import Model.Skills.Skill;

public class MindWreck extends ArcaneSkill{
    public MindWreck(Gladiator owner)
    {
        super(owner, GladiatorStatistic.Intelligence);
    }


    @Override
    public String getName() {
        return "Mind wreck";
    }

    @Override
    public String getDescription() {
        return "Hit your enemy based on intelligence";
    }

    @Override
    public int getSkillDamage() {
        return 10 + 2*owner.getGladiatorStatisticsClass().getStatistic(statisticMultiper);
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
        return new MindWreck(null);
    }

    @Override
    public int getCost() {
        return 1000;
    }


}
