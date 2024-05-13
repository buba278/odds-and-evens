package nz.ac.auckland.se281;

import java.util.ArrayList;
import java.util.List;
import nz.ac.auckland.se281.Main.Choice;
import nz.ac.auckland.se281.Main.Difficulty;

/** This class represents the Game is the main entry point. */
public class Game {

  // Fields
  private int playCount = 0;
  private String player = "";
  private final String nameAI = "HAL-9000";
  private AI ai;
  private Choice choice;
  private List<Integer> history;
  private boolean activeGame = false;

  public void newGame(Difficulty difficulty, Choice choice, String[] options) {
    // the first element of options[0]; is the name of the player
    MessageCli.WELCOME_PLAYER.printMessage(options[0]);
    player = options[0];
    playCount = 0;
    this.ai = AIFactory.createAI(difficulty);
    this.choice = choice;

    // history to keep track during current game
    history = new ArrayList<Integer>();

    // activate game to track for stats checker
    activeGame = true;
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

    // add finger choice to history
    if (Utils.isEven(fingers)) {
      history.add(2);
    } else {
      history.add(1);
    }

    // hand print if goes through while loop
    MessageCli.PRINT_INFO_HAND.printMessage(player, String.valueOf(fingers));
    // print ai result
    Choice aiWin = (choice.equals(Choice.EVEN)) ? Choice.ODD : Choice.EVEN;
    int aiHand = ai.play(aiWin, history);
    MessageCli.PRINT_INFO_HAND.printMessage(nameAI, String.valueOf(aiHand));

    // print the outcome
    int sum = aiHand + fingers;
    Choice resultChoice = Utils.isEven(sum) ? Choice.EVEN : Choice.ODD;
    String sumProp = Utils.isEven(sum) ? "EVEN" : "ODD";
    String winner = (choice.equals(resultChoice)) ? player : nameAI;
    MessageCli.PRINT_OUTCOME_ROUND.printMessage(String.valueOf(sum), sumProp, winner);
  }

  public void endGame() {
    activeGame = false;
  }

  public void showStats() {}
}
