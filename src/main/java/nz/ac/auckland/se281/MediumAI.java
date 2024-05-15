package nz.ac.auckland.se281;

import java.util.List;
import nz.ac.auckland.se281.Main.Choice;

public class MediumAI implements AI {
  private Strategy strategy = new RandomStrategy();

  @Override
  public void setStrategy(Strategy strategy) {
    this.strategy = strategy;
  }
  public int play(Choice choice, List<Integer> history) {
    if (history.size() == 4) { // if it passes the 3rd call + only need to do once
      setStrategy(new TopStrategy());
    }
    if (history.size() > 3) {
      strategy.importHistory(history);
    }
    return strategy.getAction(choice);
  }
}
