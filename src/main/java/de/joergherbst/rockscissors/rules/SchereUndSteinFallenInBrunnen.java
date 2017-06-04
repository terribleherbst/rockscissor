package de.joergherbst.rockscissors.rules;

import static de.joergherbst.rockscissors.Tile.BRUNNEN;
import static de.joergherbst.rockscissors.Tile.SCHERE;
import static de.joergherbst.rockscissors.Tile.STEIN;

import org.jeasy.rules.api.Facts;
import org.jeasy.rules.api.Rule;

public class SchereUndSteinFallenInBrunnen extends RockScissorsRule implements Rule {

    public SchereUndSteinFallenInBrunnen() {
        super("Das Ding fällt in den Brunnen wenn es nicht Papier ist");
    }

    @Override
    public boolean evaluate(Facts facts) {
        return BRUNNEN.equals(facts.get("FIRST_PLAYER_SELECTION"))
            && (SCHERE.equals(facts.get("SECOND_PLAYER_SELECTION")) || STEIN.equals(facts.get("SECOND_PLAYER_SELECTION")));
    }

}
