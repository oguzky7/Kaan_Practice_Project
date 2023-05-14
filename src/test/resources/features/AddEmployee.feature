Feature: Add Employee

  Background:
    When user enters valid username and valid password
    And user clicks on login button
    Then user is successfully logged in
    When user clicks on PIM option
    And user clicks on Add Employee button

  @AddEmployee @Test7 @all
  Scenario: Adding one employee
    And user enters firstname and lastname
    And user clicks on save button
    Then employee added successfully

  @AddEmployee  @Test8 @all
  Scenario: Adding one employee using feature file
    And user enters "zalam" and "alia"
    And user clicks on save button
    Then employee added successfully

  @AddEmployee  @Test9 @all
  Scenario Outline: Adding multiple employees using feature file
    And user enters "<firstName>" and "<lastName>" for adding multiple employees
    And user clicks on save button
    Then employee added successfully
    Examples:
      | firstName | lastName |
      | gulnam    | mazar    |
      | rampal    | chambel  |
      | azam      | asel     |
    #This one is opening and closing the browser for every example.
    #not very efficient

  @AddEmployee  @Test10 @all
  Scenario: Adding multiple employees using data table
    When user adds multiple employees and verify they are added successfully
      | firstName | middleName | lastName   |
      | zara      | MS         | camilullah |
      | birgul    | MS         | ozgin      |
      | alina     | MS         | bob        |
    #This one is clicks on the add employee again keeps adding
    #without closing the browser


  @AddEmployee  @Test11 @all
  Scenario: Adding multiple employees using excel file
    When user adds multiple employee from excel using "EmployeeData" and verify it

  @AddEmployee  @Test12 @all @DB
  Scenario: Adding employee and verifying it is stored in database
    And user enters "Mansoor" and "Raufi"
    And user captures employee id
    And user clicks on save button
    And added employee is displayed in database
