package nz.ac.auckland.se281;

import java.util.ArrayList;
import java.util.List;
import nz.ac.auckland.se281.Main.Choice;

public class TopStrategy implements Strategy {
  // pick the most frequent choice's counter

  // Define a history int list where 1 = odd, 2 = even
  List<Integer> history = new ArrayList<Integer>();

  public int getAction(Choice aiWin) {
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
      return (aiWin.equals(Choice.EVEN)) ? Utils.getRandomEvenNumber() : Utils.getRandomOddNumber();
    } else {
      return (aiWin.equals(Choice.ODD)) ? Utils.getRandomEvenNumber() : Utils.getRandomOddNumber();
    }
  }

  public void importHistory(List<Integer> history) {
    this.history = history;
  }
}
