Feature: Able to Terminate Employment
  Background:
    #Given user is navigated to HRMS application
    When user enters valid username and valid password
    And user clicks on login button
    Then user is successfully logged in

  @AbleToTerminate  @Test17
  Scenario: As an admin user should be able to terminate Employment
    When admin click on PIM option
    #And admin click on Employee List option
    #And admin clicks on name tab to arrange
    And admin clicks on any employee id
    And admin clicks on Job tab
    And admin clicks on Terminate Employment button
    And admin verifies Reasons dropdown is displayed and select a value from it
    And admin verifies Calendar is displayed and user can pick values from there
    And admin verify Note textBox field is displayed and enter values there
    And admin click on Confirm button
    Then verifies if employee Terminated
    Then clicks Activate Employment button again to change back to default setting of the employee
