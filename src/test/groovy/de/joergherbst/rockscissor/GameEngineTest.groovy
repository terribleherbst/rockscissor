package de.joergherbst.rockscissor

import de.joergherbst.rockscissor.rules.AllesAusserPapierFaelltInBrunnen
import de.joergherbst.rockscissor.rules.PapierDecktBrunnenZu
import de.joergherbst.rockscissor.rules.PapierWickeltStein
import de.joergherbst.rockscissor.rules.SchereSchneidetPapier
import de.joergherbst.rockscissor.rules.SteinSchleiftSchere
import spock.lang.Specification
import spock.lang.Unroll

import static de.joergherbst.rockscissor.GameResult.GameResultCode.*
import static de.joergherbst.rockscissor.Tile.*

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
                            AllesAusserPapierFaelltInBrunnen.class,
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
