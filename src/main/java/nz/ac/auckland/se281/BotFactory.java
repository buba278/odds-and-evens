package nz.ac.auckland.se281;

import nz.ac.auckland.se281.Main.Difficulty;

public class BotFactory {
  /**
   * This creates instances of different difficulty AIs.
   * 
   * @param difficulty, the difficulty at which you want to make an AI for.
   */
  public static AI createAI(Difficulty difficulty) {
    switch (difficulty) {
      case EASY:
        return new EasyBot();
      case MEDIUM:
        return new MediumBot();
      case HARD:
        return new HardBot();
      default:
        return null;
    }
  }
}