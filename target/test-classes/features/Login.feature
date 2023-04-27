Feature: Login functionality

  @Login
  Scenario: Valid admin login
    #Given user is navigated to HRMS application
    When user enters valid username and valid password
    And user clicks on login button
    Then user is successfully logged in

  @Login @Test1 @all
  Scenario: Valid ess login
    #Given user is navigated to HRMS application
    When user enters ess username and ess password
    And user clicks on login button
    Then user is successfully logged in

  @Login  @Test2 @all
  Scenario: Invalid admin login
   # Given user is navigated to HRMS application
    When user enters invalid username and password
    And user clicks on login button
    Then error message displayed

  @Login  @Test3 @all
  Scenario Outline: Invalid login functionality
    When user enters different "<username>" and "<password>" and verify the "<error>" for it
    Examples:
      | username | password | error |
      |admin     |cristiano |Invalid credentials|
      |ronaldo   |Hum@nhrm123|Invalid credentials|
      |          |Hum@nhrm123|Username cannot be empty|
      |admin     |           |Password cannot be empty|





