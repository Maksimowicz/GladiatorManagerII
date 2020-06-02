package Model.Skills.Arcane;

import Model.Classes.GladiatorClass;
import Model.Classes.Mage;
import Model.Gladiator.Gladiator;
import Model.Gladiator.GladiatorStatistic;
import Model.Races.Race;
import Model.Skills.Skill;

public abstract class ArcaneSkill extends Skill {

    protected ArcaneSkill(Gladiator owner, GladiatorStatistic gladiatorMultiper)
    {
        super(owner, gladiatorMultiper);
    }

    @Override
    public boolean canBeLearned(GladiatorClass gladiatorClass, Race race)
    {
        if(gladiatorClass instanceof Mage)
        {
            return true;
        }

        return false;
    }

    @Override
    public String getWhoCanLearn()
    {
        return "Mages";
    }
}
