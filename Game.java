import java.util.*;
import java.io.*;

public class Game {
  private static final String alphabet = "abcdefghijklmnopqrstuvwxyz";
  private String[] words;
  private StringBuilder[] progress;
  private int wordCount;
  private int[] letterStatus;
  public boolean isOver;
  private int guessCount;
  
  public Game (int count, File src) throws FileNotFoundException {

    // stores the count
    wordCount = count;
    
    // creates a thing to store the words that are being used and guessed
    words = new String[count];
    progress = new StringBuilder[count];

    // stores the status of each letter (guessed and right, guessed and wrong, etc)
    letterStatus = new int[26];

    // game is not over
    isOver = false;

    // starts the guess count, if this exceeds a certain value than the game is over
    guessCount = 0;

    // prints a loading screen because this may take a while
    Text.clear();
    System.out.println("Loading...");

    // obtains random lines from the text file source to use in the play
    for (int i = 0; i < count; i++) {
      words[i] = GameSettings.randomLine(src).toLowerCase();

      // stores underscores in the progress thing, to display the guesses
      int len = words[i].length();
      progress[i] = new StringBuilder("");
      for (int j = 0; j < len; j++) {
        progress[i].append('_');
      }
      
    }

    // clears the loading screen
    Text.wait(0.5);
    Text.clear();
  }

  public void display() {
    Text.clear();

    // prints the person that represents how many guesses you have left
    System.out.println(TextArt.getMan(guessCount) + "\n");

    // prints the alphabet with letters that represent your guess status
    System.out.println(" " + printAlphabet() + "\n");
    
    // prints the guess status
    System.out.println(" " + printProgress() + "\n");
    
    
    
  }

  private String printProgress() {
    String out = new String("");
    for (StringBuilder word : progress) {
      out += word.toString() + " ";
    }
    return out;
  }
  
  private String printAlphabet() {
    String out = "";
    for (int i = 0; i < 26; i++) {
      // determines the color of the displayed letter based on the status
      if (letterStatus[i] == 1) {
        out += Colors.GREEN_BOLD_BRIGHT;
      }
      else if (letterStatus[i] == -1) {
        out += Colors.RED_BOLD;
      }
      else {
        out += Colors.RESET;
      }

      // adds the character to the string, with its color preceeding it
      out += alphabet.charAt(i);
    }

    // resets the typing and returns the output 
    out += Colors.RESET;
    return out;
  }
  
  public void getGuess() {
    // gets the letter and initializes its status to -1 (not found)
    char letter = getInput();
    letterStatus[alphabet.indexOf(letter)] = -1;

    // stores whether the letter is found within the string
    boolean found = false;
    
    for (int i = 0; i < wordCount; i++) {
      char[] word = words[i].toCharArray();

      // goes through each letter in the word and checks if the letter is present there
      for (int j = 0; j < word.length; j++) {
        if (word[j] == letter) {

          // marks as found so a guess doesn't get added
          found = true;

          // updates the current progress to incldue that letter
          progress[i].setCharAt(j, letter);

          // marks that letter as found using a 1
          letterStatus[alphabet.indexOf(letter)] = 1;
          
        }
      }
    }
    // if its not found then its a wrong guess and we add to the count
    if (!found) {
      guessCount++;
    }
  }

  // returns the character that the player enters, by following restrictions and different cases
  private char getInput() {

    // obtains the guess
    Scanner scan = new Scanner(System.in);
    System.out.print("Enter your guess: ");
    String inp = scan.next();

    // if the guess is not in the alphabet, return an error
    try {

      // make sure the letter is just a character
      if (inp.length() != 1) {
        System.out.println("You must only enter one letter!");
        return getInput();
      } // make sure the letter is not already guessed
      else if (letterStatus[alphabet.indexOf(inp.toLowerCase())] != 0) {
        System.out.println("You have already guessed this letter!");
        return getInput();
      } // if all conditions are met then it is returnable
      else {
        return Character.toLowerCase(inp.charAt(0));
      }
    }
    catch (Exception e) {
      System.out.println("Thats not a letter!");
      return getInput();
    }
  }

  public int checkForGameEnd() {
    // returns a -1 if the game is lost
    if (guessCount > 6) {
      return -1;
    }
    // doesn't count the game as over if there are still underscores that need to be filled
    for (StringBuilder word : progress) {
      if (word.toString().contains("_")) {
        return 0;
      }
    }
    // otherwise it's over so return a 1 signifying a win
    return 1;
  }

  public void printLoss() {
    Text.clear();
    System.out.println("\n" + TextArt.getMan(7) + "\n\n"); 
    Text.smoothPrint("You lost! The words were: ");
    printWordsAfterLoss();
    System.out.println("\n");
  }

  public void printWordsAfterLoss() {
    String out = new String("");
    for (String wordString : words) {
      // converts each word to a character array that can be looped over
      char[] word = wordString.toCharArray();
      for (char c : word) {
        // if the letter in the word was already guessed, highlight it green so that the user knows what they missed
        if (letterStatus[alphabet.indexOf(c)] == 1) {
          out += Colors.GREEN_BOLD_BRIGHT;
        }
        else {
          out += Colors.RESET;
        }
        // add the character to the output string
        out += c;
      }
      // spaces between words
      System.out.print(out + " " + Colors.RESET);
      Text.wait(1.0);
      out = new String("");
    }
  }
  
}