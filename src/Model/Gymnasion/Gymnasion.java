package Model.Gymnasion;

import Model.Gladiator.Gladiator;
import Model.Skills.Agile.AgileSlash;
import Model.Skills.Agile.ArcherFocus;
import Model.Skills.Agile.AssassinStrike;
import Model.Skills.Agile.EquilibristicDance;
import Model.Skills.Arcane.ArchontStrike;
import Model.Skills.Arcane.GranIllusion;
import Model.Skills.Arcane.MindWreck;
import Model.Skills.Arcane.SiphonLife;
import Model.Skills.Common.Punch;
import Model.Skills.Physical.DiamondArmor;
import Model.Skills.Physical.DuelistFineness;
import Model.Skills.Physical.FrenzyStrike;
import Model.Skills.Physical.LunaticRush;
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
        skillsToLearn.add(new GranIllusion(null));
        skillsToLearn.add(new ArchontStrike(null));
        skillsToLearn.add(new MindWreck(null));
        skillsToLearn.add(new AgileSlash(null));
        skillsToLearn.add(new ArcherFocus(null));
        skillsToLearn.add(new AssassinStrike(null));
        skillsToLearn.add(new EquilibristicDance(null));
        skillsToLearn.add(new DiamondArmor(null));
        skillsToLearn.add(new DuelistFineness(null));
        skillsToLearn.add(new LunaticRush(null));
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
