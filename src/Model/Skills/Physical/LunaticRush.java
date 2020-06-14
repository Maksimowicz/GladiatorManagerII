package Model.Skills.Physical;

import Model.Classes.GladiatorClass;
import Model.Classes.Warriors.Berserker;
import Model.Gladiator.Gladiator;
import Model.Gladiator.GladiatorStatistic;
import Model.Races.Race;
import Model.Skills.Effect.SkillEffect;
import Model.Skills.Skill;

public class LunaticRush  extends PhysicalSkill{
    public LunaticRush(Gladiator owner)
    {
        super(owner, GladiatorStatistic.Strength);
    }


    @Override
    public String getName() {
        return "Lunatic rush";
    }

    @Override
    public String getDescription() {
        return "Strike enemy in madness, lose a lot of defence.";
    }

    @Override
    public int getSkillDamage() {
        return 5 * owner.getGladiatorStatisticsClass().getStatistic(statisticMultiper);
    }

    @Override
    public int getSkillHeal() {
        return 0;
    }

    @Override
    public int getStatisticBoost() {
        return -20;
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
        return new LunaticRush(null);
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

    @Override
    public String getWhoCanLearn()
    {
        return "Berserker";
    }

    @Override
    public boolean canBeLearned(GladiatorClass gladiatorClass, Race race)
    {
        if(gladiatorClass instanceof Berserker)
        {
            return true;
        }

        return false;
    }
}
