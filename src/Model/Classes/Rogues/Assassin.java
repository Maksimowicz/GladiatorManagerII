package Model.Classes.Rogues;

import Model.Classes.GladiatorClassSubtypes;
import Model.Classes.Rogue;

public class Assassin extends Rogue {
    public String getName()
    {
        return "Assassin";
    }

    @Override
    public GladiatorClassSubtypes getGladiatorClassSubtype() {
        return RogueSubtypes.constructAssassin();
    }
}
