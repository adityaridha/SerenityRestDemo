package api.stepdef.reqresin;

import io.cucumber.java.en.Then;

import static io.restassured.module.jsv.JsonSchemaValidator.matchesJsonSchemaInClasspath;
import static net.serenitybdd.rest.SerenityRest.restAssuredThat;
import static org.hamcrest.Matchers.*;

public class ReqresinValidationStepDef {

    // Validation

    @Then("response status code should be {int}")
    public void statusCodeValidation(int statusCode) {
        restAssuredThat(response -> response.statusCode(statusCode));
    }

    @Then("response path {string} should contain Int value {int}")
    public void responseDataValidationInt(String path, int value) {
        restAssuredThat(response -> response.body(path, any(Integer.class)));
        restAssuredThat(response -> response.body(path, equalTo(value)));
    }

    @Then("^response path \"([^\"]*)\" should contain String value \"([^\"]*)\"$")
    public void responseDataValidationString(String path, String value) {
        restAssuredThat(response -> response.body(path, any(String.class)));
        restAssuredThat(response -> response.body(path, equalTo(value)));
    }

    @Then("^response structure should match json schema \"([^\"]*)\"$")
    public void validateJsonSchema(String schema) {
        String path = String.format("schema/%s", schema);
        restAssuredThat(response -> response.assertThat().body(matchesJsonSchemaInClasspath(path)));
    }

}
