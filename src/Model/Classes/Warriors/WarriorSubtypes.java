package Model.Classes.Warriors;

import Model.Classes.GladiatorClassSubtypes;

public class WarriorSubtypes extends GladiatorClassSubtypes {
    private WarriorSubtypes(String value)
    {
        super(value);
    }

    public static WarriorSubtypes constructBerserker()
    {
        return new WarriorSubtypes("Berserker");
    }

    public static WarriorSubtypes constructDefender()
    {
        return new WarriorSubtypes("Defender");
    }

    public static WarriorSubtypes constructDuelist()
    {
        return new WarriorSubtypes("Duelist");
    }
}
