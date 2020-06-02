package Model.Classes.Mages;

import Model.Classes.GladiatorClassFactory.GladiatorClassAbstractFactory;
import Model.Classes.GladiatorClassSubtypes;
import Model.Classes.Mage;

public class MagesFactory implements GladiatorClassAbstractFactory {

    public Mage createGladiatorClass(GladiatorClassSubtypes mageSubtypes)
    {
        if(mageSubtypes instanceof  MageSubtypes)
        {
            if(mageSubtypes.getValue() == MageSubtypes.constructCurser().getValue())
            {
                return new Curser();
            }

            if(mageSubtypes.getValue() == MageSubtypes.constructElementalist().getValue())
            {
                return new Elementalist();
            }

            if(mageSubtypes.getValue() == MageSubtypes.constructIllusionist().getValue())
            {
                return new Illusionist();
            }
        }

        //Wrong kind of parameter
        return null;
    }
}
