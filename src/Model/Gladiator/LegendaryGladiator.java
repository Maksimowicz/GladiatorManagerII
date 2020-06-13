package Model.Gladiator;

import Model.Classes.GladiatorClass;
import Model.Races.Race;

public class LegendaryGladiator extends Gladiator{

    public LegendaryGladiator(Race gladiatorRace, GladiatorClass gladiatorClass, String gladiatorName, int level) {
        super(gladiatorRace, gladiatorClass, gladiatorName, level);
    }

    public LegendaryGladiator(Race gladiatorRace, GladiatorClass gladiatorClass, String gladiatorName) {
        super(gladiatorRace, gladiatorClass, gladiatorName);
    }

    protected int getBaseHealthPoints()
    {
        return (int)(200*1.5*getLevel());
    }

    @Override
    public int getGladiatorCost() {
        return this.getLevel()*300;
    }

    @Override
    public int getLevelUpBaseHealthBoost() {
        return 300;
    }

    @Override
    public String getRarity()
    {
        return "Legendary";
    }
}
