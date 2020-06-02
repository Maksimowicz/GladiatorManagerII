package Model.Classes.Mages;

import Model.Classes.GladiatorClassSubtypes;
import Model.Classes.Mage;

public class Curser extends Mage {
    public String getName()
    {
        return "Curser";
    }

    @Override
    public GladiatorClassSubtypes getGladiatorClassSubtype() {
        return MageSubtypes.constructCurser();
    }
}
