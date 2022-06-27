Feature:
  Create user with login,password and email
  Scenario: client makes call to create correct user
    Given login is "Leszek" password is "Password12" email is "email"
    When we do a "PUT" call to "/createUser"
    Then the status code of the response is 200
    And the body of the response contains login and contains "timestamp"
  Scenario Outline: client makes call to create correct user
    Given login is <username> password is <password> email is <email>
    When we do a "PUT" call to "/createUser"
    Then the status code of the response is 200
    And the body of the response contains login and contains "timestamp"

    Examples:
      | username | password | email |
      |    "Leszek" |   "Password12" |    "test@test.pl"|
      |    "Leszek2" |   "Password12" |   "test@test.pl" |

  Scenario: client makes call to create user with wrong password
    Given login is "login" password is "Password" email is "email"
    When we do a "PUT" call to "/createUser"
    Then the status code of the response is 400

