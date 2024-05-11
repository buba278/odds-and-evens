package nz.ac.auckland.se281;

import nz.ac.auckland.se281.Main.Difficulty;

public class AIFactory {
  public static AI createAI(Difficulty difficulty) {
    switch (difficulty) {
      case EASY:
        return new EasyAI();
      default:
        return null;
    }
  }
}