package de.joergherbst.rockscissors.rules;

import static de.joergherbst.rockscissors.Tile.PAPIER;
import static de.joergherbst.rockscissors.Tile.STEIN;

import org.jeasy.rules.api.Facts;
import org.jeasy.rules.api.Rule;

public class PapierWickeltStein extends RockScissorsRule implements Rule {

    public PapierWickeltStein() {
        super("Papier wickelt Stein");
    }

    @Override
    public boolean evaluate(Facts facts) {
        return PAPIER.equals(facts.get("FIRST_PLAYER_SELECTION")) && STEIN.equals(facts.get("SECOND_PLAYER_SELECTION"));
    }
}
