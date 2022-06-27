package com.jaybird.wsb.common;

import org.springframework.util.StringUtils;

public class PasswordValidator {
  public static boolean validatePassword(String password) {
    return StringUtils.hasText(password) && password.matches("[a-zA-Z0-9]{10}");
  }
}
