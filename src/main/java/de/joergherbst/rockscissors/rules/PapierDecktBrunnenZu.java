package de.joergherbst.rockscissors.rules;

import de.joergherbst.rockscissors.Tile;
import org.easyrules.api.Rule;

public class PapierDecktBrunnenZu extends RockScissorsRule implements Rule {

    @Override
    public String getName() {
        return "Papier deckt Brunnen zu";
    }

    @Override
    public boolean evaluate() {
        return firstPlayerSelection.equals(Tile.PAPIER) && seconPlayerSelection.equals(Tile.BRUNNEN);
    }

}
