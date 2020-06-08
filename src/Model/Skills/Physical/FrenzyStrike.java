package Model.Skills.Physical;

import Model.Gladiator.Gladiator;
import Model.Gladiator.GladiatorStatistic;
import Model.Skills.Effect.SkillEffect;

public class FrenzyStrike extends PhysicalSkill {
    public FrenzyStrike(Gladiator owner)
    {
        super(owner, GladiatorStatistic.Strength);
    }


    @Override
    public String getName() {
        return "Frenzy Strike";
    }

    @Override
    public String getDescription() {
        return "Strike enemy and get warriors frenzy (boost Strength stat)";
    }

    @Override
    protected int getSkillDamage() {
        return 20 + owner.getGladiatorStatisticsClass().getStatistic(statisticMultiper);
    }

    @Override
    protected int getSkillHeal() {
        return 0;
    }

    @Override
    protected int getStatisticBoost() {
        return 15;
    }

    @Override
    protected GladiatorStatistic getBoostedStatistics() {
        return GladiatorStatistic.Strength;
    }

    @Override
    protected boolean getIsSelfDamage() {
        return false;
    }

    @Override
    public SkillEffect useSkill(Gladiator target)
    {
        SkillEffect skillEffect = super.useSkill(target);
        return skillEffect;
    }
}
