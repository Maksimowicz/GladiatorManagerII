package Model.Classes.Warriors;

import Model.Classes.GladiatorClassSubtypes;
import Model.Classes.Warrior;
import Model.Gladiator.GladiatorStatisticsClass;

public class Duelist extends Warrior {
    public String getName()
    {
        return "Duelist";
    }

    @Override
    public GladiatorClassSubtypes getGladiatorClassSubtype() {
        return WarriorSubtypes.constructDuelist();
    }

    @Override
    public GladiatorStatisticsClass getBaseStatistics() {
        GladiatorStatisticsClass gladiatorStatisticsClass = new GladiatorStatisticsClass(23,15, 10,12);
        return gladiatorStatisticsClass;
    }
}
