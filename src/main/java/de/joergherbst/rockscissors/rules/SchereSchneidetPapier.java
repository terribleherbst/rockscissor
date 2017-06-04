package de.joergherbst.rockscissors.rules;

import static de.joergherbst.rockscissors.Tile.PAPIER;
import static de.joergherbst.rockscissors.Tile.SCHERE;

import org.jeasy.rules.api.Facts;
import org.jeasy.rules.api.Rule;

public class SchereSchneidetPapier extends RockScissorsRule implements Rule {

    public SchereSchneidetPapier() {
        super("Schere schneider Papier");
    }

    @Override
    public boolean evaluate(Facts facts) {
        return SCHERE.equals(facts.get("FIRST_PLAYER_SELECTION")) && PAPIER.equals(facts.get("SECOND_PLAYER_SELECTION"));
    }

}
