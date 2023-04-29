package pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import utils.CommonMethods;

public class EmployeeListPage extends CommonMethods {

    @FindBy(id="empsearch_id")
    public WebElement empSearchIdField;

    @FindBy(id="empsearch_employee_name_empName")
    public WebElement empSearchNameField;

    @FindBy(id="searchBtn")
    public WebElement searchButton;

    @FindBy(xpath = "//table[@id='resultTable']/tbody/tr[2]/td[2]")
    public WebElement randomEmpSelect;

    @FindBy(xpath = "//div[@id='sidebar']/ul/li[6]/a")
    public WebElement jobTab;



    public EmployeeListPage(){
        PageFactory.initElements(driver,this);
    }

}

