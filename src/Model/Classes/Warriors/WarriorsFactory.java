package Model.Classes.Warriors;

import Model.Classes.GladiatorClassFactory.GladiatorClassAbstractFactory;
import Model.Classes.GladiatorClassSubtypes;
import Model.Classes.Warrior;

public class WarriorsFactory implements GladiatorClassAbstractFactory {
    public Warrior createGladiatorClass(GladiatorClassSubtypes warriorSubtype)
    {
        if(warriorSubtype instanceof WarriorSubtypes ) {
            if(warriorSubtype.getValue() == WarriorSubtypes.constructBerserker().getValue())
            {
                return new Berserker();
            }

            if(warriorSubtype.getValue() == WarriorSubtypes.constructDefender().getValue())
            {
                return new Defender();
            }

            if(warriorSubtype.getValue() == WarriorSubtypes.constructDuelist().getValue())
            {
                return new Duelist();
            }
        }

        //Wrong type of subtype
        return null;
    }
}
