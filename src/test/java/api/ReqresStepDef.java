package api;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import io.restassured.module.jsv.JsonSchemaValidator;
import org.junit.Assert;
import java.io.File;

public class ReqresStepDef {

    Reqres reqres = new Reqres();

    @Given("user send GET list user request")
    public void user_send_get_list_user_request() {
        reqres.getListUser();
    }

    @Then("response status code should be {int}")
    public void responseStatusCodeShouldBe(int statusCode) {
        Reqres.response.then().log().body();
        Assert.assertEquals(statusCode, Reqres.response.statusCode());
    }

    @And("response body with jsonPath {string} should be equal {int}")
    public void responseBodyWithJsonPathShouldBeEqual(String jsonPath, int expectedData) {
        int actualData = Reqres.response.body().jsonPath().get(jsonPath);
    }

    @And("response body with jsonPath {string} should be equal {string}")
    public void responseBodyWithJsonPathShouldBeEqual(String jsonPath, String expectedData) {
        String actualData = Reqres.response.body().jsonPath().get(jsonPath);
        Assert.assertEquals(expectedData, actualData);
    }

    @When("user send POST login request with body")
    public void userSendPOSTLoginRequestWithBody() {
    }

    @And("response body with jsonPath {string} should have type String")
    public void responseBodyWithJsonPathShouldHaveTypeString(String jsonPath) {
        assert Reqres.response.body().jsonPath().get(jsonPath) instanceof String;
    }

    @When("user send POST login request with body {string}")
    public void userSendPOSTLoginRequestWithBody(String bodyName) {
        File bodyJson = new File(String.format("src/test/resources/payload/%s", bodyName));
        reqres.postLogin(bodyJson);
    }

    @And("response body should be equal with jsonSchema {string}")
    public void responseBodyShouldBeEqualWithJsonSchema(String jsonSchema) {
        String path = "schema/" + jsonSchema;
        Reqres.response.then().body(JsonSchemaValidator.matchesJsonSchemaInClasspath(path));
    }
}
