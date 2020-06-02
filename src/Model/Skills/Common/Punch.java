package Model.Skills.Common;

import Model.Gladiator.Gladiator;
import Model.Gladiator.GladiatorStatistic;
import Model.Skills.Effect.SkillEffect;

public class Punch extends CommonSkill {

    public Punch(Gladiator owner)
    {
        super(owner, GladiatorStatistic.Strength);
    }

    @Override
    public String getName() {
        return "Punch";
    }

    @Override
    public String getDescription() {
        return "Punch enemy";
    }


    public SkillEffect useSkill(Gladiator target)
    {
        return new SkillEffect(); //TODO: implement Skill effect
        //SkillEffect skillEffect = new SkillEffect()
    }
}
