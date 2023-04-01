package pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import java.util.List;

import static utils.CommonMethods.driver;

public class DashboardPage {
    @FindBy (id = "welcome") public WebElement welcomeMessage;
    @FindBy (xpath = "//div[@class= 'head']/h1") public WebElement dashboardTitle;
    @FindBy (id = "menu_pim_viewPimModule")      public WebElement pimTab;
    @FindBy (id="menu_pim_viewEmployeeList")     public WebElement empListOption;
    @FindBy (id="menu_pim_addEmployee")          public WebElement addEmployeeOption;
    @FindBy (xpath = "//b[contains(text(),'')]") public List<WebElement> dashboardTabs;


    public DashboardPage(){
        PageFactory.initElements(driver,this);
    }
}
