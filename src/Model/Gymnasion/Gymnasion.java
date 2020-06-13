package Model.Gymnasion;

import Model.Gladiator.Gladiator;
import Model.Skills.Arcane.SiphonLife;
import Model.Skills.Common.Punch;
import Model.Skills.Physical.FrenzyStrike;
import Model.Skills.Skill;

import java.util.ArrayList;

public class Gymnasion {
    ArrayList<Skill> skillsToLearn;

    public Gymnasion()
    {
        skillsToLearn = new ArrayList<Skill>();
        populateSkillList();
    }

    private void populateSkillList()
    {
        skillsToLearn.add(new Punch(null));
        skillsToLearn.add(new FrenzyStrike(null));
        skillsToLearn.add(new SiphonLife(null));
    }

    public ArrayList<Skill> getSkillsToLearn()
    {
        return this.skillsToLearn;
    }

    public boolean trainSkill(Gladiator gladiator, int skillIndex)
    {
        if(gladiator.addSkill(skillsToLearn.get(skillIndex)))
        {
            skillsToLearn.set(skillIndex, skillsToLearn.get(skillIndex).getNewInstance());
            return true;
        }

        return false;
    }

}
