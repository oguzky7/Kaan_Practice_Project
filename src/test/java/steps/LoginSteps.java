package steps;

import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.junit.Assert;
import org.omg.CORBA.DynAnyPackage.Invalid;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import pages.LoginPage;
import sun.security.util.Password;
import utils.ConfigReader;

import static steps.PageInitializer.*;
import static utils.CommonMethods.*;

public class LoginSteps {

    @When("user enters valid username and valid password")
    public void user_enters_valid_username_and_valid_password() {
        sendText(login.usernameTextField, ConfigReader.getPropertyValue("username"));
        sendText(login.passwordTextField, ConfigReader.getPropertyValue("password"));
    }

    @When("user clicks on login button")
    public void user_clicks_on_login_button() {
        click(login.loginButton);
    }

    @Then("user is successfully logged in")
    public void user_is_successfully_logged_in() {
        Assert.assertEquals(dashboard.welcomeMessage.getText(),"Welcome Admin");
    }

    @When("user enters ess username and ess password")
    public void user_enters_ess_username_and_ess_password() {
        sendText(login.usernameTextField,"admin");
        sendText(login.passwordTextField,"Hum@nhrm123");
    }



    @When("user enters invalid username and password")
    public void user_enters_invalid_username_and_password() {
        sendText(login.usernameTextField,"admin123");
        sendText(login.passwordTextField,"Hum@nhrm");
    }

    @Then("error message displayed")
    public void error_message_displayed() {
        Assert.assertEquals(login.errorMessage.getText(),"Invalid credentials");
        System.out.println(login.errorMessage.getText());
    }


    @When("user enters different {string} and {string} and verify the {string} for it")
    public void user_enters_different_and_and_verify_the_for_it(String username, String password, String errorMessage) {
        sendText(login.usernameTextField, username);
        sendText(login.passwordTextField, password);
        click(login.loginButton);

        String errorActual =  login.errorMessage.getText();
        Assert.assertEquals(errorMessage, errorActual);
    }

}
