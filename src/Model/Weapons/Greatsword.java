package Model.Weapons;

import Model.Classes.GladiatorClass;
import Model.Classes.Warriors.Berserker;

public class Greatsword extends  Weapon{
    public Greatsword(String name, int lowerDmg, int higherDmg, int levelRequirment, ItemRarity itemRarity) throws Exception
    {
        super(name, lowerDmg, higherDmg, levelRequirment, itemRarity, true);
    }

    @Override
    public boolean canBeEquiped(GladiatorClass gladiatorClass) {
        if(gladiatorClass instanceof Berserker)
        {
            return true;
        }

        return false;
    }
}
