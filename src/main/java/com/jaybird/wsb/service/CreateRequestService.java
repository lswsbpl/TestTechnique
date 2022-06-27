package com.jaybird.wsb.service;

import com.jaybird.wsb.common.PasswordValidator;
import com.jaybird.wsb.model.CreateRequestLogin;
import com.jaybird.wsb.model.User;
import com.jaybird.wsb.service.exceptions.UserPasswordWrongPasswordException;

import org.springframework.stereotype.Service;

@Service
public class CreateRequestService {
  public User createUser(CreateRequestLogin createRequestLogin) {
    if (!PasswordValidator.validatePassword(createRequestLogin.getPassword())) {
      throw new UserPasswordWrongPasswordException();
    }

    return new User(createRequestLogin.getUser(), createRequestLogin.getPassword(), createRequestLogin.getEmail());
  }
}
