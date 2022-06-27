package com.jaybird.wsb.tdd.base;

import org.springframework.stereotype.Service;

@Service
public class CreateRequestService {
  public User createUser(CreateRequestLogin createRequestLogin) {
    if(!PasswordValidator.validatePassword(createRequestLogin.getPassword())){
      throw new UserPasswordWrongPasswordException();
    }

    return new User(createRequestLogin.getUser(),createRequestLogin.getPassword(),createRequestLogin.getEmail());
  }
}
