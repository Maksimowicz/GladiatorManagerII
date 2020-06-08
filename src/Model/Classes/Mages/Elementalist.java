package Model.Classes.Mages;

import Model.Classes.GladiatorClassSubtypes;
import Model.Classes.Mage;
import Model.Gladiator.GladiatorStatisticsClass;

public class Elementalist extends Mage {
    public String getName()
    {
        return "Elemenalist";
    }

    @Override
    public GladiatorClassSubtypes getGladiatorClassSubtype() {
        return MageSubtypes.constructElementalist();
    }

    @Override
    public GladiatorStatisticsClass getBaseStatistics() {
        GladiatorStatisticsClass gladiatorStatisticsClass = new GladiatorStatisticsClass(15,5, 31,9);
        return gladiatorStatisticsClass;
    }

}
