package de.joergherbst.rockscissor;

import org.springframework.core.convert.converter.Converter;
import org.springframework.stereotype.Component;

@Component
public class TileFactoryBean implements Converter<String, Tile> {

    private final GameConfiguration configuration;

    public TileFactoryBean(GameConfiguration configuration) {
        this.configuration = configuration;
    }

    @Override
    public Tile convert(String name) {
        return configuration.getTiles()
            .stream()
            .filter(tile -> tile.equalsIgnoreCase(name.trim()))
            .map(Tile::new)
            .findAny()
            .orElseThrow(() -> new RuntimeException("No tile " + name + " in current game"));
    }
}

