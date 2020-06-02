package Model.Classes.Mages;

import Model.Classes.GladiatorClassSubtypes;
import Model.Classes.Mage;

public class Illusionist extends Mage {
    public String getName()
    {
        return  "Illusionist";
    }

    @Override
    public GladiatorClassSubtypes getGladiatorClassSubtype() {
        return MageSubtypes.constructIllusionist();
    }
}
