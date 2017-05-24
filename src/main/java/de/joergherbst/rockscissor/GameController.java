package de.joergherbst.rockscissor;

import lombok.AllArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

@AllArgsConstructor
@Controller
@RequestMapping("/game")
public class GameController {

    final GameEngine gameEngine;

    final Player computerPlayer;

    final GameConfiguration gameConfiguration;

    @GetMapping(produces = "application/json")
    @ResponseBody
    public GameResult play(@RequestParam(value = "choice") Tile human,
                           @RequestParam(value = "forceDecision", required = false, defaultValue = "false") boolean forceDecision) {
        Tile computer = computerPlayer.choose();
        GameResult gameResult = gameEngine.playGame(human, computer);
        while (gameResult.getCode() == GameResult.GameResultCode.DRAW && forceDecision) {
            gameResult = gameEngine.playGame(human, computerPlayer.choose());
        }
        return gameResult;
    }

}