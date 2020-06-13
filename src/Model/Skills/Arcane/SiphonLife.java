package Model.Skills.Arcane;

import Model.Classes.GladiatorClass;
import Model.Classes.Mages.Curser;
import Model.Gladiator.Gladiator;
import Model.Gladiator.GladiatorStatistic;
import Model.Races.Race;
import Model.Skills.Skill;

public class SiphonLife extends ArcaneSkill{

    public SiphonLife(Gladiator owner)
    {
        super(owner, GladiatorStatistic.Intelligence);
    }

    @Override
    public boolean canBeLearned(GladiatorClass gladiatorClass, Race race)
    {
        if(gladiatorClass instanceof Curser)
        {
            return true;
        }

        return false;
    }


    @Override
    public String getName() {
        return "Siphon life";
    }

    @Override
    public String getDescription() {
        return "Deal damage to target and heal yourself for amount dealt";
    }

    @Override
    public int getSkillDamage() {
        return 5 + 2*owner.getGladiatorStatisticsClass().getStatistic(statisticMultiper);
    }

    @Override
    public int getSkillHeal() {
        return getSkillDamage();
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
        return new SiphonLife(null);
    }

    @Override
    public int getCost() {
        return 600;
    }
}
