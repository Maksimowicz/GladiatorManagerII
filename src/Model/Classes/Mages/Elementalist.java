package Model.Classes.Mages;

import Model.Classes.GladiatorClassSubtypes;
import Model.Classes.Mage;

public class Elementalist extends Mage {
    public String getName()
    {
        return "Elemenalist";
    }

    @Override
    public GladiatorClassSubtypes getGladiatorClassSubtype() {
        return MageSubtypes.constructElementalist();
    }
}
