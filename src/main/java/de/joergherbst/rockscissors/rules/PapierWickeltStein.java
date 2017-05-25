package de.joergherbst.rockscissors.rules;

import de.joergherbst.rockscissors.Tile;
import org.easyrules.api.Rule;

public class PapierWickeltStein extends RockScissorsRule implements Rule {

    @Override
    public String getName() {
        return "Papier wickelt Stein";
    }

    @Override
    public boolean evaluate() {
        return firstPlayerSelection.equals(Tile.PAPIER) && seconPlayerSelection.equals(Tile.STEIN);
    }

}
