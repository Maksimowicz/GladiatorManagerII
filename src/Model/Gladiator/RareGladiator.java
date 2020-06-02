package Model.Gladiator;

import Model.Classes.GladiatorClass;
import Model.Races.Race;

public class RareGladiator extends Gladiator {

    public RareGladiator(Race gladiatorRace, GladiatorClass gladiatorClass, String gladiatorName)
    {
        super(gladiatorRace, gladiatorClass, gladiatorName);
    }

    protected int getBaseHealthPoints()
    {
        return (int)(10*1.25*getLevel());
    }

    public int punch()
    {
        return 14;
    }
}
