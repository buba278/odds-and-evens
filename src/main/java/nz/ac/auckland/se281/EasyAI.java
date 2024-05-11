package nz.ac.auckland.se281;

public class EasyAI implements AI {
  Strategy strategy = new RandomStrategy();

  @Override
  public void setStrategy(Strategy strategy) {
    // unused for EasyAI
  }
  public int play() {
    return strategy.getAction();
  }
}
