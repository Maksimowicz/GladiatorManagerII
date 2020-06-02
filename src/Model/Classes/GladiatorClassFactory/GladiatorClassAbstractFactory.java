package Model.Classes.GladiatorClassFactory;

import Model.Classes.GladiatorClass;
import Model.Classes.GladiatorClassSubtypes;

public interface GladiatorClassAbstractFactory {
    public GladiatorClass createGladiatorClass(GladiatorClassSubtypes gladiatorClassSubtype);
}
