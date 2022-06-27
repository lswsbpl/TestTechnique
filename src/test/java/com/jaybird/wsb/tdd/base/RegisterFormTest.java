package com.jaybird.wsb.tdd.base;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.catchThrowable;

import org.junit.jupiter.api.Test;


public class RegisterFormTest {
  CreateRequestService createRequestService = new CreateRequestService();
  String USER = "user";
  String EMAIL = "email";
  String PASSWORD = "Password12";

  @Test
  public void when_call_create_user_service_then_get_new_user_createUser() {
    //GIVEN
    CreateRequestLogin createRequestLogin = new CreateRequestLogin(USER, EMAIL, PASSWORD);
    //WHEN
    User user = createRequestService.createUser(createRequestLogin);
    //THEN
    assertThat(user).isNotNull();
    assertThat(user.getLogin()).isEqualTo(USER);
    assertThat(user.getPassword()).isEqualTo(PASSWORD);
    assertThat(user.getEmail()).isEqualTo(EMAIL);
  }

  @Test
  public void whenCreateUserPasswordShouldBeNotEmpty() {
    //GIVEN
    CreateRequestLogin createRequestLogin = new CreateRequestLogin(USER, EMAIL, "");
    //WHEN
    Throwable thrown = catchThrowable(() -> createRequestService.createUser(createRequestLogin));
    //THEN
    assertThat(thrown).isInstanceOf(UserPasswordWrongPasswordException.class);

  }
  @Test
  public void passwordShouldBeValidated() {
    //GIVEN
    String password="password";
    //WHEN
    boolean isValid=PasswordValidator.validatePassword(password);
    //THEN
    assertThat(isValid).isFalse();
  }


}
