package nz.ac.auckland.se281;

import nz.ac.auckland.se281.Main.Choice;

public class MediumAI implements AI {
  Strategy strategy;

  @Override
  public void setStrategy(Strategy strategy) {
    this.strategy = strategy;
  }
  public int play(Choice choice) {
    return strategy.getAction(choice);
  }
}
