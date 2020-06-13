package Model.Classes.Rogues;

import Model.Classes.GladiatorClassSubtypes;

public class RogueSubtypes extends GladiatorClassSubtypes {
    private RogueSubtypes(String value)
    {
        super(value);
    }

    public static RogueSubtypes constructArcher()
    {
        return new RogueSubtypes("Archer");
    }

    public static RogueSubtypes constructAssassin()
    {
        return new RogueSubtypes("Assassin");
    }

    public static RogueSubtypes constructEquilibrist()
    {
        return new RogueSubtypes("Equilibrist");
    }

}
