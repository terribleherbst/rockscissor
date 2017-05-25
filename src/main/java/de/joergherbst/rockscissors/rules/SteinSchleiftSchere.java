package de.joergherbst.rockscissors.rules;

import de.joergherbst.rockscissors.Tile;
import org.easyrules.api.Rule;

public class SteinSchleiftSchere extends RockScissorsRule implements Rule {

    @Override
    public String getName() {
        return "Stein schleift Schere";
    }

    @Override
    public boolean evaluate() {
        return firstPlayerSelection.equals(Tile.STEIN) && seconPlayerSelection.equals(Tile.SCHERE);
    }

}
