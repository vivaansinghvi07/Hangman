import java.util.*;
import java.io.*;

public class GameSettings {

  private Scanner scan;
  
  public GameSettings () {
    scan = new Scanner(System.in);
  }
  
  public int getWordCount() {

    // prints the prompt to get how many words the game will run with
    Text.printWordCountSettings();
    
    int count = getNumber(scan, 1, 4);
    return count;
    
  }
  public File getWordSource() throws FileNotFoundException {

    // prints the prompt and gets the mode, represented by the number
    Text.printModeSettings();
    int mode = getNumber(scan, 1, 2);

    // initializes the file and then assigns one to it
    File wordSource;
    if (mode == 1) {
      wordSource = new File("words/easy.txt");
    }
    else {
      wordSource = new File("words/hard.txt");
    }

    // returns the file that will be read off 
    return wordSource;
    
  }
  public static int getNumber(Scanner scan, int lowerBound, int upperBound) {
    // stores the choice as -1 to begin with
    int choice = -1;
    try {
      // keeps getting input until the choice is in the proper bounds
      while (true) {
        choice = scan.nextInt();
        if (choice >= lowerBound && choice <= upperBound) {
          return choice;
        } 
        else {
          System.out.println("Please enter a number between " + lowerBound + " and " + upperBound + "!");
        }
      }
    }
    catch (Exception e) {
      // Exceptions will occur if an integer is not entered, in that case, just use recursion
      System.out.println("Please enter a number!");
      scan.nextLine();
      return getNumber(scan, lowerBound, upperBound);
    }
  }
  public static String randomLine(File file) throws FileNotFoundException {
    // initializes output, random generator, chance, and scanner
    String out = null;
    Random rand = new Random();
    int chance = 1;
    Scanner scan = new Scanner(file);

    // uses reservoir sampling to get a random thing from the thing
    while (scan.hasNext()) {
      String line = scan.nextLine();
      if (rand.nextInt(chance) == 0) {
        out = line;
      }
      chance++;
    }

    // returns the found line after the sampling is done
    return out;
  }
  
}