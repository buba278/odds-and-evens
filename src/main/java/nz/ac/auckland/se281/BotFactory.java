package nz.ac.auckland.se281;

import nz.ac.auckland.se281.Main.Difficulty;

public class BotFactory {
  /**
   * This creates instances of different difficulty bots.
   * 
   * @param difficulty the difficulty at which you want to make a bot for.
   * @return Bot the bot that was created at the given difficulty.
   */
  public static Bot createBot(Difficulty difficulty) {
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