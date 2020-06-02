package Model.Classes.Rogues;

import Model.Classes.GladiatorClassSubtypes;
import Model.Classes.Rogue;

public class Archer extends Rogue {
    public String getName()
    {
        return "Archer";
    }

    @Override
    public GladiatorClassSubtypes getGladiatorClassSubtype() {
        return RogueSubtypes.constructArcher();
    }
}
