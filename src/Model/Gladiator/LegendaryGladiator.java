package Model.Gladiator;

import Model.Classes.GladiatorClass;
import Model.Races.Race;

public class LegendaryGladiator extends Gladiator{

    public LegendaryGladiator(Race gladiatorRace, GladiatorClass gladiatorClass, String gladiatorName) {
        super(gladiatorRace, gladiatorClass, gladiatorName);
    }

    protected int getBaseHealthPoints()
    {
        return (int)(10*1.5*getLevel());
    }
    public int punch()
    {
        return 16;
    }
}
