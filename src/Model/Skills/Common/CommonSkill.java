package Model.Skills.Common;

import Model.Classes.GladiatorClass;
import Model.Gladiator.Gladiator;
import Model.Gladiator.GladiatorStatistic;
import Model.Races.Race;
import Model.Skills.Skill;

public abstract class CommonSkill extends Skill {
    protected CommonSkill(Gladiator owner, GladiatorStatistic gladiatorStatistic)
    {
        super(owner, gladiatorStatistic);
    }

    @Override
    public boolean canBeLearned(GladiatorClass gladiatorClass, Race race)
    {
        return true;
    }

    @Override
    public String getWhoCanLearn()
    {
        return "All";
    }

}
