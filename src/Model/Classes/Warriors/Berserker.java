package Model.Classes.Warriors;

import Model.Classes.GladiatorClassSubtypes;
import Model.Classes.Warrior;
import Model.Gladiator.GladiatorStatisticsClass;

public class Berserker extends Warrior {
    public String getName()
    {
        return "Berserker";
    }

    @Override
    public GladiatorClassSubtypes getGladiatorClassSubtype() {
        return WarriorSubtypes.constructBerserker();
    }

    @Override
    public GladiatorStatisticsClass getBaseStatistics() {
        GladiatorStatisticsClass gladiatorStatisticsClass = new GladiatorStatisticsClass(23,12, 10,15);
        return gladiatorStatisticsClass;
    }

    @Override
    public GladiatorStatisticsClass getLevelUpStats() {
        return new GladiatorStatisticsClass(6,3, 1, 2);
    }


}
