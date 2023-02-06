import java.util.*;
import java.io.*;

class Main {
  public static void main(String[] args) throws FileNotFoundException {
    // prints the introduction sequence and prompts to start playing
    Text.printIntro();
    Scanner scan = new Scanner(System.in);
    System.out.println("Press enter when you are ready to begin.");
    scan.nextLine();

    // keeps playing until the user says they want to stop
    boolean playAgain = true;
    while (playAgain) {
      
      // creates a new settings object which obtains these settings
      GameSettings gameSettings = new GameSettings();

      // creates a new game object which will store the data and stuff
      Game game = new Game(gameSettings.getWordCount(), gameSettings.getWordSource());

      int status = 0;
      while (status == 0) {

        // repeats the playing sequence until the game is over
        game.display();
        game.getGuess();
        status = game.checkForGameEnd();
        
      }
      scan = new Scanner(System.in);
      if (status == 1) {
        game.display();
        Text.smoothPrint("\nYou won! Would you like to play again? (y/n): ");
      }
      else if (status == -1) {
        game.printLoss();
        Text.smoothPrint("\nWould you like to play again? (y/n): ");
      }
      playAgain = scan.next().equalsIgnoreCase("y");
      
    }

    Text.clear();
    Text.smoothPrint("Thanks for playing!\n");
    scan.close();
  }
}