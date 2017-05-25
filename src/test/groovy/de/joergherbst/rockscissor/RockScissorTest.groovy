package de.joergherbst.rockscissor

import org.springframework.beans.factory.annotation.Autowired
import org.springframework.boot.context.embedded.LocalServerPort
import org.springframework.boot.test.context.SpringBootTest
import org.springframework.boot.test.web.client.TestRestTemplate
import org.springframework.http.HttpStatus
import org.springframework.http.ResponseEntity
import spock.lang.Specification
import spock.lang.Timeout

import java.util.concurrent.TimeUnit

@SpringBootTest(classes = RockScissor.class, webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
class RockScissorTest extends Specification {

    @LocalServerPort
    private int port;

    @Autowired
    private TestRestTemplate restTemplate;

    @Autowired
    private Player defaultComputerPlayer


    def "Eine Anfrage ohne Paramter sollte Status HttpStatus.BAD_REQUEST zurück geben"() {
        when:
            ResponseEntity<Map> entity = restTemplate.getForEntity("http://localhost:${port}/game", Map.class);

        then:
            entity.getStatusCode() == HttpStatus.BAD_REQUEST
    }

    def "Eine Anfrage mit falschem Paramter sollte Status HttpStatus.BAD_REQUEST zurück geben"() {
        when:
            ResponseEntity<GameResult> entity = restTemplate.getForEntity("http://localhost:${port}/game/?choice=Echse", GameResult.class);

        then:
            entity.getStatusCode() == HttpStatus.BAD_REQUEST
            entity.getBody()
    }

    def "Eine Anfrage mit Paramter sollte Status HttpStatus.OK zurück geben"() {
        when:
            ResponseEntity<GameResult> entity = restTemplate.getForEntity("http://localhost:${port}/game/?choice=Stein", GameResult.class);

        then:
            entity.getStatusCode() == HttpStatus.OK
            entity.getBody()
    }

    @Timeout(value = 2000, unit = TimeUnit.MILLISECONDS)
    def "Each request should respond in less than 20ms"() {
        when:
            for (int i = 0; i < 100; i++) {
                ResponseEntity<GameResult> entity = restTemplate.getForEntity("http://localhost:${port}/game/?choice=Stein", GameResult.class);
            }

        then:

            noExceptionThrown()
    }
}
