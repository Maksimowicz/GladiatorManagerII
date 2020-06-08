package Model.Gladiator;

import Model.Classes.GladiatorClass;
import Model.Races.Race;
import Model.Skills.Effect.SkillEffect;
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
    public int Level; //TODO: Remove public for tests

    private String gladiatorName;

    private int healthPoints;
    private int baseHealthPoints;

    private GladiatorStatisticsClass gladiatorStatisticsClass;

    public Gladiator(Race gladiatorRace, GladiatorClass gladiatorClass, String gladiatorName)
    {
        this.gladiatorRace = gladiatorRace;
        this.gladiatorClass = gladiatorClass;
        skillList = new ArrayList<Skill>();
        this.gladiatorName = gladiatorName;

        this.healthPoints = this.getBaseHealthPoints();
        this.gladiatorStatisticsClass = gladiatorClass.getBaseStatistics();
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

    final public boolean canLearnMoreSkills()
    {
        return skillList.size() >= 4 ? false : true;
    }

    final public boolean replaceSkill(Skill skill, int skillToReplace)
    {
        if((skillToReplace < 0 || skillToReplace >3) || skillToReplace > this.skillList.size()-1)
        {
            return false; //No more than 4 skills or not enough skills
        }

        if(skill.canBeLearned(this.gladiatorClass, this.gladiatorRace))
        {
            skillList.set(skillToReplace, skill);
            return true;
        }

        return false;
    }

    final public SkillEffect useSkill(int skillIndex, Gladiator target)
    {
        if(skillIndex > skillList.size()-1 || skillIndex < 0)
        {
            return null;
        }

        return skillList.get(skillIndex).useSkill(target);
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

    public int getHealthPoints() {
        return healthPoints;
    }

    public void setHealthPoints(int healthPoints) {
        this.healthPoints = healthPoints;
    }

    final public void setBaseHealthPoints()
    {
        this.baseHealthPoints = this.getBaseHealthPoints();
    }

    final public void removeHealthPoints(int healthPointsToRemove)
    {
        healthPoints -= Math.abs(healthPointsToRemove);
    }

    final public void addHealthPoints(int healthPointsToAdd)
    {
        healthPoints += Math.abs(healthPointsToAdd);
    }

    public GladiatorStatisticsClass getGladiatorStatisticsClass() {
        return gladiatorStatisticsClass;
    }

    public void prepareForFight()
    {
        this.healthPoints = baseHealthPoints;
    }

}
