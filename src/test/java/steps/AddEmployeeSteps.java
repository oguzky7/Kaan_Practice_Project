package steps;

import io.cucumber.datatable.DataTable;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

import static steps.PageInitializer.addEmployee;
import static steps.PageInitializer.dashboard;
import static utils.CommonMethods.click;
import static utils.CommonMethods.sendText;

public class AddEmployeeSteps {
    @When("user clicks on Add Employee button")
    public void user_clicks_on_add_employee_button() {
        click(dashboard.addEmployeeOption);
    }

    @When("user enter firstname and lastname")
    public void user_enter_firstname_and_lastname() {
        sendText(addEmployee.firstNameField, "joshpan");
        sendText(addEmployee.lastNameField, "veranullah");
    }
    @When("user clicks on save button")
    public void user_clicks_on_save_button() {
        click(addEmployee.saveButton);
    }
    @Then("employee added successfully")
    public void employee_added_successfully() {
        System.out.println("Employee Added");
    }
    @When("user enters {string} and {string} for adding multiple employees")
    public void user_enters_and_for_adding_multiple_employees(String string, String string2) {
    }

    @When("user enters {string} and {string}")
    public void user_enters_and(String firstName, String lastName) {
        sendText(addEmployee.firstNameField, firstName);
        sendText(addEmployee.lastNameField, lastName);
    }

    @When("user enter {string} and {string}")
    public void user_enter_and(String string, String string2) {

    }

    @When("user captures employee id")
    public void user_captures_employee_id() {

    }
    @When("added employee is displayed in database")
    public void added_employee_is_displayed_in_database() {

    }

    @When("user adds multiple employees and verify they are added successfully")
    public void user_adds_multiple_employees_and_verify_they_are_added_successfully(DataTable dataTable) {

    }
    @When("user adds multiple employee from excel using {string} and verify it")
    public void user_adds_multiple_employee_from_excel_using_and_verify_it(String string) {

    }


}
