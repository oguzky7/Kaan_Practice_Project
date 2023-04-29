package pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import utils.CommonMethods;
import java.util.List;

import static utils.CommonMethods.driver;

public class employeeCurrentJobPage extends CommonMethods {
    @FindBy(linkText="Job")
    public WebElement jobOptionBtn;

    @FindBy(id="btnSave")
    ////input[@id='btnSave']
    public WebElement editBtn;

    @FindBy(id="job_job_title")
    //select[@id='job_job_title']
    public WebElement jobTitleDropDown;

    @FindBy(id="job_emp_status")
    //select[@id='job_emp_status']
    public WebElement employmentStatusDropDown;

    @FindBy(id="job_eeo_category")
    //select[@id='job_eeo_category']
    public WebElement jobCategoryDropDown;



    @FindBy(xpath = "//input[@id='job_joined_date']")
    public WebElement joinedDateCalendar1;
    @FindBy(xpath = "//select[@class='ui-datepicker-month']")
    public WebElement monthLocator1;
    @FindBy(xpath = "//select[@class='ui-datepicker-year']")
    public WebElement yearLocator1;
    @FindBy(xpath = "//table[@class ='ui-datepicker-calendar']/tbody/tr/td/a")
    public List<WebElement>listOfDate1;

    @FindBy(xpath = "//select[@name='job[sub_unit]']")
    public WebElement subUnitDropDown;

    @FindBy(id="job_location")
    //select[@id='job_location']
    public WebElement locationDropDown;

    @FindBy(xpath=" //input[@name='job[contract_start_date]']")
    public WebElement startDateCalendar;

    @FindBy(name="job[contract_end_date]")
    //input[@name='job[contract_end_date]']
    public WebElement endDateCalendar;

    @FindBy(id="job_contract_file")
    //input[@id='job_contract_file']
    public WebElement contractDetailsFile;

    @FindBy(id="btnSave")
    //input[@id='btnSave']
    public WebElement saveCurrentJob;
    @FindBy(xpath = "//select[@id=('terminate_reason')]")
    public WebElement terminateReason;

    @FindBy(xpath = "//input[@id=('terminate_date')]")
    public WebElement terminateDate;
    @FindBy(xpath = "//input[@id='btnTerminateEmployement']")
    public WebElement terminateEmploymentBtn;
    @FindBy(xpath = "//input[@id='dialogConfirm']")
    public WebElement terminateEmploymentConfirmBtn;

    @FindBy(xpath = "//textarea[@id=('terminate_note')]")
    public WebElement terminateNote;

    @FindBy(xpath = "//a[contains(.,'Terminated')]")
    public WebElement terminatedMessage;

    @FindBy(xpath = "//a[contains(@href,'employeeId')]")
    public WebElement arrangeByNameOption;
    @FindBy(xpath = "//input[@value='Activate Employment']")
    public WebElement activateEmploymentBtn;

    @FindBy(xpath = "//*[@class = 'message success fadable']")
    public WebElement terminationSuccesfullMessage;

    @FindBy(xpath = "//*[@class = 'message success fadable']")
    public WebElement verificationMessage;


    public employeeCurrentJobPage() {
        PageFactory.initElements(driver, this);
    }
}