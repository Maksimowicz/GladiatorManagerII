package Model.Classes.Warriors;

import Model.Classes.GladiatorClassSubtypes;
import Model.Classes.Warrior;

public class Duelist extends Warrior {
    public String getName()
    {
        return "Duelist";
    }

    @Override
    public GladiatorClassSubtypes getGladiatorClassSubtype() {
        return WarriorSubtypes.constructDuelist();
    }
}
