public class TextArt {
  public static final String title =  
"\n██╗░░██╗░█████╗░███╗░░██╗░██████╗░███╗░░░███╗░█████╗░███╗░░██╗" + 
"\n██║░░██║██╔══██╗████╗░██║██╔════╝░████╗░████║██╔══██╗████╗░██║" + 
"\n███████║███████║██╔██╗██║██║░░██╗░██╔████╔██║███████║██╔██╗██║" + 
"\n██╔══██║██╔══██║██║╚████║██║░░╚██╗██║╚██╔╝██║██╔══██║██║╚████║" + 
"\n██║░░██║██║░░██║██║░╚███║╚██████╔╝██║░╚═╝░██║██║░░██║██║░╚███║" + 
"\n╚═╝░░╚═╝╚═╝░░╚═╝╚═╝░░╚══╝░╚═════╝░╚═╝░░░░░╚═╝╚═╝░░╚═╝╚═╝░░╚══╝";
  
  public static final String base = 
  "\n          ------- "; // has to be two backslashs for the escape seqeuence
  public static final String zeroGuess = 
  "\n" +
  "\n" + 
  "\n" +
  "\n" + 
  base;
  
  public static final String oneGuess = 
  "\n" + 
  "\n" + 
  "\n" + 
  "\n            /     " + 
  base;

  public static final String twoGuess = 
  "\n" + 
  "\n" + 
  "\n" +
  "\n            / \\   " +
  base;

  public static final String threeGuess = 
  "\n" + 
  "\n" + 
  "\n             |    " + 
  "\n            / \\   " +
  base;

  public static final String fourGuess = 
  "\n" + 
  "\n             |    " + 
  "\n             |    " + 
  "\n            / \\   " +
  base;

  public static final String fiveGuess = 
  "\n" + 
  "\n             |\\   " + 
  "\n             |    " + 
  "\n            / \\   " +
  base;

  public static final String sixGuess = 
  "\n" +
  "\n            /|\\   " + 
  "\n             |    " + 
  "\n            / \\   " +
  base;

  public static final String sevenGuess = 
  "\n             O    " + 
  "\n            /|\\   " + 
  "\n             |    " + 
  "\n            / \\   " +
  base;

  public static final String[] guesses = {zeroGuess, oneGuess, twoGuess, threeGuess, fourGuess, fiveGuess, sixGuess, sevenGuess};

  public static String getMan(int n) {
    return guesses[n];
  }
}