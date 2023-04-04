package steps;

import io.cucumber.datatable.DataTable;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import utils.CommonMethods;
import utils.DBUtility;
import utils.ExcelReader;
import utils.Constants;

import java.util.Iterator;
import java.util.List;
import java.util.Map;

public class AddEmployeeSteps extends CommonMethods {
    String id;
    String fName, lName;

    @When("user clicks on Add Employee button")
    public void user_clicks_on_add_employee_button() {
        click(dashboard.addEmployeeOption);
    }

    @When("user enters firstname and lastname")
    public void user_enters_firstname_and_lastname() {
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
        //Assert confirm somehow
    }

    @When("user enters {string} and {string} for adding multiple employees")
    public void user_enters_and_for_adding_multiple_employees(String firstName, String lastName) {
        sendText(addEmployee.firstNameField, firstName);
        sendText(addEmployee.lastNameField, lastName);
    }

    @When("user enters {string} and {string}")
    public void user_enters_and(String firstName, String lastName) {
        fName=firstName;
        lName=lastName;
        sendText(addEmployee.firstNameField, firstName);
        sendText(addEmployee.lastNameField, lastName);
    }

    @When("user captures employee id")
    public void user_captures_employee_id() {
        id = addEmployee.empIdLocator.getAttribute("value");
    }

    @When("user adds multiple employees and verify they are added successfully")
    public void user_adds_multiple_employees_and_verify_they_are_added_successfully(DataTable dataTable) throws InterruptedException {
        List<Map<String, String>> employeeNames = dataTable.asMaps();
        //System.out.println(employeeNames);
        for (Map<String, String> employee : employeeNames) {
            //getting the  keys and values from every map
            String firstNameValue = employee.get("firstName");
            String middleNameValue = employee.get("middleName");
            String lastNameValue = employee.get("lastName");
            //System.out.println(employee);
            sendText(addEmployee.firstNameField, firstNameValue);
            sendText(addEmployee.middleNameField, middleNameValue);
            sendText(addEmployee.lastNameField, lastNameValue);

            click(addEmployee.saveButton);
            click(dashboard.addEmployeeOption);

        }
    }

    @When("user adds multiple employee from excel using {string} and verify it")
    public void user_adds_multiple_employee_from_excel_using_and_verify_it(String sheetName) throws InterruptedException {
        List<Map<String, String>> empFromExcel = ExcelReader.excelListIntoMap(Constants.TESTDATA_FILEPATH, sheetName);

        Iterator<Map<String, String>> itr = empFromExcel.iterator();
        for (int j= 0; j<ExcelReader.getRowCount()-1; j++) {
            System.out.println(ExcelReader.getRowCount());
            //it returns the key and value for employee from excel
            Map<String, String> mapNewEmp = itr.next();
            sendText(addEmployee.firstNameField, mapNewEmp.get("firstName"));
            sendText(addEmployee.middleNameField, mapNewEmp.get("middleName"));
            sendText(addEmployee.lastNameField, mapNewEmp.get("lastName"));
            String empIdValue = addEmployee.empIdLocator.getAttribute("value");
            sendText(addEmployee.photograph, mapNewEmp.get("photograph"));
            if (!addEmployee.checkBox.isSelected()) {
                click(addEmployee.checkBox);
            }
            sendText(addEmployee.createUsernameField, mapNewEmp.get("username"));
            sendText(addEmployee.createPasswordField, mapNewEmp.get("password"));
            sendText(addEmployee.confirmPasswordField, mapNewEmp.get("confirmPassword"));

            click(addEmployee.saveButton);
            System.out.println("click taken on save button");
            Thread.sleep(1500);

            click(dashboard.empListOption);
            System.out.println("click taken on emp list option");

            //to search the employee, we use emp id what we captured from attribute
            Thread.sleep(1500);
            sendText(employeeList.empSearchIdField, empIdValue);
            click(employeeList.searchButton);

            List<WebElement> rowData = driver.findElements(By.xpath("//*[@id='resultTable']/tbody/tr"));


            for (int i = 0; i < rowData.size(); i++) {
                System.out.println("I am inside the loop and worried about josh");
                //getting the text of every element from here and storing it into string
                String rowText = rowData.get(i).getText();


                String expectedData = empIdValue + " " + mapNewEmp.get("firstName") + " " + mapNewEmp.get("middleName") + " " + mapNewEmp.get("lastName");
                //verifying the exact details  of the employee
                Assert.assertEquals(expectedData, rowText);
           }
            click(dashboard.addEmployeeOption);
        }
    }

    @When("added employee is displayed in database")
    public void added_employee_is_displayed_in_database() {
        String query = DatabaseSteps.getFnameLnameQuery() + id;
        List<Map<String, String>> dataFromDatabase = DBUtility.getListOfMapsFromRset(query);

        String fNameFromDb = dataFromDatabase.get(0).get("emp_firstname");
        String lNameFromDb = dataFromDatabase.get(0).get("emp_lastname");

        Assert.assertEquals(fName, fNameFromDb);
        Assert.assertEquals(lName, lNameFromDb);
    }


}
