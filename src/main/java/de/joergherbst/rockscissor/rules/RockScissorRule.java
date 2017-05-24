package de.joergherbst.rockscissor.rules;

import de.joergherbst.rockscissor.Tile;
import org.easyrules.core.BasicRule;

import java.util.Optional;

public abstract class RockScissorRule extends BasicRule {

    protected Tile firstPlayerSelection;
    protected Tile seconPlayerSelection;
    private Optional<Boolean> won = Optional.empty();

    public RockScissorRule setTiles(Tile firstPlayerSelection, Tile seconPlayerSelection) {
        this.firstPlayerSelection = firstPlayerSelection;
        this.seconPlayerSelection = seconPlayerSelection;
        return this;
    }

    public abstract String getName();

    public String getDescription() {
        return getName();
    }

    public int getPriority() {
        return 0;
    }

    public void execute() throws Exception {
        won = Optional.of(Boolean.TRUE);
    }

    public Optional<Boolean> getWon() {
        return won;
    }
}
