package Model.Arenas.Qualifier;

import Model.Classes.GladiatorClassSubtypes;
import Model.Gladiator.Gladiator;

import java.util.Set;

public class ClassQualifier implements ArenaQualifier {
    Set<GladiatorClassSubtypes> classSubtypes;

    public ClassQualifier(Set<GladiatorClassSubtypes> classSubtypes)
    {
        this.classSubtypes = classSubtypes;
    }

    @Override
    public boolean validateGladiator(Gladiator gladiator) {
        if(this.classSubtypes.contains(gladiator.getGladiatorClassType().getGladiatorClassSubtype())) {
            return true;
        }

        return false;
    }
}
