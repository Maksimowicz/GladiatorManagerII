package Model.Weapons;

import Model.Classes.GladiatorClass;
import Model.Classes.Warriors.Defender;

public class Shield extends Weapon {
    int defence;

    public Shield(String name, int defence, int levelRequirment, ItemRarity itemRarity) throws Exception
    {
        super(name, 0, 0, levelRequirment, itemRarity, false);
        this.defence = defence;
    }

    @Override
    public boolean canBeEquiped(GladiatorClass gladiatorClass) {

        if(gladiatorClass instanceof Defender)
        {
            return true;
        }


        return false;
    }
}
