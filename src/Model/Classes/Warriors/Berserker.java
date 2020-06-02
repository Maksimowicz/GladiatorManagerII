package Model.Classes.Warriors;

import Model.Classes.GladiatorClassSubtypes;
import Model.Classes.Warrior;

public class Berserker extends Warrior {
    public String getName()
    {
        return "Berserker";
    }

    @Override
    public GladiatorClassSubtypes getGladiatorClassSubtype() {
        return WarriorSubtypes.constructBerserker();
    }
}
