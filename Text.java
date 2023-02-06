// some ideas for methods from "The Lost Cat" by @fishermanraf
public class Text {
  public static void printIntro() {
    clear();
    System.out.println(TextArt.title);
    wait(1.0);
    smoothPrint("\n\nWelcome to Hangman!\n\n");
    wait(1.0);
    smoothPrint("The goal of this game is to guess the word or phrase by entering a letter.\n");
    wait(2.0);
    smoothPrint("Try not to use up all your guesses!\n\n");
    wait(1.5);
  }
  public static void printWordCountSettings() {
    clear();
    smoothPrint("How many words would you like to play with? \n\n");
    smoothPrint("Enter a number between 1 and 4: ");
  }
  public static void printModeSettings() {
    clear();
    smoothPrint("What difficulty would you like to play on?\n\n");
    smoothPrint("1. Easy\n");
    smoothPrint("2. Hard\n\n");
    smoothPrint("Enter your choice: ");
  }
  public static void clear() {
    System.out.print("\033[H\033[2J");
    System.out.flush();
  }
  public static void wait(double t) {
    try {
      Thread.sleep((int) (t * 1000));
    }
    catch (Exception e) {
      e.printStackTrace();
    }
  }
  public static void smoothPrint(String prompt) {
    for (char c : prompt.toCharArray()) {
      System.out.print(c);
      wait(0.05);
    }
  }
}