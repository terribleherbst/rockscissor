package de.joergherbst.rockscissors.rules;

import static de.joergherbst.rockscissors.Tile.BRUNNEN;
import static de.joergherbst.rockscissors.Tile.SCHERE;
import static de.joergherbst.rockscissors.Tile.STEIN;

import org.easyrules.api.Rule;

import java.util.Objects;

public class SchereUndSteinFallenInBrunnen extends RockScissorsRule implements Rule {

    @Override
    public String getName() {
        return "Das Ding fällt in den Brunnen wenn es nicht Papier ist";
    }

    @Override
    public boolean evaluate() {
        return firstPlayerSelection.equals(BRUNNEN)
            && (Objects.equals(seconPlayerSelection, SCHERE) || Objects.equals(seconPlayerSelection, STEIN));
    }

}
