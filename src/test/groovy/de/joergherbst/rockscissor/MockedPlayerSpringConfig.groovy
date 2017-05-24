package de.joergherbst.rockscissor

import de.joergherbst.rockscissor.Player
import org.springframework.context.annotation.Bean
import org.springframework.context.annotation.Primary
import spock.mock.DetachedMockFactory


class MockedPlayerSpringConfig {
    private DetachedMockFactory factory = new DetachedMockFactory()

    @Bean
    @Primary
    Player mockPlayer() {
        factory.Mock(Player)
    }
}
