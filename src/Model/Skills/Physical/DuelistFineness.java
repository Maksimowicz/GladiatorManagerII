package Model.Skills.Physical;

import Model.Classes.GladiatorClass;
import Model.Classes.Warriors.Duelist;
import Model.Gladiator.Gladiator;
import Model.Gladiator.GladiatorStatistic;
import Model.Races.Race;
import Model.Skills.Effect.SkillEffect;
import Model.Skills.Skill;

public class DuelistFineness extends PhysicalSkill{
    public DuelistFineness(Gladiator owner)
    {
        super(owner, GladiatorStatistic.Agility);
    }


    @Override
    public String getName() {
        return "Duelist Fineness";
    }

    @Override
    public String getDescription() {
        return "Deal small, damage, heal, and buff agility";
    }

    @Override
    public int getSkillDamage() {
        return 15;
    }

    @Override
    public int getSkillHeal() {
        return 20;
    }

    @Override
    public int getStatisticBoost() {
        return 25;
    }

    @Override
    public GladiatorStatistic getBoostedStatistics() {
        return GladiatorStatistic.Agility;
    }

    @Override
    public boolean getIsSelfDamage() {
        return false;
    }

    @Override
    public Skill getNewInstance() {
        return new DuelistFineness(null);
    }

    @Override
    public int getCost() {
        return 400;
    }

    @Override
    public SkillEffect useSkill(Gladiator target)
    {
        SkillEffect skillEffect = super.useSkill(target);
        return skillEffect;
    }

    @Override
    public String getWhoCanLearn()
    {
        return "Duelist";
    }

    @Override
    public boolean canBeLearned(GladiatorClass gladiatorClass, Race race)
    {
        if(gladiatorClass instanceof Duelist)
        {
            return true;
        }

        return false;
    }
}
