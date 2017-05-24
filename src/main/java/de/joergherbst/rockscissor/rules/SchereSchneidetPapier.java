package de.joergherbst.rockscissor.rules;

import de.joergherbst.rockscissor.Tile;
import org.easyrules.api.Rule;

public class SchereSchneidetPapier extends RockScissorRule implements Rule {

    @Override
    public String getName() {
        return "Schere schneider Papier";
    }

    @Override
    public boolean evaluate() {
        return firstPlayerSelection.equals(Tile.SCHERE) && seconPlayerSelection.equals(Tile.PAPIER);
    }

}
