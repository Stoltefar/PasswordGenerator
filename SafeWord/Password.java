public class Password {
  private String newPassword;
  public String getNewPassword() {
    return newPassword;
  }

  public void setNewPassword(String s) {
    newPassword = s;
  }
  private boolean missingCapital = true;
  public void capitalAdded() {
    missingCapital = false;
  }

  public boolean checkForCapital() {
    for (int i=0; i<newPassword.length(); ++i) {
      char c = newPassword.charAt(i);
      if (c>='A' && c<='Z') {
        return true;
      }
    }
    return false;
  }


  private boolean missingCommon = true;

  public void commonAdded() {
    missingCommon = false;
  }

  public boolean checkForCommon() {
    for (int i=0; i<newPassword.length(); ++i) {
      char c = newPassword.charAt(i);
      if (c>='a' && c<='z') {
        return true;
      }
    }
    return false;
  }


  private boolean missingDigit = true;

  public void digitAdded() {
    missingDigit = false;
  }

  public boolean checkForDigit() {
    for (int i=0; i<newPassword.length(); ++i) {
      char c = newPassword.charAt(i);
      if (c>='0' && c<='9') {
        return true;
      }
    }
    return false;
  }


  private boolean missingSpecial = true;

  public void specialAdded() {
    missingSpecial = false;
  }

  public boolean checkForSpecial() {
    for (int i=0; i<newPassword.length(); ++i) {
      char c = newPassword.charAt(i);
      if (c>='!' && c<='&') {
        return true;
      }
    }
    return false;
  }


  public Password() {
    newPassword = "";
  }


}
