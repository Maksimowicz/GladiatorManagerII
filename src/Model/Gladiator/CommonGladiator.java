package Model.Gladiator;

import Model.Classes.GladiatorClass;
import Model.Races.Race;

public class CommonGladiator extends Gladiator {

    public CommonGladiator(Race gladiatorRace, GladiatorClass gladiatorClass, String gladiatorName)
    {
        super(gladiatorRace, gladiatorClass, gladiatorName);
    }

    protected int getBaseHealthPoints()
    {
        return 50*1*getLevel();
    }

    public int punch()
    {
        return 12;
    }
}
