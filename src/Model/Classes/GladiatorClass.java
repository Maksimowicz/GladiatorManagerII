package Model.Classes;

import Model.Gladiator.GladiatorStatisticsClass;

public abstract class GladiatorClass {
    public abstract String getName();
    public abstract String getSubType();
    public abstract GladiatorClassSubtypes getGladiatorClassSubtype();
    public abstract GladiatorStatisticsClass getBaseStatistics();
    public abstract GladiatorStatisticsClass getLevelUpStats();


    final public String getFullClassDescription()
    {
        return getSubType() + getName();
    }


}
