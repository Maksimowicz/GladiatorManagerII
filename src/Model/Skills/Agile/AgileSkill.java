package Model.Skills.Agile;

import Model.Classes.GladiatorClass;
import Model.Classes.Rogue;
import Model.Gladiator.Gladiator;
import Model.Gladiator.GladiatorStatistic;
import Model.Races.Race;
import Model.Skills.Skill;

public abstract class AgileSkill extends Skill {

    protected AgileSkill(Gladiator owner, GladiatorStatistic gladiatorMultiper)
    {
        super(owner, gladiatorMultiper);
    }

    @Override
    public boolean canBeLearned(GladiatorClass gladiatorClass, Race race)
    {
        if(gladiatorClass instanceof Rogue)
        {
            return true;
        }

        return false;
    }

    @Override
    public String getWhoCanLearn()
    {
        return "Rogues";
    }
}
