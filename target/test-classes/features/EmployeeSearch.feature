Feature: US-321 Searching the employee

  Background:
    When user enters valid username and valid password
    And user clicks on login button
    Then user is successfully logged in
    When user clicks on PIM option
    And user clicks on EmployeeList option


  @EmployeeSearch @Test5
  Scenario: Search employee by id
    When user enters valid employee id
    And user clicks on search button
    Then user sees employee information is displayed

  @EmployeeSearch @Test6
  Scenario: Search employee by name
    When user enters valid employee name
    And user clicks on search button
    Then user sees employee information is displayed