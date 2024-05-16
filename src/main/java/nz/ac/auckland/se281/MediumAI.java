package nz.ac.auckland.se281;

import java.util.List;
import nz.ac.auckland.se281.Main.Choice;

public class MediumAI implements AI {
  private Strategy strategy = new RandomStrategy();

  /**
   * This sets the current strategy being used by the MediumAI.
   * This will determine how the MediumAI will make its decisions.
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
   * @param choice, the win condition for the ai so it can make its decisions
   * @param history, array list of all the previous moves the human made and its "choice"
   * @return int, it will return the given fingers that the ai will play
   */
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
