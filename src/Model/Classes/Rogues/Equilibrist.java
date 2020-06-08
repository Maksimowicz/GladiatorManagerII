package Model.Classes.Rogues;

import Model.Classes.GladiatorClassSubtypes;
import Model.Classes.Rogue;
import Model.Gladiator.GladiatorStatisticsClass;

public class Equilibrist extends Rogue {
    public String getName()
    {
        return "Equilibrist";
    }

    @Override
    public GladiatorClassSubtypes getGladiatorClassSubtype() {
        return RogueSubtypes.constructEquilibrist();
    }

    @Override
    public GladiatorStatisticsClass getBaseStatistics() {
        GladiatorStatisticsClass gladiatorStatisticsClass = new GladiatorStatisticsClass(11,24,12, 13);

        return gladiatorStatisticsClass;
    }
}
