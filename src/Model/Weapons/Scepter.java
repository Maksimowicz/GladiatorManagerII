package Model.Weapons;

import Model.Classes.GladiatorClass;
import Model.Classes.Mage;

public class Scepter extends Weapon{

    public Scepter(String name, int lowerDmg, int higherDmg, int levelRequirment, ItemRarity itemRarity) throws Exception
    {
        super(name, lowerDmg, higherDmg, levelRequirment, itemRarity, true);
    }

    public boolean canBeEquiped(GladiatorClass gladiatorClass)
    {
        if(gladiatorClass instanceof Mage)
        {
            return true;
        }

        return false;
    }
}
