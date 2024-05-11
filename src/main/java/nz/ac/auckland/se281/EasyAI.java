package nz.ac.auckland.se281;

public class EasyAI implements AI {
  Strategy strategy;

  @Override
  public void setStrategy(Strategy strategy) {
    this.strategy = strategy;
  }
}
