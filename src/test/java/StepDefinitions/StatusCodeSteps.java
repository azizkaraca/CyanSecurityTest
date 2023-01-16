package StepDefinitions;

import Pages.StatusCodePage;
import Utilities.GWD;
import io.cucumber.datatable.DataTable;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

import java.util.List;

public class StatusCodeSteps {

    StatusCodePage sc=new StatusCodePage();

    @Given("Navigate to Status Code Page")
    public void navigateToStatusCodePage() {
        GWD.getDriver().get("http://the-internet.herokuapp.com/status_codes");
        GWD.getDriver().manage().window().maximize();
    }

    @When("User Click the Code")
    public void userClickTheCode(DataTable elements) {

        List<String> listElement=elements.asList(String.class);

        for (int i = 0; i < listElement.size(); i++) {
            sc.findAndClick(listElement.get(i));
        }
    }

    @Then("Verify User reach the Clicked Code")
    public void verifyUserReachTheClickedCode(DataTable elements) {

        List<List<String>> listElement=elements.asLists(String.class);

        for (int i = 0; i < listElement.size(); i++)
            sc.findAndVerify(listElement.get(i).get(0),listElement.get(i).get(1));

    }

    @And("Back to Main Page")
    public void backToMainPage(DataTable elements) {

        List<String> listElement=elements.asList(String.class);

        for (int i = 0; i < listElement.size(); i++) {
            sc.findAndClick(listElement.get(i));
        }
    }
}
