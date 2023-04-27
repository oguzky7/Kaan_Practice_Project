package runners;


import io.cucumber.junit.Cucumber;
import io.cucumber.junit.CucumberOptions;
import org.junit.runner.RunWith;

@RunWith(Cucumber.class)
@CucumberOptions(
        features = "src/test/resources/features/",  //to provide the path of al the feature files
        glue = {"steps"},
        dryRun = false,                              //When dryRun is true, it means the actual execution stops, it will only run/check the code if everything is fine.
                                                    //Mostly used for to check gherkin steps whether they are implemented or not
        tags = "@Test10",
        monochrome = true,                          //to remove irrelevant information from console
        plugin = {"pretty", "html:target/cucumber.html", "json:target/cucumber.json", "rerun:target/failed.txt"}
        //pretty keyword prints the steps in a human-readable way
)

public class SmokeRunner {

}
