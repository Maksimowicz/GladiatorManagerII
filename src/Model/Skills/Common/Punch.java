package Model.Skills.Common;

import Model.Gladiator.Gladiator;
import Model.Gladiator.GladiatorStatistic;
import Model.Skills.Effect.SkillEffect;

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
    protected int getSkillDamage() {
        return 10 + 2 * owner.getGladiatorStatisticsClass().getStatistic(statisticMultiper);
    }

    @Override
    protected int getSkillHeal() {
        return 0;
    }

    @Override
    protected int getStatisticBoost() {
        return 0;
    }

    @Override
    protected GladiatorStatistic getBoostedStatistics() {
        return GladiatorStatistic.None;
    }

    @Override
    protected boolean getIsSelfDamage() {
        return false;
    }


}
