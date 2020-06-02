package Model.Classes.Rogues;

import Model.Classes.GladiatorClassSubtypes;
import Model.Classes.Rogue;

public class Equilibrist extends Rogue {
    public String getName()
    {
        return "Equilibrist";
    }

    @Override
    public GladiatorClassSubtypes getGladiatorClassSubtype() {
        return RogueSubtypes.constructEquilibrist();
    }
}
