package Model.Classes.Rogues;

import Model.Classes.GladiatorClassFactory.GladiatorClassAbstractFactory;
import Model.Classes.GladiatorClassSubtypes;
import Model.Classes.Rogue;

public class RoguesFactory implements GladiatorClassAbstractFactory {
    public Rogue createGladiatorClass(GladiatorClassSubtypes rogueSubtypes)
    {
        if(rogueSubtypes instanceof RogueSubtypes)
        {
            if(rogueSubtypes.getValue() == RogueSubtypes.constructArcher().getValue())
            {
                return new Archer();
            }

            if(rogueSubtypes.getValue() == RogueSubtypes.constructAssassin().getValue())
            {
                return new Assassin();
            }

            if(rogueSubtypes.getValue() == RogueSubtypes.constructEquilibrist().getValue())
            {
                return new Equilibrist();
            }
        }

        //Wrong parameter passed
        return null;
    }
}
