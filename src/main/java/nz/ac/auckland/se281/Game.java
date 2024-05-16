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
  private final String botName = "HAL-9000";
  private Bot bot;
  private Choice choice;
  private List<Integer> history;
  private boolean activeGame = false;
  private int playerWins;
  private int botWins;

  /**
   * Starts a new round of the game.
   * This will wipe the previous history and player.

   * @param difficulty the enum describing what difficulty the bot gets made at.
   * @param choice     the given win condition for the player.
   * @param options    pass in the player name.
   */
  public void newGame(Difficulty difficulty, Choice choice, String[] options) {
    // the first element of options[0]; is the name of the player
    MessageCli.WELCOME_PLAYER.printMessage(options[0]);
    player = options[0];
    playCount = 0;
    this.bot = BotFactory.createBot(difficulty);
    this.choice = choice;

    // history to keep track during current game
    history = new ArrayList<Integer>();

    // activate game to track for stats checker
    activeGame = true;

    // player wins and ai wins for stats
    playerWins = 0;
    botWins = 0;
  }

  /**
   * Plays a round of the started game.
   * Essentially all of the logic of the game for intefacing with the player.
   * This method with call terminal inputs for processing.
   */
  public void play() {
    if (!activeGame) {
      MessageCli.GAME_NOT_STARTED.printMessage();
      return;
    }

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
    int aiHand = bot.play(aiWin, history);
    MessageCli.PRINT_INFO_HAND.printMessage(botName, String.valueOf(aiHand));

    // print the outcome
    int sum = aiHand + fingers;
    Choice resultChoice = Utils.isEven(sum) ? Choice.EVEN : Choice.ODD;
    String sumProp = Utils.isEven(sum) ? "EVEN" : "ODD";
    String winner = (choice.equals(resultChoice)) ? player : botName;
    MessageCli.PRINT_OUTCOME_ROUND.printMessage(String.valueOf(sum), sumProp, winner);

    // keep track of stats
    if (winner.equals(player)) {
      playerWins++;
    } else {
      botWins++;
    }
  }

  /**
   * This will end the game.
   * It will reset all the game dependent parameters.
   */
  public void endGame() {
    // print stats
    showStats();
    // print winner or tie
    if (playerWins == botWins) {
      MessageCli.PRINT_END_GAME_TIE.printMessage();
    } else if (playerWins > botWins) {
      MessageCli.PRINT_END_GAME.printMessage(player);
    } else {
      MessageCli.PRINT_END_GAME.printMessage(botName);
    }

    activeGame = false;
  }

  /**
   * Extrapolate the stats gathered during playing the game into an output.
   * This will only work whether a game is currently active.
   */
  public void showStats() {
    // if no game is active error message
    if (!activeGame) {
      MessageCli.GAME_NOT_STARTED.printMessage();
      return;
    }

    // Format
    // Valerio won 1 rounds and lost 0 rounds
    // HAL-9000 won 0 rounds and lost 1 rounds

    // player
    MessageCli.PRINT_PLAYER_WINS.printMessage(player, String.valueOf(playerWins), String.valueOf(botWins));
    // ai
    MessageCli.PRINT_PLAYER_WINS.printMessage(botName, String.valueOf(botWins), String.valueOf(playerWins));

  }
}
