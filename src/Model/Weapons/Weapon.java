package Model.Weapons;

import Model.Classes.GladiatorClass;

public abstract class Weapon {
    String name;

    int lowerDmg;
    int higherDmg;
    int levelRequirment;

    ItemRarity itemRarity;

    boolean isDoubleHanded;



    public Weapon(String name, int lowerDmg, int higherDmg, int levelRequirment, ItemRarity itemRarity, boolean isDoubleHanded) throws Exception
    {
        this.name = name;
        this.isDoubleHanded = isDoubleHanded;

        if(lowerDmg > higherDmg)
        {
            throw new Exception("Lower damage must be equal or lower than higher damage.");
        }
        this.lowerDmg = lowerDmg;
        this.higherDmg = higherDmg;

        if(levelRequirment < 1)
        {
            throw new Exception("Level requirment must be at least 1");
        }
        this.levelRequirment = levelRequirment;

        this.itemRarity = itemRarity;
    }



    final public String getName()
    {
        return this.name;
    }

    final public int[] getDamage()
    {
        int[] damages = {this.lowerDmg, this.higherDmg};
        return damages;
    }

    final public int getLevelRequirment()
    {
        return this.levelRequirment;
    }

    final public ItemRarity getItemRarity()
    {
        return this.itemRarity;
    }

    abstract public boolean canBeEquiped(GladiatorClass gladiatorClass);

}
