package Model.Skills.Arcane;

import Model.Classes.GladiatorClass;
import Model.Classes.Mages.Curser;
import Model.Gladiator.Gladiator;
import Model.Gladiator.GladiatorStatistic;
import Model.Races.Race;

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
    protected int getSkillDamage() {
        return 5 + 2*owner.getGladiatorStatisticsClass().getStatistic(statisticMultiper);
    }

    @Override
    protected int getSkillHeal() {
        return getSkillDamage();
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
