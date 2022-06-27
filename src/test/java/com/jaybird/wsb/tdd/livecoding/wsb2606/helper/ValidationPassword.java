package com.jaybird.wsb.tdd.livecoding.wsb2606.helper;

public class ValidationPassword {


  public static boolean validate(String password) {
    boolean isValid = true;
    if (password== null || password.equals("") || password.length()<10 || !password.matches("([A-Z0-9])\\w+")) {
      throw new PasswordIsWrongException();

    }
    return isValid;
  }
}
