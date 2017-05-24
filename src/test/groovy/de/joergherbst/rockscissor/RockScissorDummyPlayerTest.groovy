package de.joergherbst.rockscissor

import org.springframework.beans.factory.annotation.Autowired
import org.springframework.boot.context.embedded.LocalServerPort
import org.springframework.boot.test.context.SpringBootTest
import org.springframework.boot.test.web.client.TestRestTemplate
import org.springframework.context.annotation.Import
import org.springframework.http.HttpStatus
import org.springframework.http.ResponseEntity
import spock.lang.Specification

import static de.joergherbst.rockscissor.GameResult.GameResultCode.DRAW
import static de.joergherbst.rockscissor.GameResult.GameResultCode.LOST

@SpringBootTest(classes = RockScissor.class, webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
@Import([MockedPlayerSpringConfig])
class RockScissorDummyPlayerTest extends Specification {

    @LocalServerPort
    private int port;

    @Autowired
    private TestRestTemplate restTemplate;

    @Autowired
    private Player computerPlayer

    def "Stein und Stein ist unentschieden"() {
        when:
            ResponseEntity<GameResult> entity = restTemplate.getForEntity("http://localhost:${port}/game/?choice=Stein", GameResult.class);

        then:
            1 * computerPlayer.choose() >> Tile.STEIN
            entity.getStatusCode() == HttpStatus.OK
            entity.getBody().getCode() == DRAW
    }

    def "Stein wichelt Papier, Spieler verliert"() {
        when:
            ResponseEntity<GameResult> entity = restTemplate.getForEntity("http://localhost:${port}/game/?choice=Stein", GameResult.class);

        then:
            1 * computerPlayer.choose() >> Tile.PAPIER
            entity.getStatusCode() == HttpStatus.OK
            entity.getBody().getCode() == LOST
    }


}
