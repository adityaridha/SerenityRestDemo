package api.stepdef.reqresin;

import api.service.reqresin.Reqresin;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Then;

import static net.serenitybdd.rest.SerenityRest.restAssuredThat;
import static org.hamcrest.Matchers.equalTo;

public class ReqresinStepDef {

    Reqresin reqresin = new Reqresin();

    @And("user send PUT Update request to reqresin")
    public void putUpdate() {
        reqresin.putUpdate();
    }

    @And("user send POST login request to reqresin")
    public void postlogin() {
        reqresin.postLogin();
    }

    @And("user send GET Users request to reqresin")
    public void getUsers() {
        reqresin.getListUser();
    }

    @Then("response status code should be {int}")
    public void statusCodeValidation(int statusCode) {
        restAssuredThat(response -> response.statusCode(statusCode));
    }

    @Then("^response path \"([^\"]*)\" should contain Int value \"([^\"]*)\"$")
    public void responseDataValidationInt(String path, String value) {
        restAssuredThat(response -> response.body(path, equalTo(Integer.parseInt(value))));
    }

    @Then("^response path \"([^\"]*)\" should contain String value \"([^\"]*)\"$")
    public void responseDataValidationString(String path, String value) {
        restAssuredThat(response -> response.body(path, equalTo(value)));
    }
}
