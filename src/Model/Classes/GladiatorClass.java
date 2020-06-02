package Model.Classes;

public abstract class GladiatorClass {
    public abstract String getName();
    public abstract String getSubType();
    public abstract GladiatorClassSubtypes getGladiatorClassSubtype();

    final public String getFullClassDescription()
    {
        return getSubType() + getName();
    }


}
