package Model.Weapons;

import Model.Classes.GladiatorClass;
import Model.Classes.Rogues.Equilibrist;
import Model.Classes.Warrior;

public class Sword extends Weapon {
    public Sword(String name, int lowerDmg, int higherDmg, int levelRequirment, ItemRarity itemRarity) throws Exception
    {
        super(name, lowerDmg, higherDmg, levelRequirment, itemRarity, false);
    }

    public boolean canBeEquiped(GladiatorClass gladiatorClass)
    {
        if(gladiatorClass instanceof Warrior)
        {
            return  true;
        }

        if(gladiatorClass instanceof Equilibrist)
        {
            return true;
        }

        return false;
    }
}
