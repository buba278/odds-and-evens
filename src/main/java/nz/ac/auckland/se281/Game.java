package nz.ac.auckland.se281;

import nz.ac.auckland.se281.Main.Choice;
import nz.ac.auckland.se281.Main.Difficulty;

/** This class represents the Game is the main entry point. */
public class Game {

  // Fields
  int playCount = 0;
  String player = "";
  private final String nameAI = "HAL-9000";
  AI ai;
  Choice choice;

  public void newGame(Difficulty difficulty, Choice choice, String[] options) {
    // the first element of options[0]; is the name of the player
    MessageCli.WELCOME_PLAYER.printMessage(options[0]);
    player = options[0];
    playCount = 0;
    this.ai = AIFactory.createAI(difficulty);
    this.choice = choice;
  }

  public void play() {
    playCount++;
    MessageCli.START_ROUND.printMessage(String.valueOf(playCount));

    // first check with no error
    int fingers = -1;
    MessageCli.ASK_INPUT.printMessage();
    String input = Utils.scanner.nextLine();
    fingers = Integer.parseInt(input);

    // check with error
    while ((fingers < 0) | (fingers > 5)) {
      MessageCli.INVALID_INPUT.printMessage();
      MessageCli.ASK_INPUT.printMessage();
      input = Utils.scanner.nextLine();
      fingers = Integer.parseInt(input);
    }

    // hand print if goes through while loop
    MessageCli.PRINT_INFO_HAND.printMessage(player, String.valueOf(fingers));
    // print ai result
    int aiHand = ai.play();
    MessageCli.PRINT_INFO_HAND.printMessage(nameAI, String.valueOf(aiHand));

    // print the outcome
    int sum = aiHand + fingers;
    Choice resultChoice = Utils.isEven(sum) ? Choice.EVEN : Choice.ODD;
    String sumProp = Utils.isEven(sum) ? "EVEN" : "ODD";
    String winner = (choice.equals(resultChoice)) ? player : nameAI;
    MessageCli.PRINT_OUTCOME_ROUND.printMessage(String.valueOf(sum), sumProp, winner);
  }

  public void endGame() {}

  public void showStats() {}
}
