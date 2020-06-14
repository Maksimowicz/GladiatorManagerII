package Model.Gladiator;

import Model.Classes.GladiatorClass;
import Model.Gladiator.GladiatorTitle.EmptyTitle;
import Model.Gladiator.GladiatorTitle.RookieTitle;
import Model.Gladiator.GladiatorTitle.TitleDecorator;
import Model.Gladiator.GladiatorTitle.VeteranTitle;
import Model.Races.Race;
import Model.Skills.Effect.SkillEffect;
import Model.Skills.Skill;
import Model.Weapons.Weapon;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public abstract class Gladiator {
    protected Race gladiatorRace;
    protected GladiatorClass gladiatorClass;

    protected Weapon mainHand;
    protected Weapon offHand;

    protected List<Skill> skillList;

    protected int Expirience;
    private int Level;

    private String gladiatorName;

    private int healthPoints;
    private int baseHealthPoints;

    private GladiatorStatisticsClass gladiatorStatisticsClass;
    Random random;

    TitleDecorator titleDecorator;


    public Gladiator(Race gladiatorRace, GladiatorClass gladiatorClass, String gladiatorName, int level)
    {
        this.gladiatorRace = gladiatorRace;
        this.gladiatorClass = gladiatorClass;
        skillList = new ArrayList<Skill>();
        this.gladiatorName = gladiatorName;

        this.healthPoints = this.getBaseHealthPoints();
        this.gladiatorStatisticsClass = gladiatorClass.getBaseStatistics();
        this.Level = 0;
        this.titleDecorator = new EmptyTitle();

        for(int i = 0; i < level; i++)
        {
            this.levelUp();
        }

        random = new Random();
    }

    public Gladiator(Race gladiatorRace, GladiatorClass gladiatorClass, String gladiatorName)
    {
        this.gladiatorRace = gladiatorRace;
        this.gladiatorClass = gladiatorClass;
        skillList = new ArrayList<Skill>();
        this.gladiatorName = gladiatorName;

        this.healthPoints = this.getBaseHealthPoints();
        this.gladiatorStatisticsClass = gladiatorClass.getBaseStatistics();
        this.Level = 0;
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
            skill.setOwner(this);
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
        if(this.Expirience > this.getNextLevelExpirience())
        {
            this.levelUp();
        }
    }

    final public void levelUp()
    {
        this.getGladiatorStatisticsClass().addLevelUp(gladiatorClass.getLevelUpStats());
        this.baseHealthPoints += this.getLevelUpBaseHealthBoost();
        this.Level++;

        if(this.Level == 10)
        {
            this.titleDecorator = new RookieTitle(this.titleDecorator);
        }

        if(this.Level == 20)
        {
            this.titleDecorator = new VeteranTitle(this.titleDecorator);
        }
    }

    final public String getGladiatorName()
    {
        return this.gladiatorName + " " + this.titleDecorator.getTitle();
    }



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

    public void removeNullSkills()
    {
        while(skillList.remove(null));
    }



    final public int getNextLevelExpirience()
    {
        return 100*getLevel()*getLevel();
    }


    abstract public int getGladiatorCost();

    abstract public int getLevelUpBaseHealthBoost();

    abstract protected int getBaseHealthPoints();

    abstract public String getRarity();

    public int generateExp()
    {
        return (int)(this.getNextLevelExpirience()/3);
    }

    //Random skill casted by AI
    public SkillEffect useRandomSkill(Gladiator target)
    {

        int skillToUse = random.nextInt(skillList.size());
        return skillList.get(skillToUse).useSkill(target);
    }
}
