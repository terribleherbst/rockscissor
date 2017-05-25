package de.joergherbst.rockscissors;

import lombok.Data;
import lombok.NonNull;
import org.springframework.util.StringUtils;

@Data
public class Tile {

    public static final Tile STEIN = new Tile("Stein");
    public static final Tile PAPIER = new Tile("Papier");
    public static final Tile SCHERE = new Tile("Schere");
    public static final Tile BRUNNEN = new Tile("Brunnen");

    String name;

    public Tile() {
    }

    public Tile(@NonNull String name) {
        this.name = StringUtils.capitalize(name.trim());
    }

    @Override
    public String toString() {
        return name;
    }
}
