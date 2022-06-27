import static org.assertj.core.api.Assertions.assertThat;

import com.jaybird.wsb.model.CreateRequestLogin;
import com.jaybird.wsb.model.payload.CreateUserResponse;
import com.jaybird.wsb.tdd.base.RequestHelper;

import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import io.cucumber.spring.CucumberContextConfiguration;

@CucumberContextConfiguration
public class MyStepdefs {
//  private String login;
//  private String password;
//  private String email;
//  private ResponseEntity<Object> response;
//
//
//  @Given("login is {string} password is {string} email is {string}")
//  public void loginIsPasswordIsEmailIs(String login, String password, String email) {
//    this.login = login;
//    this.password = password;
//    this.email = email;
//  }
//
//  @When("we do a {string} call to {string}")
//  public void weDoACallTo(String method, String url) {
//    if (method.equals(HttpMethod.PUT.name())) {
//      RequestHelper<CreateRequestLogin> createUserResponseRequestHelper = new RequestHelper<>();
//      response = createUserResponseRequestHelper.doPost(new CreateRequestLogin(login, email, password), url);
//    }
//
//  }
//
//  @Then("the status code of the response is {int}")
//  public void theStatusCodeOfTheResponseIs(int arg0) {
//    assertThat(response.getStatusCodeValue()).isEqualTo(arg0);
//  }
//
//  @And("the body of the response contains login and contains {string}")
//  public void theBodyOfTheResponseContainsAndContains(String arg1) {
//    if (response.getBody() instanceof CreateUserResponse) {
//      assertThat(((CreateUserResponse) response.getBody()).getMessage()).contains(login);
//      assertThat(response.toString()).contains(arg1);
//
//    }

//  }
}
