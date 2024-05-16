package nz.ac.auckland.se281;

import java.util.List;
import nz.ac.auckland.se281.Main.Choice;

public interface AI {
  public void setStrategy(Strategy strategy);

  public int play(Choice aiWin, List<Integer> history);
}