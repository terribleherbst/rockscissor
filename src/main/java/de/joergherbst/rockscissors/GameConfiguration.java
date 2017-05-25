package de.joergherbst.rockscissors;

import static de.joergherbst.rockscissors.Tile.PAPIER;
import static de.joergherbst.rockscissors.Tile.SCHERE;
import static de.joergherbst.rockscissors.Tile.STEIN;

import de.joergherbst.rockscissors.rules.PapierWickeltStein;
import de.joergherbst.rockscissors.rules.RockScissorsRule;
import de.joergherbst.rockscissors.rules.SchereSchneidetPapier;
import de.joergherbst.rockscissors.rules.SteinSchleiftSchere;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.Configuration;

import java.util.Arrays;
import java.util.List;

@Configuration
@ConfigurationProperties(prefix = "game")
public class GameConfiguration {

    /**
     * A List of all Tile which are used in this games
     */
    private List<String> tiles = Arrays.asList(PAPIER.getName(), SCHERE.getName(), STEIN.getName());

    /**
     * A List of all rules which are defined in this games
     */
    private List<Class<? extends RockScissorsRule>> rules = Arrays.asList(
        PapierWickeltStein.class, SchereSchneidetPapier.class, SteinSchleiftSchere.class);

    public List<String> getTiles() {
        return tiles;
    }

    public List<Class<? extends RockScissorsRule>> getRules() {
        return rules;
    }

    public void setRules(List<Class<? extends RockScissorsRule>> rules) {
        this.rules = rules;
    }

    public void setTiles(List<String> tiles) {
        this.tiles = tiles;
    }

}
