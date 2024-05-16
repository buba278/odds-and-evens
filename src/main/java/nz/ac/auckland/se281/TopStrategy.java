package nz.ac.auckland.se281;

import java.util.ArrayList;
import java.util.List;
import nz.ac.auckland.se281.Main.Choice;

/** This class implements the top strategy for bots to act on. */
public class TopStrategy implements Strategy {
  // pick the most frequent choice's counter

  // Define a history int list where 1 = odd, 2 = even
  // Field
  private List<Integer> history = new ArrayList<Integer>();

  /**
   * Get the action that the strategy decides on playing.
   * This action is made in amount of fingers it will play.
   * Top strategy decides fingers based on countering the most frequent human
   * choice.

   * @param botWin the current win condition for the AI, in relation to human
   *               choice.
   */
  public int getAction(Choice botWin) {
    int odds = 0;
    int evens = 0;

    for (int i : history) {
      if (i == 1) {
        odds++;
      } else {
        evens++;
      }
    }

    if (odds == evens) {
      return Utils.getRandomNumberRange(0, 5);
    } else if (evens > odds) {
      return (botWin.equals(Choice.EVEN)) ? Utils.getRandomEvenNumber() : Utils.getRandomOddNumber();
    } else {
      return (botWin.equals(Choice.ODD)) ? Utils.getRandomEvenNumber() : Utils.getRandomOddNumber();
    }
  }

  /**
   * Imports the history into the strategy.
   * This is to account for the previous human plays when doing the top strategy.

   * @param history the array list accounting for if the player played ODD or
   *                EVEN fingers
   */
  public void importHistory(List<Integer> history) {
    this.history = history;
  }
}
