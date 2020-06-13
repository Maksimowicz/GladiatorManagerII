package Model.Gladiator;

import Model.Classes.GladiatorClass;
import Model.Races.Race;

public class CommonGladiator extends Gladiator {

    public CommonGladiator(Race gladiatorRace, GladiatorClass gladiatorClass, String gladiatorName, int level)
    {
        super(gladiatorRace, gladiatorClass, gladiatorName, level);
    }


    public CommonGladiator(Race gladiatorRace, GladiatorClass gladiatorClass, String gladiatorName)
    {
        super(gladiatorRace, gladiatorClass, gladiatorName);
    }

    protected int getBaseHealthPoints()
    {
        return 200*1*getLevel();
    }

    @Override
    public int getGladiatorCost() {
        return this.getLevel()*100;
    }

    @Override
    public int getLevelUpBaseHealthBoost() {
        return 200;
    }


    @Override
    public String getRarity()
    {
        return "Common";
    }

}
