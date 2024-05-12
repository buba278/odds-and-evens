package nz.ac.auckland.se281;

import nz.ac.auckland.se281.Main.Choice;

public interface AI {
  public void setStrategy(Strategy strategy);
  public int play(Choice aiWin);
}