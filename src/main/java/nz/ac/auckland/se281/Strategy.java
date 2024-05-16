package nz.ac.auckland.se281;

import java.util.List;
import nz.ac.auckland.se281.Main.Choice;

/**
 * This interface implements the base frame for playing strategies for the bot
 * to follow.
 */
public interface Strategy {
  /**
   * Returns the given finger amount that the AI will play.
   * This is based on the type of Strategy used.
   * This result is based off of what the aiWin condition is.
   * 
   * @param botWin condition needed for the ai to win
   * @return int this is the number of fingers that the AI will play
   */
  public int getAction(Choice botWin);

  /**
   * Imports the history into the strategy.
   * This is to account for the previous human plays when doing the top strategy.
   * 
   * @param history the array list accounting for if the player played ODD or EVEN
   *                fingers
   */
  public void importHistory(List<Integer> history);
}