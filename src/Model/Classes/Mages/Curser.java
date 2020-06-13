package Model.Classes.Mages;

import Model.Classes.GladiatorClassSubtypes;
import Model.Classes.Mage;
import Model.Gladiator.GladiatorStatisticsClass;

public class Curser extends Mage {
    public String getName()
    {
        return "Curser";
    }

    @Override
    public GladiatorClassSubtypes getGladiatorClassSubtype() {
        return MageSubtypes.constructCurser();
    }

    @Override
    public GladiatorStatisticsClass getBaseStatistics() {
        GladiatorStatisticsClass gladiatorStatisticsClass = new GladiatorStatisticsClass(5,15, 23,17);
        return gladiatorStatisticsClass;
    }

    @Override
    public GladiatorStatisticsClass getLevelUpStats() {
        return new GladiatorStatisticsClass(1,2,6, 3);
    }

}
