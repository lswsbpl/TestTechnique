package com.jaybird.wsb.tdd.livecoding.wsb2606;

import com.jaybird.wsb.tdd.livecoding.wsb2606.helper.ValidationPassword;

public class CreateUserService {
  public ResponseCreateUser createUser(String user, String password, String email) {
    User cereatedUser=new User(user,password,email);
    if(ValidationPassword.validate(cereatedUser.getPassword())){
      return new ResponseCreateUser();
    }
    return null;
  }
}
