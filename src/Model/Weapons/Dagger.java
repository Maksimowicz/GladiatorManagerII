package Model.Weapons;

import Model.Classes.GladiatorClass;
import Model.Classes.Mages.Curser;
import Model.Classes.Rogue;

public class Dagger extends Weapon{

    public Dagger(String name, int lowerDmg, int higherDmg, int levelRequirment, ItemRarity itemRarity) throws Exception
    {
        super(name, lowerDmg, higherDmg, levelRequirment, itemRarity, false);
    }

    @Override
    public boolean canBeEquiped(GladiatorClass gladiatorClass) {
        if(gladiatorClass instanceof Rogue)
        {
            return true;
        }

        if(gladiatorClass instanceof Curser)
        {
            return  true;
        }

        return false;
    }
}
