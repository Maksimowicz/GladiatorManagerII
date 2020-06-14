package Model.Skills;

import Model.Classes.GladiatorClass;
import Model.Gladiator.Gladiator;
import Model.Gladiator.GladiatorStatistic;
import Model.Races.Race;
import Model.Skills.Effect.SkillEffect;

public abstract class Skill {

    protected Gladiator owner; //Caller of the spell

    final protected GladiatorStatistic statisticMultiper;

    //Cretion of specific use of specific skill skill
    protected Skill(Gladiator owner, GladiatorStatistic statisticMultiper)
    {
        this.owner = owner;
        this.statisticMultiper = statisticMultiper;

    }

    public void setOwner(Gladiator owner)
    {
        this.owner = owner;
    }

    abstract public String getName(); //Returns name of skill
    abstract public boolean canBeLearned(GladiatorClass gladiatorClass, Race race); //Indicated who can use skill
    abstract public String getWhoCanLearn(); //Gets string version of classes that can learn skill
    abstract public String getDescription(); //Gets description of the skill

    public SkillEffect useSkill(Gladiator target) //uses skill
    {
        int damageAfterDefence = this.getSkillDamage() - (int)(target.getGladiatorStatisticsClass().getStatistic(GladiatorStatistic.Defence)/4);
        SkillEffect skillEffect = new SkillEffect(this.owner, damageAfterDefence, this.getSkillHeal(), this.getStatisticBoost(), this.getBoostedStatistics(), this.getIsSelfDamage(), this.getName(), target);
        return skillEffect;
    }


    public GladiatorStatistic getStatisticMultiper()
    {
        return this.statisticMultiper;
    }

    abstract public int getSkillDamage();
    abstract public int getSkillHeal();
    abstract public int getStatisticBoost();
    abstract public GladiatorStatistic getBoostedStatistics();
    abstract public boolean getIsSelfDamage();


    abstract public Skill getNewInstance();
    abstract public int getCost();

}
