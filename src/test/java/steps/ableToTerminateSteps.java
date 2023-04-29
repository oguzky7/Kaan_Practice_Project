package steps;

import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.junit.Assert;
import utils.CommonMethods;
import utils.ConfigReader;

public class ableToTerminateSteps extends CommonMethods {
    @When("admin click on PIM option")
    public void admin_click_on_pim_option() {
        click(dashboard.pimTab);
    }

    @When("admin clicks on any employee id")
    public void admin_clicks_on_any_employee_id() {
        click(employeeList.randomEmpSelect);
    }
    @When("admin clicks on Job tab")
    public void admin_clicks_on_job_tab() {
        click(employeeList.jobTab);
    }
    @When("admin clicks on Terminate Employment button")
    public void admin_clicks_on_terminate_employment_button() {
        click(employeeCurrentJobPage.terminateEmploymentBtn);
    }
    @When("admin verifies Reasons dropdown is displayed and select a value from it")
    public void admin_verifies_reasons_dropdown_is_displayed_and_select_a_value_from_it() {
        isElementEnable(employeeCurrentJobPage.terminateReason);
        assertThatElementIsDisplayed(employeeCurrentJobPage.terminateReason);
        dropDownSelectByVisibleText(employeeCurrentJobPage.terminateReason, ConfigReader.getPropertyValue("TerminateReason"));
    }
    @When("admin verifies Calendar is displayed and user can pick values from there")
    public void admin_verifies_calendar_is_displayed_and_user_can_pick_values_from_there() {
        isElementEnable(employeeCurrentJobPage.terminateDate);
        assertThatElementIsDisplayed(employeeCurrentJobPage.terminateDate);
        calendar(employeeCurrentJobPage.terminateDate, employeeCurrentJobPage.monthLocator1, employeeCurrentJobPage.yearLocator1,
                "month_Terminate", "year_Terminate", employeeCurrentJobPage.listOfDate1, "day_Terminate");

    }
    @When("admin verify Note textBox field is displayed and enter values there")
    public void admin_verify_note_text_box_field_is_displayed_and_enter_values_there() {
        isElementEnable(employeeCurrentJobPage.terminateNote);
        assertThatElementIsDisplayed(employeeCurrentJobPage.terminateNote);
        sendText(employeeCurrentJobPage.terminateNote, ConfigReader.getPropertyValue("TerminateNote"));
    }
    @When("admin click on Confirm button")
    public void admin_click_on_confirm_button() {
        click(employeeCurrentJobPage.terminateEmploymentConfirmBtn);
    }
    @Then("verifies if employee Terminated")
    public void verifies_if_employee_terminated() {
        assertThatElementText(employeeCurrentJobPage.terminationSuccesfullMessage, ConfigReader.getPropertyValue("terminationVerificationMessage"));
        isElementEnable(employeeCurrentJobPage.activateEmploymentBtn);
        assertThatElementText(employeeCurrentJobPage.terminatedMessage, "Terminated on : " + ConfigReader.getPropertyValue("year_Terminate") + "-" +
                StringMonthToInt(ConfigReader.getPropertyValue("month_Terminate")) + "-" + ConfigReader.getPropertyValue("day_Terminate"));

    }
    @Then("clicks Activate Employment button again to change back to default setting of the employee")
    public void clicks_activate_employment_button_again_to_change_back_to_default_setting_of_the_employee() {
        click(employeeCurrentJobPage.activateEmploymentBtn);
    }
}
