package de.joergherbst.rockscissors;

import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.NonNull;

@Data
@NoArgsConstructor
public final class GameResult {

    enum GameResultCode { LOST, DRAW, WIN }

    private Tile firstChoice;

    private Tile secondChoice;

    private GameResultCode code;

    private String message;

    public GameResult(@NonNull Tile firstChoice, @NonNull Tile secondChoice, @NonNull GameResultCode code, String message) {
        this.firstChoice = firstChoice;
        this.secondChoice = secondChoice;
        this.code = code;
        this.message = message;
    }
}

