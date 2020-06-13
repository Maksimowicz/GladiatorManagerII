package Model.Skills.Physical;

import Model.Gladiator.Gladiator;
import Model.Gladiator.GladiatorStatistic;
import Model.Skills.Effect.SkillEffect;
import Model.Skills.Skill;

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
    public int getSkillDamage() {
        return 20 + owner.getGladiatorStatisticsClass().getStatistic(statisticMultiper);
    }

    @Override
    public int getSkillHeal() {
        return 0;
    }

    @Override
    public int getStatisticBoost() {
        return 15;
    }

    @Override
    public GladiatorStatistic getBoostedStatistics() {
        return GladiatorStatistic.Strength;
    }

    @Override
    public boolean getIsSelfDamage() {
        return false;
    }

    @Override
    public Skill getNewInstance() {
        return new FrenzyStrike(null);
    }

    @Override
    public int getCost() {
        return 400;
    }

    @Override
    public SkillEffect useSkill(Gladiator target)
    {
        SkillEffect skillEffect = super.useSkill(target);
        return skillEffect;
    }


}
