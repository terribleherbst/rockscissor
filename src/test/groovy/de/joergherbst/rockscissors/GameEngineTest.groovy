package de.joergherbst.rockscissors

import de.joergherbst.rockscissors.rules.PapierDecktBrunnenZu
import de.joergherbst.rockscissors.rules.PapierWickeltStein
import de.joergherbst.rockscissors.rules.SchereSchneidetPapier
import de.joergherbst.rockscissors.rules.SchereUndSteinFallenInBrunnen
import de.joergherbst.rockscissors.rules.SteinSchleiftSchere
import spock.lang.Specification
import spock.lang.Unroll

import static de.joergherbst.rockscissors.GameResult.GameResultCode.*
import static de.joergherbst.rockscissors.Tile.*

class GameEngineTest extends Specification {

    @Unroll
    def "Ergebnis (ohne Brunnen): #firstPlayerSelection gegen #secondPlayerSelection = #result "(
            def firstPlayerSelection, def secondPlayerSelection, def result) {
        given:
            def engine = new GameEngine(new GameConfiguration())
        expect:
            result == engine.playGame(firstPlayerSelection, secondPlayerSelection).getCode()
        where:
            firstPlayerSelection | secondPlayerSelection || result
            STEIN                | SCHERE                || WIN
            SCHERE               | PAPIER                || WIN
            PAPIER               | STEIN                 || WIN
            STEIN                | PAPIER                || LOST
            PAPIER               | SCHERE                || LOST
            PAPIER               | PAPIER                || DRAW
            STEIN                | STEIN                 || DRAW
            SCHERE               | SCHERE                || DRAW
    }

    @Unroll
    def "Ergebnis (mit Brunnen): #firstPlayerSelection gegen #secondPlayerSelection = #result"(
            def firstPlayerSelection, def secondPlayerSelection, def result) {
        given:
            def configuration = new GameConfiguration(
                    rules: [
                            SchereUndSteinFallenInBrunnen.class,
                            PapierWickeltStein.class,
                            SchereSchneidetPapier.class,
                            SteinSchleiftSchere.class,
                            PapierDecktBrunnenZu.class],
                    tiles: [Tile.SCHERE, Tile.STEIN, Tile.PAPIER, Tile.BRUNNEN]
            )
            def engine = new GameEngine(configuration)
        expect:
            result == engine.playGame(firstPlayerSelection, secondPlayerSelection).getCode()
        where:
            firstPlayerSelection | secondPlayerSelection || result
            STEIN                | SCHERE                || WIN
            SCHERE               | PAPIER                || WIN
            PAPIER               | STEIN                 || WIN
            STEIN                | PAPIER                || LOST
            PAPIER               | PAPIER                || DRAW
            STEIN                | STEIN                 || DRAW
            SCHERE               | SCHERE                || DRAW
            BRUNNEN              | SCHERE                || WIN
            BRUNNEN              | STEIN                 || WIN
            BRUNNEN              | PAPIER                || LOST
            BRUNNEN              | BRUNNEN               || DRAW
            SCHERE               | BRUNNEN               || LOST
            STEIN                | BRUNNEN               || LOST
    }
}
