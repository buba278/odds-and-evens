package nz.ac.auckland.se281;

import nz.ac.auckland.se281.Main.Difficulty;

public class AIFactory {
  /**
   * This creates instances of different difficulty AIs.
   * 
   * @param difficulty, the difficulty at which you want to make an AI for.
   */
  public static AI createAI(Difficulty difficulty) {
    switch (difficulty) {
      case EASY:
        return new EasyAI();
      case MEDIUM:
        return new MediumAI();
      case HARD:
        return new HardAI();
      default:
        return null;
    }
  }
}