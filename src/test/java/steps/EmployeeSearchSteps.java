package steps;

import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

import static steps.PageInitializer.dashboard;
import static steps.PageInitializer.employeeList;
import static utils.CommonMethods.click;
import static utils.CommonMethods.sendText;

public class EmployeeSearchSteps {
    @When("user clicks on PIM option")
    public void user_clicks_on_pim_option() {
        click(dashboard.pimTab);
    }
    @When("user clicks on EmployeeList option")
    public void user_clicks_on_employee_list_option() {
        click(dashboard.empListOption);
    }
    @When("user enters valid employee id")
    public void user_enter_valid_employee_id() {
        sendText(employeeList.empSearchIdField, "52381A");
    }

    @When("user enters valid employee name")
    public void user_enter_valid_employee_name() {
        sendText(employeeList.empSearchNameField, "ms");
    }
    @When("user clicks on search button")
    public void user_clicks_on_search_button() {
        click(employeeList.searchButton);
    }
    @Then("user sees employee information is displayed")
    public void user_sees_employee_information_is_displayed() {
        System.out.println("Employee information can be seen");
    }
}
