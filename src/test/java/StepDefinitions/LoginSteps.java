package StepDefinitions;

import Pages.LoginPage;
import Utilities.GWD;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

public class LoginSteps {

    LoginPage lp =new LoginPage();

    @Given("Navigate to Web Page")
    public void navigateToWebPage()
    {
        GWD.getDriver().get("http://the-internet.herokuapp.com/login");
        GWD.getDriver().manage().window().maximize();
    }

    @When("User Enter Username and Password and Click Button")
    public void UserEnterUsernameAndPasswordAndClickButton()
    {
        lp.findAndSend("username","tomsmith");
        lp.findAndSend("password","SuperSecretPassword!");
        lp.findAndClick("loginButton");

    }

    @Then("User Should Login Successfully")
    public void userShouldLoginSuccessfully()
    {
        lp.findAndVerify("successMessage","Welcome");
    }

    @When("User Enter invalid Username or Password and Click Button")
    public void UserEnterInvalidUsernameOrPasswordAndClickButton()
    {
        lp.findAndSend("username","aziz");
        lp.findAndSend("password","SuperSecretPassword!");
        lp.findAndClick("loginButton");
    }

    @Then("User Should Not Login Successfully")
    public void userShouldNotLoginSuccessfully()
    {
        lp.findAndVerify("invalidData","invalid");
    }

    @When("User Enter Username {string} and Password {string} and Click Button")
    public void userEnterUsernameAndPasswordAndClickButton(String name, String password)
    {
        lp.findAndSend("username",name);
        lp.findAndSend("password",password);
        lp.findAndClick("loginButton");
    }

}
