package de.joergherbst.rockscissor

import de.joergherbst.rockscissor.GameConfiguration
import de.joergherbst.rockscissor.Tile
import de.joergherbst.rockscissor.TileFactoryBean
import spock.lang.Specification


class TileFactoryBeanTest extends Specification {
    def "test convert"() {
        given:
            def factory = new TileFactoryBean(new GameConfiguration())
        when:
            def result = factory.convert("Stein")
        then:
            result == Tile.STEIN
    }
}
