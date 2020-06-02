package Model.Skills.Effect;

import Model.Gladiator.GladiatorStatistic;
import Model.Skills.Skill;



//Class representing skill effect to calculate turn result
public class SkillEffect {
    int damage; //Damage dealt
    int heal;   //Damage healed

    int statisticBoost; //Amount of statistic boost
    GladiatorStatistic gladiatorStatistic; //Statistic that will be boosted

    boolean isSelfDamage; //Is damage dealt is assigned to caster (for example some berserker skills)

    public SkillEffect(int damage, int heal, int statisticBoost, GladiatorStatistic gladiatorStatistic, boolean isSelfDamage )
    {
        this.damage = damage;
        this.heal = heal;
        this.statisticBoost = statisticBoost;
        this.gladiatorStatistic = gladiatorStatistic;
        this.isSelfDamage = isSelfDamage;
    }

    public SkillEffect(int damage, int heal, int statisticBoost, GladiatorStatistic gladiatorStatistic)
    {
        this.damage = damage;
        this.heal = heal;
        this.statisticBoost = statisticBoost;
        this.gladiatorStatistic = gladiatorStatistic;
        this.isSelfDamage = false;
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




}
