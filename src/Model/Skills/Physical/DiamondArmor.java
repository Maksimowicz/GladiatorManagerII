package Model.Skills.Physical;

import Model.Classes.GladiatorClass;
import Model.Classes.Warriors.Defender;
import Model.Gladiator.Gladiator;
import Model.Gladiator.GladiatorStatistic;
import Model.Races.Race;
import Model.Skills.Effect.SkillEffect;
import Model.Skills.Skill;

public class DiamondArmor extends PhysicalSkill{
    public DiamondArmor(Gladiator owner)
    {
        super(owner, GladiatorStatistic.Defence);
    }


    @Override
    public String getName() {
        return "Diamond armor";
    }

    @Override
    public String getDescription() {
        return "Summon diamond armor and become nearly indestructible.";
    }

    @Override
    public int getSkillDamage() {
        return 0;
    }

    @Override
    public int getSkillHeal() {
        return 0;
    }

    @Override
    public int getStatisticBoost() {
        return 80;
    }

    @Override
    public GladiatorStatistic getBoostedStatistics() {
        return GladiatorStatistic.Defence;
    }

    @Override
    public boolean getIsSelfDamage() {
        return false;
    }

    @Override
    public Skill getNewInstance() {
        return new DiamondArmor(null);
    }

    @Override
    public int getCost() {
        return 1850;
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
        return "Defender";
    }

    @Override
    public boolean canBeLearned(GladiatorClass gladiatorClass, Race race)
    {
        if(gladiatorClass instanceof Defender)
        {
            return true;
        }

        return false;
    }
}
