package Model.Classes.Warriors;

import Model.Classes.GladiatorClassSubtypes;
import Model.Classes.Warrior;

public class Defender extends Warrior {
    public String getName()
    {
        return "Defender";
    }

    @Override
    public GladiatorClassSubtypes getGladiatorClassSubtype() {
        return WarriorSubtypes.constructDefender();
    }
}
