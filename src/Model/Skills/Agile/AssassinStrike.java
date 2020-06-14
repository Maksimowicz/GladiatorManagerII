package Model.Skills.Agile;

import Model.Classes.GladiatorClass;
import Model.Classes.Rogues.Assassin;
import Model.Gladiator.Gladiator;
import Model.Gladiator.GladiatorStatistic;
import Model.Races.Race;
import Model.Skills.Skill;

public class AssassinStrike extends AgileSkill{
    public AssassinStrike(Gladiator owner)
    {
        super(owner, GladiatorStatistic.Agility);
    }

    @Override
    public boolean canBeLearned(GladiatorClass gladiatorClass, Race race)
    {
        if(gladiatorClass instanceof Assassin)
        {
            return true;
        }

        return false;
    }


    @Override
    public String getName() {
        return "Assassin strike";
    }

    @Override
    public String getDescription() {
        return "Deal heavy damage based on your str and agi..";
    }

    @Override
    public int getSkillDamage() {
        return (10 + 2*owner.getGladiatorStatisticsClass().getStatistic(statisticMultiper)) +
                (10 + 2*owner.getGladiatorStatisticsClass().getStatistic(GladiatorStatistic.Strength))
                    ;
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
        return new AssassinStrike(null);
    }

    @Override
    public int getCost() {
        return 1400;
    }

    @Override
    public String getWhoCanLearn()
    {
        return "Assassin";
    }
}
