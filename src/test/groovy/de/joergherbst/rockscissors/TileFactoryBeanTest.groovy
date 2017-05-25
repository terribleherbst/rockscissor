package de.joergherbst.rockscissors

import spock.lang.Specification


class TileFactoryBeanTest extends Specification {
    def "Test Conversion of String to Tile"() {
        given:
            def factory = new TileFactoryBean(new GameConfiguration())
        when:
            def result = factory.convert("Stein")
        then:
            result == Tile.STEIN
    }
}
