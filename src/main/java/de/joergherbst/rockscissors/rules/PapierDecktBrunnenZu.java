package de.joergherbst.rockscissors.rules;

import static de.joergherbst.rockscissors.Tile.BRUNNEN;
import static de.joergherbst.rockscissors.Tile.PAPIER;

import org.jeasy.rules.api.Facts;
import org.jeasy.rules.api.Rule;

public class PapierDecktBrunnenZu extends RockScissorsRule implements Rule {

    public PapierDecktBrunnenZu() {
        super("Papier deckt Brunnen zu");
    }

    @Override
    public boolean evaluate(Facts facts) {
        return PAPIER.equals(facts.get("FIRST_PLAYER_SELECTION")) && BRUNNEN.equals(facts.get("SECOND_PLAYER_SELECTION"));
    }

}
