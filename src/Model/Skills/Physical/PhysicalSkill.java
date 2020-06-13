package Model.Skills.Physical;

import Model.Classes.GladiatorClass;
import Model.Classes.Warrior;
import Model.Gladiator.Gladiator;
import Model.Gladiator.GladiatorStatistic;
import Model.Races.Race;
import Model.Skills.Skill;

public abstract class PhysicalSkill extends Skill {

    protected PhysicalSkill(Gladiator owner, GladiatorStatistic gladiatorStatistic)
    {
        super(owner, gladiatorStatistic);
    }

    @Override
    public boolean canBeLearned(GladiatorClass gladiatorClass, Race race)
    {
        if(gladiatorClass instanceof Warrior)
        {
            return true;
        }

        return false;
    }

    @Override
    public String getWhoCanLearn()
    {
        return "Warriors";
    }



}
