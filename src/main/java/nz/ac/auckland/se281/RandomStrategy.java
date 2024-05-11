package nz.ac.auckland.se281;

public class RandomStrategy implements Strategy {
  // just pick an integer from 0 to 5
  public int getAction() {
    return Utils.getRandomNumberRange(0, 5);
  }
}
