package steps;

import io.cucumber.datatable.DataTable;
import io.cucumber.java.en.Then;
import org.junit.Assert;
import org.openqa.selenium.WebElement;

import java.util.ArrayList;
import java.util.List;

import static steps.PageInitializer.dashboard;

public class DashboardSteps {

    @Then("user verifies dashboard page")
    public void user_verifies_dashboard_page() {
        Assert.assertEquals(dashboard.dashboardTitle.getText(),"Dashboard");
    }

    @Then("user verifies all the dashboard tabs")
    public void user_verifies_all_the_dashboard_tabs(DataTable dataTable) {
        List<String> expectedTabs = dataTable.asList();
        List<String> actualTabs = new ArrayList<>();


        for (WebElement tab :dashboard.dashboardTabs)
        {actualTabs.add(tab.getText());}
        System.out.println(actualTabs);
        System.out.println(expectedTabs);
        Assert.assertEquals(expectedTabs,actualTabs);
        Assert.assertTrue(expectedTabs.equals(actualTabs));
    }
}
