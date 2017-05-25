package de.joergherbst.rockscissors.rules;

import de.joergherbst.rockscissors.Tile;
import org.easyrules.api.Rule;

public class SchereSchneidetPapier extends RockScissorsRule implements Rule {

    @Override
    public String getName() {
        return "Schere schneider Papier";
    }

    @Override
    public boolean evaluate() {
        return firstPlayerSelection.equals(Tile.SCHERE) && seconPlayerSelection.equals(Tile.PAPIER);
    }

}
