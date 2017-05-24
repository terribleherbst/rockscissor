package de.joergherbst.rockscissor

import de.joergherbst.rockscissor.rules.PapierWickeltStein
import de.joergherbst.rockscissor.rules.SchereSchneidetPapier
import de.joergherbst.rockscissor.rules.SteinSchleiftSchere
import spock.lang.Specification

import static de.joergherbst.rockscissor.Tile.PAPIER
import static de.joergherbst.rockscissor.Tile.SCHERE
import static de.joergherbst.rockscissor.Tile.STEIN


class GameConfigurationTest extends Specification {
    def "test getTiles"() {
        when:
            def defaultConfig = new GameConfiguration()
        then:
            defaultConfig.getTiles() as Set == [STEIN.getName(), PAPIER.getName(), SCHERE.getName()] as Set
            defaultConfig.getRules() as Set == [SteinSchleiftSchere.class, SchereSchneidetPapier.class, PapierWickeltStein.class] as Set


    }
}
