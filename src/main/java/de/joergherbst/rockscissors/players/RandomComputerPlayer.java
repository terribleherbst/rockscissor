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

    private List<Tile> possibilities;

    public RandomComputerPlayer(GameConfiguration configuration) {
        GameConfiguration configuration1 = configuration;
        this.possibilities = configuration.getTiles().stream().map(Tile::new).collect(Collectors.toList());
    }

    public Tile choose() {
        return chooseEachTileEqualPropability();
    }

    private Tile chooseEachTileEqualPropability() {
        ThreadLocalRandom random = ThreadLocalRandom.current();
        int selection = random.nextInt(possibilities.size());
        return possibilities.get(selection);
    }
}
