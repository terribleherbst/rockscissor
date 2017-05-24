package de.joergherbst.rockscissor.rules;

import de.joergherbst.rockscissor.Tile;
import org.easyrules.api.Rule;

public class PapierDecktBrunnenZu extends RockScissorRule implements Rule {

    @Override
    public String getName() {
        return "Papier deckt Brunnen zu";
    }

    @Override
    public boolean evaluate() {
        return firstPlayerSelection.equals(Tile.PAPIER) && seconPlayerSelection.equals(Tile.BRUNNEN);
    }

}
