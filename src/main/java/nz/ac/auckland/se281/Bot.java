package nz.ac.auckland.se281;

import java.util.List;
import nz.ac.auckland.se281.Main.Choice;

/**
 * This interface sets the foundation for bot functionality to play it's turn
 * and select it's strategy.
 */
public interface Bot {

  /**
   * This sets the current strategy being used by the EasyBot.This will determine
   * how the EasyBot will make its decisions.
   * 
   * @param strategy the current strategy being used by the bot to play its moves.
   */
  public void setStrategy(Strategy strategy);

  /**
   * Play the AI's move as in provide the amount of fingers it will play on its
   * turn.
   * 
   * @param botWin  the win condition for the ai so it can make its decisions
   * @param history array list of all the previous moves the human made and its
   *                "choice"
   * @return int, it will return the given fingers that the bot will play
   */
  public int play(Choice botWin, List<Integer> history);
}