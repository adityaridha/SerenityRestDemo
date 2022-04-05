package api.stepdef;

import api.service.postcodes.LocationResponse;
import api.service.postcodes.PostCodeAPI;
import api.service.reqresin.ReqresinAPI;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import net.thucydides.core.annotations.Steps;

import static net.serenitybdd.rest.SerenityRest.restAssuredThat;
import static org.hamcrest.Matchers.equalTo;

public class PostCodeStepDefinitions {

    @Steps
    PostCodeAPI postCodeAPI;

    ReqresinAPI reqresinAPI = new ReqresinAPI();

    @When("I look up a post code {word} for country code {word}")
    public void lookUpAPostCode(String postCode, String country) {
        postCodeAPI.fetchLocationByPostCodeAndCountry(postCode, country);
    }

    @Then("the resulting location should be {} in {}")
    public void theResultingLocationShouldBe(String placeName, String country) {
        restAssuredThat(response -> response.statusCode(200));
        restAssuredThat(response -> response.body(LocationResponse.COUNTRY, equalTo(country)));
        restAssuredThat(response -> response.body(LocationResponse.FIRST_PLACE_NAME, equalTo(placeName)));
    }

    @Given("user is on registration page")
    public void userIsOnRegistrationPage() {
        System.out.println("User berada di halaman register");
    }

    @And("user call reqresin API")
    public void callReqresIn() {
        reqresinAPI.getListUser();
    }

}
