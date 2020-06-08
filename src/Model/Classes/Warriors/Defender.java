package Model.Classes.Warriors;

import Model.Classes.GladiatorClassSubtypes;
import Model.Classes.Warrior;
import Model.Gladiator.GladiatorStatisticsClass;

public class Defender extends Warrior {
    public String getName()
    {
        return "Defender";
    }

    @Override
    public GladiatorClassSubtypes getGladiatorClassSubtype() {
        return WarriorSubtypes.constructDefender();
    }

    @Override
    public GladiatorStatisticsClass getBaseStatistics() {
        GladiatorStatisticsClass gladiatorStatisticsClass = new GladiatorStatisticsClass(15,12, 10,23);
        return gladiatorStatisticsClass;
    }
}
