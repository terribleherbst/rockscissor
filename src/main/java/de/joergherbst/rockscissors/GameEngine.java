package de.joergherbst.rockscissors;

import static de.joergherbst.rockscissors.GameResult.GameResultCode.DRAW;
import static de.joergherbst.rockscissors.GameResult.GameResultCode.LOST;
import static de.joergherbst.rockscissors.GameResult.GameResultCode.WIN;

import de.joergherbst.rockscissors.rules.RockScissorsRule;
import lombok.extern.slf4j.Slf4j;
import org.easyrules.api.RulesEngine;
import org.easyrules.core.RulesEngineBuilder;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;
import java.util.stream.Stream;

@Service
@Slf4j
public class GameEngine {

    private final GameConfiguration gameConfiguration;

    public GameEngine(GameConfiguration gameConfiguration) {
        this.gameConfiguration = gameConfiguration;
    }

    public GameResult playGame(Tile humanChoice, Tile computerChoice) {
        if (wonGame(humanChoice, computerChoice).isPresent()) {
            GameResult result = new GameResult(humanChoice, computerChoice, WIN, "Sie haben gewonnen");
            log.info("Human won game {}", result);
            return result;
        }
        if (lostGame(humanChoice, computerChoice).isPresent()) {
            GameResult result = new GameResult(humanChoice, computerChoice, LOST, "Sie haben verloren");
            log.info("Human lost game {}", result);
            return result;
        }
        GameResult result = new GameResult(humanChoice, computerChoice, DRAW, "Unentschieden");
        log.info("Human was draw {}", result);
        return result;
    }

    private Optional<Boolean> lostGame(Tile firstSelection, Tile secondSelection) {
        return wonGame(secondSelection, firstSelection);

    }

    private Optional<Boolean> wonGame(Tile firstSelection, Tile secondSelection) {
        RulesEngine rulesEngine =
            RulesEngineBuilder.aNewRulesEngine()
                .withSkipOnFirstAppliedRule(true)
                .withSilentMode(true)
                .build();

        List<? extends RockScissorsRule> gameRules = createRules()
            .map(rule -> registerRuleInEngine(rulesEngine, rule))
            .map(rule -> rule.setTiles(firstSelection,secondSelection))
            .collect(Collectors.toList());

        rulesEngine.fireRules();

        Optional<Boolean> winner = gameRules
            .stream()
            .map(rule -> rule.getWon())
            .filter(Optional::isPresent)
            .map(result -> result.get())
            .findAny();
        return winner;
    }

    private RockScissorsRule registerRuleInEngine(RulesEngine rulesEngine, RockScissorsRule rule) {
        rulesEngine.registerRule(rule);
        return rule;
    }

    private Stream<? extends RockScissorsRule> createRules() {
        Stream<? extends RockScissorsRule> rules = gameConfiguration.getRules()
            .stream()
            .map(clazz -> createPrototype(clazz));
        return rules;
    }

    private RockScissorsRule createPrototype(Class<? extends RockScissorsRule> clazz) {
        try {
            return clazz.newInstance();
        } catch (InstantiationException | IllegalAccessException e) {
            throw new RuntimeException("Could not create instance for " + clazz, e);
        }
    }

}
