package nz.ac.auckland.se281;

import java.util.List;
import nz.ac.auckland.se281.Main.Choice;

public class EasyAI implements AI {
  Strategy strategy = new RandomStrategy();

  @Override
  public void setStrategy(Strategy strategy) {
    // unused for EasyAI
  }
  public int play(Choice choice, List<Integer> history) {
    return strategy.getAction(choice);
  }
}
