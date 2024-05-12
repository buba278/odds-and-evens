package nz.ac.auckland.se281;
import java.util.List;

import nz.ac.auckland.se281.Main.Choice;

public class RandomStrategy implements Strategy {
  // just pick an integer from 0 to 5
  public int getAction(Choice aiWin) {
    // ai win condition not important for random
    return Utils.getRandomNumberRange(0, 5);
  }
  
  public void importHistory(List<Integer> history) {
    // unused for random
  }
}
