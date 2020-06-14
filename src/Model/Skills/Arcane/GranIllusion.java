package Model.Skills.Arcane;

import Model.Classes.GladiatorClass;
import Model.Classes.Mages.Illusionist;
import Model.Gladiator.Gladiator;
import Model.Gladiator.GladiatorStatistic;
import Model.Races.Race;
import Model.Skills.Skill;

public class GranIllusion extends ArcaneSkill{
    public GranIllusion(Gladiator owner)
    {
        super(owner, GladiatorStatistic.Intelligence);
    }

    @Override
    public boolean canBeLearned(GladiatorClass gladiatorClass, Race race)
    {
        if(gladiatorClass instanceof Illusionist)
        {
            return true;
        }

        return false;
    }


    @Override
    public String getName() {
        return "Grand illusion";
    }

    @Override
    public String getDescription() {
        return "Attack and buff your defence.";
    }

    @Override
    public int getSkillDamage() {
        return 15 + 2*owner.getGladiatorStatisticsClass().getStatistic(statisticMultiper);
    }

    @Override
    public int getSkillHeal() {
        return 0;
    }

    @Override
    public int getStatisticBoost() {
        return 30;
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
        return new GranIllusion(null);
    }

    @Override
    public int getCost() {
        return 300;
    }

    @Override
    public String getWhoCanLearn()
    {
        return "Illusionist";
    }
}
