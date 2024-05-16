package nz.ac.auckland.se281;

import java.util.List;
import nz.ac.auckland.se281.Main.Choice;

public class HardBot implements Bot {

  // Fields
  private Strategy strategy = new RandomStrategy();
  private int lastResult = 0;
  private int lastAIPlay = 0;

  /**
   * This sets the current strategy being used by the HardAI.
   * This will determine how the HardAI will make its decisions.
   * 
   * @param strategy, the current strategy being used by the ai to play its moves.
   */
  @Override
  public void setStrategy(Strategy strategy) {
    this.strategy = strategy;
  }

  /**
   * Play the AI's move as in provide the amount of fingers it will play on its turn.
   * 
   * @param aiWin, the win condition for the ai so it can make its decisions
   * @param history, array list of all the previous moves the human made and its "choice"
   * @return int, it will return the given fingers that the ai will play
   */
  public int play(Choice aiWin, List<Integer> history) {
    boolean lastWin;

    // get last history human play
    // sum
    lastResult = history.get(history.size() - 1) + lastAIPlay;

    if (history.size() > 3) {
      strategy.importHistory(history);
      if (Utils.isEven(lastResult) && aiWin.equals(Choice.EVEN)) {
        lastWin = true;
      } else if (Utils.isOdd(lastResult) && aiWin.equals(Choice.ODD)) {
        lastWin = true;
      } else {
        lastWin = false;
      }

      if (!lastWin & (strategy.getClass()).equals(RandomStrategy.class)) {
        setStrategy(new TopStrategy());
        strategy.importHistory(history);
      } else if (!lastWin & (strategy.getClass()).equals(TopStrategy.class)) {
        setStrategy(new RandomStrategy());
      }
    }

    lastAIPlay = strategy.getAction(aiWin);
    return lastAIPlay;
  }
}
