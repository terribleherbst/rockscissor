package de.joergherbst.rockscissor.players;

import de.joergherbst.rockscissor.GameConfiguration;
import de.joergherbst.rockscissor.Player;
import de.joergherbst.rockscissor.Tile;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.concurrent.ThreadLocalRandom;
import java.util.stream.Collectors;

@Component
public class RandomComputerPlayer implements Player {

    private final GameConfiguration configuration;

    private List<Tile> possibilities;

    public RandomComputerPlayer(GameConfiguration configuration) {
        this.configuration = configuration;
        this.possibilities = configuration.getTiles().stream().map(Tile::new).collect(Collectors.toList());
    }

    public Tile choose() {
        return chooseEachTIleEqualPropability();
    }

    private Tile chooseEachTIleEqualPropability() {
        return possibilities.get(ThreadLocalRandom.current().nextInt(possibilities.size()));
    }
}
