package de.joergherbst.rockscissors

import de.joergherbst.rockscissors.rules.PapierWickeltStein
import de.joergherbst.rockscissors.rules.SchereSchneidetPapier
import de.joergherbst.rockscissors.rules.SteinSchleiftSchere
import spock.lang.Specification

import static de.joergherbst.rockscissors.Tile.PAPIER
import static de.joergherbst.rockscissors.Tile.SCHERE
import static de.joergherbst.rockscissors.Tile.STEIN


class GameConfigurationTest extends Specification {
    def "Test configuration has the default game rules"() {
        when:
            def defaultConfig = new GameConfiguration()
        then:
            defaultConfig.getTiles() as Set == [STEIN.getName(), PAPIER.getName(), SCHERE.getName()] as Set
            defaultConfig.getRules() as Set == [SteinSchleiftSchere.class, SchereSchneidetPapier.class, PapierWickeltStein.class] as Set


    }
}
