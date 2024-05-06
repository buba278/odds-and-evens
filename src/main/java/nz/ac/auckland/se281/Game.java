package nz.ac.auckland.se281;

import nz.ac.auckland.se281.Main.Choice;
import nz.ac.auckland.se281.Main.Difficulty;

/** This class represents the Game is the main entry point. */
public class Game {

  // Fields
  int playCount = 0;

  public void newGame(Difficulty difficulty, Choice choice, String[] options) {
    // the first element of options[0]; is the name of the player
    MessageCli.WELCOME_PLAYER.printMessage(options[0]);
    playCount = 0;
  }

  public void play() {
    playCount++;
    MessageCli.START_ROUND.printMessage(String.valueOf(playCount));
  }

  public void endGame() {}

  public void showStats() {}
}
