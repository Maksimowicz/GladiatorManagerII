package Model.Arenas.Rules.RulesFactory;

import Model.Arenas.Rules.ArenaRules;
import Model.Arenas.Rules.BiggestHitRules;
import Model.Arenas.Rules.DamageRules;
import Model.Arenas.Rules.HealRules;
import Model.Arenas.Rules.RulesEnum.ArenaRulesEnum;

public class RulesFactory {

    private RulesFactory()
    {

    }

    public static ArenaRules constructArenaRules(ArenaRulesEnum arenaRulesEnum)
    {
        switch (arenaRulesEnum)
        {
            case Damage:
                return new DamageRules();
            case Heal:
                return new HealRules();
            case BiggestHit:
                return new BiggestHitRules();

        }

        return null;
    }
}
