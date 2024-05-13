package nz.ac.auckland.se281;

import java.util.List;
import nz.ac.auckland.se281.Main.Choice;

public class HardAI implements AI {
  private Strategy strategy = new RandomStrategy();
  private int lastResult = 0;
  private int lastAIPlay = 0;

  @Override
  public void setStrategy(Strategy strategy) {
    this.strategy = strategy;
  }

  public int play(Choice aiWin, List<Integer> history) {
    boolean lastWin;

    // get last history human play 
    // sum  
    lastResult = history.get(history.size() - 1) + lastAIPlay;

    if (history.size() > 3) {
      strategy.importHistory(history);
      if (Utils.isEven(lastResult) && aiWin.equals(Choice.EVEN)) {
        lastWin = true;
      }
      else if (Utils.isOdd(lastResult) && aiWin.equals(Choice.ODD)) {
        lastWin = true;
      }
      else {
        lastWin = false;
      }

      if (!lastWin & (strategy.getClass()).equals(RandomStrategy.class)) {
        setStrategy(new TopStrategy());
        strategy.importHistory(history);
      }
      else if (!lastWin & (strategy.getClass()).equals(TopStrategy.class)) {
        setStrategy(new RandomStrategy());
      }
    }

    lastAIPlay = strategy.getAction(aiWin);
    return lastAIPlay;
  }
}
