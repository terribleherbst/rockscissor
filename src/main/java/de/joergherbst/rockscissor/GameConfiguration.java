package de.joergherbst.rockscissor;

import static de.joergherbst.rockscissor.Tile.PAPIER;
import static de.joergherbst.rockscissor.Tile.SCHERE;
import static de.joergherbst.rockscissor.Tile.STEIN;

import de.joergherbst.rockscissor.rules.PapierWickeltStein;
import de.joergherbst.rockscissor.rules.RockScissorRule;
import de.joergherbst.rockscissor.rules.SchereSchneidetPapier;
import de.joergherbst.rockscissor.rules.SteinSchleiftSchere;
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
    private List<Class<? extends RockScissorRule>> rules = Arrays.asList(
        PapierWickeltStein.class, SchereSchneidetPapier.class, SteinSchleiftSchere.class);

    public List<String> getTiles() {
        return tiles;
    }

    public List<Class<? extends RockScissorRule>> getRules() {
        return rules;
    }

    public void setRules(List<Class<? extends RockScissorRule>> rules) {
        this.rules = rules;
    }

    public void setTiles(List<String> tiles) {
        this.tiles = tiles;
    }

}
