package Model.Skills.Effect;

import Model.Gladiator.Gladiator;
import Model.Gladiator.GladiatorStatistic;



//Class representing skill effect to calculate turn result
public class SkillEffect {
    int damage; //Damage dealt
    int heal;   //Damage healed

    int statisticBoost; //Amount of statistic boost
    GladiatorStatistic gladiatorStatistic; //Statistic that will be boosted

    boolean isSelfDamage; //Is damage dealt is assigned to caster (for example some berserker skills)

    String sourceSkillName;

    Gladiator target;
    Gladiator owner;

    public SkillEffect()
    {

    }

    public SkillEffect(Gladiator owner, int damage, int heal, int statisticBoost, GladiatorStatistic gladiatorStatistic, boolean isSelfDamage, String sourceSkillName, Gladiator target )
    {
        this.damage = damage;
        this.heal = heal;
        this.statisticBoost = statisticBoost;
        this.gladiatorStatistic = gladiatorStatistic;
        this.isSelfDamage = isSelfDamage;
        this.sourceSkillName = sourceSkillName;
        this.target = target;
        this.owner = owner;
    }

    public SkillEffect(Gladiator owner, int damage, int heal, int statisticBoost, GladiatorStatistic gladiatorStatistic, String sourceSkillName, Gladiator target)
    {
        this.damage = damage;
        this.heal = heal;
        this.statisticBoost = statisticBoost;
        this.gladiatorStatistic = gladiatorStatistic;
        this.isSelfDamage = false;
        this.sourceSkillName = sourceSkillName;
        this.target = target;
        this.owner = owner;
    }

    final public int getDamage()
    {
        return this.damage;
    }

    final public int getHeal()
    {
        return this.heal;
    }

    final public int getStatisticBoost()
    {
        return this.statisticBoost;
    }

    final public GladiatorStatistic getGladiatorStatistic()
    {
        return this.gladiatorStatistic;
    }

    final public boolean isSelfDamage()
    {
        return this.isSelfDamage;
    }

    final public Gladiator getTarget()
    {
        return this.target;
    }

    final public Gladiator getOwner()
    {
        return this.owner;
    }

}
