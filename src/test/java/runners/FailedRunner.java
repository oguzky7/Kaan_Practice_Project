package runners;


import io.cucumber.junit.Cucumber;
import io.cucumber.junit.CucumberOptions;
import org.junit.runner.RunWith;

//this runner class is responsible to run only failed test cases
@RunWith(Cucumber.class)
@CucumberOptions(
        //features we use to provide the path of all the feature files
        features = "@target/failed.txt",
        glue = "steps",
       monochrome = true,
        plugin = {"pretty"}
)
public class FailedRunner {
}
