package Model.Skills;

import Model.Classes.GladiatorClass;
import Model.Gladiator.Gladiator;
import Model.Races.Race;
import Model.Skills.Effect.SkillEffect;
import Model.Weapons.Weapon;

public abstract class Skill {

    Gladiator caster; //Caller of the spell
    Gladiator target; //Target of spell. can be same as caster

    abstract public String getName(); //Returns name of skill
    abstract public boolean canBeLearned(GladiatorClass gladiatorClass, Race race); //Indicated who can use skill
    abstract public String getWhoCanLearn(); //Gets string version of classes that can learn skill
    abstract public String getDescription(); //Gets description of the skill
    abstract SkillEffect useSkill(Weapon weapon); //uses skill

}
