package com.jaybird.wsb.tdd.base;

import org.junit.platform.commons.util.StringUtils;

public class PasswordValidator {
  public static boolean validatePassword(String password) {
    return StringUtils.isBlank(password) && password.matches("[a-zA-Z0-9]{10}");
  }
}
