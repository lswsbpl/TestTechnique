package com.jaybird.wsb.model;

public class CreateRequestLogin {
  private String user;
  private String email;
  private String password;

  public CreateRequestLogin(String user, String email, String password) {

    this.user = user;
    this.email = email;
    this.password = password;
  }

  public String getUser() {
    return user;
  }

  public void setUser(String user) {
    this.user = user;
  }

  public String getEmail() {
    return email;
  }

  public void setEmail(String email) {
    this.email = email;
  }

  public String getPassword() {
    return password;
  }

  public void setPassword(String password) {
    this.password = password;
  }
}
