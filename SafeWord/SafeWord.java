import java.util.Scanner;
import java.util.Random;

public class SafeWord {
  public static void main(String[] args) {
    // Programmet initieras och användaren bestämmer längd på lösenordet.
    Password pw = new Password();
    Scanner sc = new Scanner(System.in);
    int pwLength = 0;
    do {
      System.out.print("How many characters du you want in your new password? (Minimum of 4): ");
      pwLength = sc.nextInt();
    } while (pwLength<4);

    /* Nedan slumpas tecken fram tills det bara finns tre tecken kvar i lösenordet.
      Då kontrolleras att ingen av de fyra typer av tecken som krävs saknas innan
      ett nytt tecken läggs till. */
    for (int i=0; i<pwLength; ++i) {
      if (i<(pwLength-3)) {
        AddRandomChar(pw); //Denna metod definieras sist bland metoderna nedan.
      }
      else {
        if (pw.checkForSpecial()==false) {
          addSpecialChar(pw);
        }
        else if (pw.checkForDigit()==false) {
          addDigitChar(pw);
        }
        else if (pw.checkForCapital()==false) {
          addCapitalChar(pw);
        }
        else if (pw.checkForCommon()==false) {
          addCommonChar(pw);
        }
        else {
          AddRandomChar(pw);
        }
      }
    }
    // Det nya säkra lösenordet skrivs ut till användaren.
    System.out.println("Your new, and safe, password: " + pw.getNewPassword());
  }

  /* HJÄLPMETODER
    Funktioner för att slumpa fram ett tecken (char) av en viss sort. Då alla tecken
    också kan beskrivas med ett heltal, där de teckengrupper vi är ute efter ligger
    grupperade i direkt sekvens, så slumpar jag fram ett heltal i spannet för antalet
    av aktuellt tecken, lägger till heltalet som sekvensen börjar på, och omvandlar
    till sist detta heltal till en char. Därefter läggs tecknet till i slutet av
    det sedan tidigare skapade lösenordet, samtidigt som klassen Password får info
    om att ett tecken av den aktuella typen lagts till. */

  static void addCapitalChar(Password pw) {
    Random r = new Random();
    int intValue = r.nextInt(26) + 65;
    char capital = (char)intValue;
    pw.setNewPassword(pw.getNewPassword().concat(String.valueOf(capital)));
    pw.capitalAdded();
  }

  static void addCommonChar(Password pw) {
    Random r = new Random();
    int intValue = r.nextInt(26) + 97;
    char common = (char)intValue;
    pw.setNewPassword(pw.getNewPassword().concat(String.valueOf(common)));
    pw.commonAdded();
  }

  static void addDigitChar(Password pw) {
    Random r = new Random();
    int intValue = r.nextInt(10) + 48;
    char digit = (char)intValue;
    pw.setNewPassword(pw.getNewPassword().concat(String.valueOf(digit)));
    pw.digitAdded();
  }

  static void addSpecialChar(Password pw) {
    Random r = new Random();
    int intValue = r.nextInt(6) + 33; /* Det finns betydligt fler specialtecken
    men dessa är enligt mig de bästa som ligger i direkt sekvens i ASCII-tabellen */
    char special = (char)intValue;
    pw.setNewPassword(pw.getNewPassword().concat(String.valueOf(special)));
    pw.specialAdded();
  }

  //Följande funktion slumpar fram vilken av de fyra funktionerna ovan som ska användas.
  static void AddRandomChar(Password pw) {
    Random c = new Random();
    int charTypeChoice = c.nextInt(4);
    switch (charTypeChoice) {
      case 0:
        addCapitalChar(pw);
        break;
      case 1:
        addCommonChar(pw);
        break;
      case 2:
        addDigitChar(pw);
        break;
      case 3:
        addSpecialChar(pw);
        break;
    }
  }
}
