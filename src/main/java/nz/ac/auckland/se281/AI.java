package nz.ac.auckland.se281;

import java.util.List;
import nz.ac.auckland.se281.Main.Choice;

public interface AI {
  
  /**
   * This sets the current strategy being used by the EasyAI.
   * This will determine how the EasyAI will make its decisions.
   * 
   * @param strategy, the current strategy being used by the ai to play its moves.
   */
  public void setStrategy(Strategy strategy);

  /**
   * Play the AI's move as in provide the amount of fingers it will play on its turn.
   * 
   * @param aiWin, the win condition for the ai so it can make its decisions
   * @param history, array list of all the previous moves the human made and its "choice"
   * @return int, it will return the given fingers that the ai will play
   */
  public int play(Choice aiWin, List<Integer> history);
}