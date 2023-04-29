package utils;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.apache.commons.io.FileUtils;
import org.apache.log4j.xml.DOMConfigurator;
import org.junit.Assert;
import org.openqa.selenium.*;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;
import steps.PageInitializer;

import java.io.File;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.concurrent.TimeUnit;

public class CommonMethods extends PageInitializer {
    public static WebDriver driver;

    public static void openBrowserAndLaunchApplication(){
        ConfigReader.readProperties(Constants.CONFIGURATION_FILEPATH);
        switch (ConfigReader.getPropertyValue("browser")){
            case "chrome":
                WebDriverManager.chromedriver().setup();
                //if you want to set it to headless:
                ChromeOptions chromeOptions = new ChromeOptions();
                chromeOptions.addArguments("--no-sandbox");
                chromeOptions.addArguments("--disable-dev-shm-usage");
                chromeOptions.setHeadless(false); //True for headless, false for regular
                //
                driver = new ChromeDriver(chromeOptions /*normally we could leave here empty but since we set headless we need to providethis*/);
                break;

            default:
                throw new RuntimeException("Invalid browser name");
        }
            driver.manage().window().maximize();
            driver.get(ConfigReader.getPropertyValue("url"));
            driver.manage().timeouts().implicitlyWait(Constants.IMPLICIT_WAIT, TimeUnit.SECONDS);
            initializePageObjects();
        DOMConfigurator.configure("log4j.xml");
        Log.startTestCase("My first test case is starting");
        Log.info("My login test is going on");
        Log.warning("My test case might fail");

    }

public static void closeBrowser(){
        Log.info("My test case is about to finish");
        Log.endTestCase("End of Test");
        driver.quit();
}

    public static void sendText(WebElement element, String textToSend) {
        //getWait().until(ExpectedConditions.visibilityOf(element));
        element.clear();
        element.sendKeys(textToSend);
    }
    public static WebDriverWait getWait() {
        WebDriverWait wait = new WebDriverWait(driver, Constants.EXPLICIT_WAIT);
        return wait;
    }
    public static void waitForClickability(WebElement element) {
        getWait().until(ExpectedConditions.elementToBeClickable(element));
    }

    public static void click(WebElement element) {
        waitForClickability(element);
        element.click();
    }
    public static void selectDropdown(WebElement element, String text) {
        Select s = new Select(element);
        s.selectByVisibleText(text);
    }


    public static String getTimeStamp(String pattern) {
        Date date = new Date();
        SimpleDateFormat sdf = new SimpleDateFormat(pattern);
        return sdf.format(date);
    }

    public static byte[] takeScreenshot(String fileName) {
        TakesScreenshot ts = (TakesScreenshot) driver;
        byte[] picBytes = ts.getScreenshotAs(OutputType.BYTES);
        File sourceFile = ts.getScreenshotAs(OutputType.FILE);

        try {
            FileUtils.copyFile(sourceFile,
                    new File(Constants.SCREENSHOT_FILEPATH + fileName + " " +
                            getTimeStamp("yyyy-MM-dd-HH-mm-ss") + ".png"));

        } catch (IOException e) {
            e.printStackTrace();
        }
        return picBytes;
    }
    public static void explicitWait(WebElement element) {
        getWait().until(ExpectedConditions.visibilityOf(element));
    }
    private static WebElement exceptionWrapper(WebElement element) {
		/*
		inner common method - implementation to perform try catch if element is NOT present
		to get proper output on console or log.
		 */
        try {
            explicitWait(element);
        } catch (TimeoutException | NoSuchElementException ex) {
            throw new NoSuchElementException("NO SUCH ELEMENT ON WEBPAGE"
			/* here u can try to implement Log.fail or warning
					and following MSG"NO SUCH ELEMENT ON WEBPAGE");
					 */);
        }
        return element;
    }
    public static void assertThatElementIsDisplayed(WebElement element) {
		/*
		method check is element is displayed on a page (if yes -> true)
		 */
        Assert.assertTrue(exceptionWrapper(element).isDisplayed());
    }
    private static Select getSelect(WebElement element) {
        return new Select(element);
    }
    public static void dropDownSelectByVisibleText(WebElement element, String text) {
		/**
		- FIRST argument -  webelement /SELECT/DROPDOWN/...
		- SECOND argument - target-key (String) that will be selected from the list
		 */
        getSelect(element).selectByVisibleText(text);
    }

    public static void dropDownSelectByIndex(WebElement element, int option_NO) {
		/**
		- FIRST argument -  webelement /SELECT/DROPDOWN/...
		- SECOND argument - target-key (int) that will be selected from the list
		 */
        getSelect(element).selectByIndex(option_NO);
    }
    public static void calendar(WebElement calenderLocator, WebElement monthElement, WebElement yearElement, String keyMonth,
                                String keyYear, List<WebElement> listOfDate, String keyDate){
        click(calenderLocator);
        dropDownSelectByVisibleText(monthElement,ConfigReader.getPropertyValue(keyMonth));
        dropDownSelectByVisibleText(yearElement,ConfigReader.getPropertyValue(keyYear));
        for(WebElement dates:listOfDate){
            String  date = dates.getText();
            if(date.equalsIgnoreCase(ConfigReader.getPropertyValue(keyDate))){
                click(dates);
                break;
            }

        }
    }
    public static void assertThatElementText(WebElement element_WithActualText, String expectedText) {
		/*
		here method checks is text that webElement contains match to expected text
		!!!! YOU DON'T NEED TO INPUT .getText() -> method do it implicitly, just provide WebElement
		 */

        Assert.assertEquals(expectedText,
                exceptionWrapper(element_WithActualText).getText());
    }
    public static String StringMonthToInt (String shortForMonth){
        //This method changes 3 digit Month shortcuts to numeric values but as a String again.
        // That way we can convert it when we are writing only numeric dates
        String result = "";
        Map<String, String> map = new HashMap<String, String>();
        map.put("Jan", "01");
        map.put("Feb", "02");
        map.put("Mar", "03");
        map.put("Apr", "04");
        map.put("May", "05");
        map.put("Jun", "06");
        map.put("Jul", "07");
        map.put("Aug", "08");
        map.put("Sep", "09");
        map.put("Oct", "10");
        map.put("Nov", "11");
        map.put("Dec", "12");

        for (String month : map.keySet()) {
            if (shortForMonth.equals(month)) {
                result = map.get(month);
                break;
            }
        }
        return result;
    }
    public static void isElementEnable(WebElement element) {
        Assert.assertTrue(exceptionWrapper(element).isEnabled());
    }

}
