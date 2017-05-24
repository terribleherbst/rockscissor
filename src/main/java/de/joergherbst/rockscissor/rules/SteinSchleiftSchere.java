package de.joergherbst.rockscissor.rules;

import de.joergherbst.rockscissor.Tile;
import org.easyrules.api.Rule;

public class SteinSchleiftSchere extends RockScissorRule implements Rule {

    @Override
    public String getName() {
        return "Stein schleift Schere";
    }

    @Override
    public boolean evaluate() {
        return firstPlayerSelection.equals(Tile.STEIN) && seconPlayerSelection.equals(Tile.SCHERE);
    }

}
