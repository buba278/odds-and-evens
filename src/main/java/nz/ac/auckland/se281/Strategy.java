package nz.ac.auckland.se281;

import java.util.List;
import nz.ac.auckland.se281.Main.Choice;

public interface Strategy {
  public int getAction(Choice aiWin);

  public void importHistory(List<Integer> history);
}