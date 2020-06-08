package Model.Skills;

import Model.Classes.GladiatorClass;
import Model.Gladiator.Gladiator;
import Model.Gladiator.GladiatorStatistic;
import Model.Races.Race;
import Model.Skills.Effect.SkillEffect;

public abstract class Skill {

    final protected Gladiator owner; //Caller of the spell

    final protected GladiatorStatistic statisticMultiper;

    //Cretion of specific use of specific skill skill
    protected Skill(Gladiator owner, GladiatorStatistic statisticMultiper)
    {
        this.owner = owner;
        this.statisticMultiper = statisticMultiper;

    }

    abstract public String getName(); //Returns name of skill
    abstract public boolean canBeLearned(GladiatorClass gladiatorClass, Race race); //Indicated who can use skill
    abstract public String getWhoCanLearn(); //Gets string version of classes that can learn skill
    abstract public String getDescription(); //Gets description of the skill

    public SkillEffect useSkill(Gladiator target) //uses skill
    {
        SkillEffect skillEffect = new SkillEffect(this.owner, this.getSkillDamage(), this.getSkillHeal(), this.getStatisticBoost(), this.getBoostedStatistics(), this.getIsSelfDamage(), this.getName(), target);
        return skillEffect;
    }

    abstract protected int getSkillDamage();
    abstract protected int getSkillHeal();
    abstract protected int getStatisticBoost();
    abstract protected GladiatorStatistic getBoostedStatistics();
    abstract protected boolean getIsSelfDamage();

}
