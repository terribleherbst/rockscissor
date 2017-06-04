package de.joergherbst.rockscissors.rules;

import static de.joergherbst.rockscissors.Tile.SCHERE;
import static de.joergherbst.rockscissors.Tile.STEIN;

import org.jeasy.rules.api.Facts;
import org.jeasy.rules.api.Rule;

public class SteinSchleiftSchere extends RockScissorsRule implements Rule {

    public SteinSchleiftSchere() {
        super("Stein schleift Schere");
    }

    @Override
    public boolean evaluate(Facts facts) {
        return STEIN.equals(facts.get("FIRST_PLAYER_SELECTION")) && SCHERE.equals(facts.get("SECOND_PLAYER_SELECTION"));
    }

}
