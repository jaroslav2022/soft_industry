package starter.stepdefinitions;

import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import net.serenitybdd.rest.SerenityRest;
import net.thucydides.core.annotations.Steps;

import static net.serenitybdd.rest.SerenityRest.restAssuredThat;
import static org.hamcrest.Matchers.*;

public class SearchStepDefinitions {

    @Steps
    public CarsAPI carsAPI;

    @When("he calls endpoint {string}")
    public void heCallsEndpoint(String arg0) {
        SerenityRest.given().get(arg0);
    }

    @Then("he sees the results displayed for apple")
    public void heSeesTheResultsDisplayedForApple() {
        restAssuredThat(response -> response.statusCode(200));
    }

    @Then("he sees the results displayed for mango")
    public void heSeesTheResultsDisplayedForMango() {
        restAssuredThat(response ->
                response.body("title", hasItem("AH Mango")));
    }
    @Then("he sees the total number of results for mango")
    public void heSeesMangoTotal() {
        restAssuredThat(response ->
                response.body("title", iterableWithSize(46)));
    }

    @Then("he sees the total number of results for coop mango")
    public void heSeesCoopMangoTotal() {
        restAssuredThat(response ->
                response.body("provider.findAll{it=='Coop'}", iterableWithSize(20)));
    }

    @Then("he does not see the results")
    public void he_Does_Not_See_The_Results() {
        restAssuredThat(response -> response.body("detail.error", equalTo(true)));
    }
}
