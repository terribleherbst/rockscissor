package de.joergherbst.rockscissors.rules;

import org.jeasy.rules.api.Facts;
import org.jeasy.rules.core.BasicRule;

public abstract class RockScissorsRule extends BasicRule {

    public RockScissorsRule(String name) {
        super(name);
    }

    public String getDescription() {
        return getName();
    }

    @Override
    public void execute(Facts facts) throws Exception {
        facts.put("GAME_RESULT", "FIRST_WON");
    }

    public int getPriority() {
        return 0;
    }
}
