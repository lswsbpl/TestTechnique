import com.jaybird.wsb.model.CreateRequestLogin;
import com.jaybird.wsb.tdd.base.RequestHelper;
import com.jaybird.wsb.tdd.livecoding.wsb2606.ResponseCreateUser;

import java.time.Instant;

import org.assertj.core.api.Assertions;
import org.springframework.http.HttpMethod;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import io.cucumber.spring.CucumberContextConfiguration;

public class CreateUserStory {
  private String login;
  private String password;
  private String email;
  private ResponseEntity<Object> response;

  @Given("login is {string} password is {string} email is {string}")
  public void loginIsPasswordIsEmailIs(String login, String password, String email) {
    this.login = login;
    this.password = password;
    this.email = email;
  }

  @When("we do a {string} call to {string}")
  public void weDoACallTo(String method, String url) {
    if(method.equals(HttpMethod.PUT.name())){
      RequestHelper<CreateRequestLogin> createRequestLoginRequestHelper= new RequestHelper<>();
      ResponseEntity<Object> response=createRequestLoginRequestHelper.doPut(new CreateRequestLogin(login,email,password),url,ResponseCreateUser.class);
      this.response=response;
    }else{
      throw new RuntimeException();
    }
  }

  @Then("the status code of the response is {int}")
  public void theStatusCodeOfTheResponseIs(int status) {
    Assertions.assertThat(response.getStatusCodeValue()).isEqualTo(status);
  }

  @And("the body of the response contains login and contains {string}")
  public void theBodyOfTheResponseContainsLoginAndContains(String arg0) {
    Assertions.assertThat(response.getBody()).isNotNull();
    Assertions.assertThat(response.getBody()).isInstanceOf(ResponseCreateUser.class);
    Assertions.assertThat(((ResponseCreateUser) response.getBody()).getMessage()).contains(login);
    Assertions.assertThat(((ResponseCreateUser) response.getBody()).getTimestamp()).isNotNull();

  }


  @Given("login is <username> password is <password> email is <email>")
  public void loginIsUsernamePasswordIsPasswordEmailIsEmail() {
  }
}
