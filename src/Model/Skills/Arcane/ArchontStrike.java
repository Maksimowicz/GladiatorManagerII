package Model.Skills.Arcane;

import Model.Classes.GladiatorClass;
import Model.Classes.Mages.Elementalist;
import Model.Gladiator.Gladiator;
import Model.Gladiator.GladiatorStatistic;
import Model.Races.Race;
import Model.Skills.Skill;

public class ArchontStrike extends ArcaneSkill {
    public ArchontStrike(Gladiator owner)
    {
        super(owner, GladiatorStatistic.Intelligence);
    }

    @Override
    public boolean canBeLearned(GladiatorClass gladiatorClass, Race race)
    {
        if(gladiatorClass instanceof Elementalist)
        {
            return true;
        }

        return false;
    }


    @Override
    public String getName() {
        return "Archont strike";
    }

    @Override
    public String getDescription() {
        return "Incrase your intelligence and hit enemy";
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
        return 20;
    }

    @Override
    public GladiatorStatistic getBoostedStatistics() {
        return GladiatorStatistic.Intelligence;
    }

    @Override
    public boolean getIsSelfDamage() {
        return false;
    }

    @Override
    public Skill getNewInstance() {
        return new ArchontStrike(null);
    }

    @Override
    public int getCost() {
        return 1000;
    }

    @Override
    public String getWhoCanLearn()
    {
        return "Elementalist";
    }
}
