package Model.Gladiator;

import Model.Classes.GladiatorClass;
import Model.Races.Race;
import Model.Skills.Skill;
import Model.Weapons.Weapon;

import java.util.ArrayList;
import java.util.List;

public abstract class Gladiator {
    protected Race gladiatorRace;
    protected GladiatorClass gladiatorClass;

    protected Weapon mainHand;
    protected Weapon offHand;

    protected List<Skill> skillList;

    protected int Expirience;
    protected int Level;

    private String gladiatorName;

    private int healthPoints;

    public Gladiator(Race gladiatorRace, GladiatorClass gladiatorClass, String gladiatorName)
    {
        this.gladiatorRace = gladiatorRace;
        this.gladiatorClass = gladiatorClass;
        skillList = new ArrayList<Skill>();
        this.gladiatorName = gladiatorName;

        this.healthPoints = this.getBaseHealthPoints();
    }


    final public List<Skill> getSkillList()
    {
        return this.skillList;
    }

    final public String getRace()
    {
        return gladiatorRace.getName();
    }

    final public String getGladiatorClass()
    {
        return gladiatorClass.getName();
    }

    final public String getFullClassName()
    {
        return gladiatorClass.getFullClassDescription();
    }

    final public boolean equipMainHand(Weapon weapon)
    {
        if(weapon.canBeEquiped(this.gladiatorClass))
        {
            mainHand = weapon;
            return true;
        }

        return false;
    }

    final public boolean equipOffHand(Weapon weapon)
    {
        if(weapon.canBeEquiped(this.gladiatorClass))
        {
            offHand = weapon;
            return true;
        }

        return false;
    }

    final public boolean addSkill(Skill skill)
    {
        if(skill.canBeLearned(this.gladiatorClass, this.gladiatorRace))
        {
            skillList.add(skill);
            return true;
        }

        return false;
    }

    final public Race getGladiatorRaceType()
    {
        return this.gladiatorRace;
    }

    final public GladiatorClass getGladiatorClassType()
    {
        return this.gladiatorClass;
    }

    final public int getLevel()
    {
        return this.Level;
    }

    final public void addExpirience(int ExpirienceToAdd)
    {
        this.Expirience += ExpirienceToAdd;


    }

    final public String getGladiatorName()
    {
        return this.gladiatorName;
    }

    abstract protected int getBaseHealthPoints();

}
