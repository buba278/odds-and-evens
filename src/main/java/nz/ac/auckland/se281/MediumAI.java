package nz.ac.auckland.se281;

public class MediumAI implements AI {
  Strategy strategy;

  @Override
  public void setStrategy(Strategy strategy) {
    this.strategy = strategy;
  }
  public int play() {
    return strategy.getAction(null);
  }
}
