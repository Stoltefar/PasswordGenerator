import java.util.Random;

public class SafeWord {
  public static void main(String[] args) {
    boolean missingCapital = true;
    boolean missingCommon = true;
    boolean missingDigit = true;
    boolean missingSpecial = true;

    String safeWord ="";
    for (int i=0; i< 20; ++i) {
      safeWord = addCapitalChar(safeWord);
      System.out.println(safeWord);
    }

  }

  static String addCapitalChar(String password) {
    Random r = new Random();
    int intValue = r.nextInt(26) + 65;
    char capital = (char)intValue;
    password = password.concat(String.valueOf(capital));
    return password;
  }
}
