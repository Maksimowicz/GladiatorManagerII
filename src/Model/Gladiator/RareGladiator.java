package Model.Gladiator;

import Model.Classes.GladiatorClass;
import Model.Races.Race;

public class RareGladiator extends Gladiator {

    public RareGladiator(Race gladiatorRace, GladiatorClass gladiatorClass, String gladiatorName, int level)
    {
        super(gladiatorRace, gladiatorClass, gladiatorName, level);
    }

    public RareGladiator(Race gladiatorRace, GladiatorClass gladiatorClass, String gladiatorName)
    {
        super(gladiatorRace, gladiatorClass, gladiatorName);
    }

    protected int getBaseHealthPoints()
    {
        return (int)(200*1.25*getLevel());
    }

    @Override
    public double getGladiatorCost() {
        return this.getLevel()*200;
    }

    @Override
    public int getLevelUpBaseHealthBoost() {
        return 250;
    }

    @Override
    public String getRarity()
    {
        return "Rare";
    }
}
