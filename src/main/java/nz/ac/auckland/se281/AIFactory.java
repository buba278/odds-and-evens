package nz.ac.auckland.se281;

public class AIFactory {
  public static AI createAI(String difficulty) {
    switch (difficulty) {
      case "EASY":
        return new EasyAI();
      default:
        return null;
    }
  }
}