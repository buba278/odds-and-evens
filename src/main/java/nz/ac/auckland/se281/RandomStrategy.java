package nz.ac.auckland.se281;

import java.util.List;

import nz.ac.auckland.se281.Main.Choice;

/** This class sets up the random strategy for bots to act on. */
public class RandomStrategy implements Strategy {
  /**
   * Returns the given finger amount that the AI will play.
   * For random strategy this will simply pick an integer from 0 to 5.

   * @param botWin condition needed for the ai to win
   * @return int, this is the number of fingers that the AI will play
   */
  public int getAction(Choice botWin) {
    // ai win condition not important for random
    return Utils.getRandomNumberRange(0, 5);
  }

  /**
   * Imports the history into the strategy.
   * This is to account for the previous human plays when doing the top strategy.
   * For random strategy this method is simply a placeholder for interface
   * compatibility.

   * @param history the array list accounting for if the player played ODD or EVEN
   *                fingers
   */
  public void importHistory(List<Integer> history) {
    // unused for random
  }
}
