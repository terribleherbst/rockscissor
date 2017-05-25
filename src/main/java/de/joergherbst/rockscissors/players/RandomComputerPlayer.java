package de.joergherbst.rockscissors.players;

import de.joergherbst.rockscissors.GameConfiguration;
import de.joergherbst.rockscissors.Player;
import de.joergherbst.rockscissors.Tile;
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
