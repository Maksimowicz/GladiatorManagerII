package Model.Skills.Common;

import Model.Gladiator.Gladiator;
import Model.Gladiator.GladiatorStatistic;
import Model.Skills.Effect.SkillEffect;
import Model.Skills.Skill;

public class Punch extends CommonSkill {

    public Punch(Gladiator owner)
    {
        super(owner, GladiatorStatistic.Strength);
    }

    @Override
    public String getName() {
        return "Punch";
    }

    @Override
    public String getDescription() {
        return "Punch enemy";
    }

    @Override
    public SkillEffect useSkill(Gladiator target)
    {
        SkillEffect skillEffect = super.useSkill(target);
        return skillEffect;
    }

    @Override
    public int getSkillDamage() {
        return 10 + 2 * owner.getGladiatorStatisticsClass().getStatistic(statisticMultiper);
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
        return new Punch(null);
    }

    @Override
    public int getCost() {
        return 50;
    }


}
