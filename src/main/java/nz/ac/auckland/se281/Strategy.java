package nz.ac.auckland.se281;

import java.util.List;
import nz.ac.auckland.se281.Main.Choice;

public interface Strategy {
  /**
   * Returns the given finger amount that the AI will play. 
   * This is based on the type of Strategy used.
   * This result is based off of what the aiWin condition is.
   * 
   * @param aiWin condition needed for the ai to win
   * @return int, this is the number of fingers that the AI will play
   */
  public int getAction(Choice aiWin);

  /**
   * Imports the history into the strategy. 
   * This is to account for the previous human plays when doing the top strategy.
   * 
   * @param history, the array list accounting for if the player played ODD or EVEN fingers
   */
  public void importHistory(List<Integer> history);
}