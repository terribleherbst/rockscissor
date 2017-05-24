package de.joergherbst.rockscissor.rules;

import static de.joergherbst.rockscissor.Tile.BRUNNEN;
import static de.joergherbst.rockscissor.Tile.PAPIER;

import org.easyrules.api.Rule;

import java.util.Objects;

public class AllesAusserPapierFaelltInBrunnen extends RockScissorRule implements Rule {

    @Override
    public String getName() {
        return "Das Ding fällt in den Brunnen wenn es nicht Papier ist";
    }

    @Override
    public boolean evaluate() {
        return firstPlayerSelection.equals(BRUNNEN)
            && !Objects.equals(seconPlayerSelection, BRUNNEN)
            && !Objects.equals(seconPlayerSelection, PAPIER);
    }

}
