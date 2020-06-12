package Model.Classes.Rogues;

import Model.Classes.GladiatorClassSubtypes;
import Model.Classes.Rogue;
import Model.Gladiator.GladiatorStatisticsClass;

public class Archer extends Rogue {
    public String getName()
    {
        return "Archer";
    }

    @Override
    public GladiatorClassSubtypes getGladiatorClassSubtype() {
        return RogueSubtypes.constructArcher();
    }

    @Override
    public GladiatorStatisticsClass getBaseStatistics() {
        GladiatorStatisticsClass gladiatorStatisticsClass = new GladiatorStatisticsClass(10,25, 10,15);
        return gladiatorStatisticsClass;
    }

    @Override
    public GladiatorStatisticsClass getLevelUpStats() {
        return new GladiatorStatisticsClass(1,7,2,2);
    }

}
