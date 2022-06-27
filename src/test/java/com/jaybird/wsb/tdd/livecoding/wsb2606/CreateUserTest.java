package com.jaybird.wsb.tdd.livecoding.wsb2606;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.catchThrowable;

import com.jaybird.wsb.tdd.livecoding.wsb2606.helper.PasswordIsWrongException;
import com.jaybird.wsb.tdd.livecoding.wsb2606.helper.ValidationPassword;

import org.junit.jupiter.api.Test;

public class CreateUserTest {

  @Test
  public void whenCreateUser_thenGetNewUser() {
    //given
    User user;
    // when
    user = new User();
    //then
    assertThat(user).isNotNull();
  }

  @Test
  public void givenUserAndPasswordAndEmail_whenCreateUser_then_userHasProperData() {
    //given
    User user;
    // when
    user = new User("user", "password", "email");
    //then
    assertThat(user.getUser()).isNotNull();
    assertThat(user.getPassword()).isNotNull();
    assertThat(user.getEmail()).isNotNull();
  }

  @Test
  public void validatePasswordIfIsEmpty(){
    //given
    String password="";
    // when
    Throwable throwable= catchThrowable(()->ValidationPassword.validate(password));
    //then
    assertThat(throwable).isInstanceOf(PasswordIsWrongException.class);
  }
  @Test
  public void validatePasswordIfIsNull(){
    //given
    String password=null;
    // when
    Throwable throwable= catchThrowable(()->ValidationPassword.validate(password));
    //then
    assertThat(throwable).isInstanceOf(PasswordIsWrongException.class);
  }
  @Test
  public void validatePasswordIfIslessThan10Char(){
    //given
    String password="password";
    // when
    Throwable throwable= catchThrowable(()->ValidationPassword.validate(password));
    //then
    assertThat(throwable).isInstanceOf(PasswordIsWrongException.class);
  }
  @Test
  public void validatePasswordIfIsEqual10Char(){
    //given
    String password="PASSWORD12";
    // when
    boolean isValid=ValidationPassword.validate(password);
    //then
    assertThat(isValid).isTrue();
  }

  @Test
  public void callServiceToCreateWrongUser() {
    //given
    String user = "user", password = "password", email = "email";
    // when
    CreateUserService createUserService = new CreateUserService();
    Throwable throwable= catchThrowable(()->createUserService.createUser(user, password, email));
    //then
    assertThat(throwable).isInstanceOf(PasswordIsWrongException.class);

  }

  @Test
  public void callServiceToCreateCorrectUser() {
    //given
    String user = "user", password = "PASSWORD12", email = "email";
    // when
    CreateUserService createUserService = new CreateUserService();
    ResponseCreateUser responseCreateUser = createUserService.createUser(user, password, email);
    //then
    assertThat(responseCreateUser.getMessage()).isEqualTo("User Created");
    assertThat(responseCreateUser.getTimestamp()).isNotNull();

  }
}
