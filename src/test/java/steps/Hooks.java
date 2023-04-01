package steps;


import io.cucumber.java.Before;
import io.cucumber.java.After;
import utils.CommonMethods;

public class Hooks extends CommonMethods {

    @Before
    public void preCondition(){
        openBrowserAndLaunchApplication();
    }

    @After
    public void postCondition() throws InterruptedException {
        //Thread.sleep(2000);
        closeBrowser();

    }

}
