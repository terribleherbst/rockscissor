package de.joergherbst.rockscissors.players

import de.joergherbst.rockscissors.GameConfiguration
import de.joergherbst.rockscissors.Tile
import spock.lang.Specification

class RandomComputerPlayerTest extends Specification {
    def "Computer should use Schere in 1/3 of all cases"() {
        given:
            def configuration = new GameConfiguration()
            def player = new RandomComputerPlayer(configuration)
        when:
            int countSchere;
            def total = 1_000_000
            for (int i = 0; i < total; i++) {
                def selectedTile = player.choose()
                def lastTile = new Tile(configuration.getTiles().last())
                def firstSelected = selectedTile == lastTile
                countSchere += firstSelected ? 1 : 0
            }
        then:
            countSchere > total * 0.99 * 1 / 3.0
            countSchere < total * 1.01 * 1 / 3.0
    }
}
