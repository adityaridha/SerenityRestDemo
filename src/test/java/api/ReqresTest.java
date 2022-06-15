package api;

import io.restassured.RestAssured;
import io.restassured.module.jsv.JsonSchemaValidator;
import io.restassured.response.Response;
import org.json.JSONObject;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

import static org.hamcrest.Matchers.equalTo;

public class ReqresTest {

    Reqres reqres =  new Reqres();

    @BeforeAll
    public static void setup() {
        RestAssured.baseURI = "https://reqres.in/api";
    }

    @Test
    public void test_get_list_users() {
        Response response = RestAssured.get("/users?page=2");
        assert response.statusCode() == 200;
        assert (Integer) response.body().jsonPath().get("per_page") == 6;
        System.out.println(response.getTime());
        response.then().assertThat().body(JsonSchemaValidator.matchesJsonSchemaInClasspath("schema/users.json"));
    }

    @Test
    public void test_get_single_user() {
        RestAssured.get("/users/2")
                .then().log().body()
                .statusCode(200)
                .body("data.id", equalTo(2))
                .body(JsonSchemaValidator.matchesJsonSchemaInClasspath("schema/single-user.json"));
    }

    @Test

    public void test_post_login() {
        JSONObject body = new JSONObject();
        body.put("email", "eve.holt@reqres.in");
        body.put("password", "cityslicka");

        Response response = RestAssured.given().headers("Content-type", "application/json").
                body(body.toString()).post("/register");
        response.then().assertThat().body(JsonSchemaValidator.matchesJsonSchemaInClasspath("schema/login.json"));
    }

    @Test
    public void test_get_delayed_response() {
        Response response = reqres.getDelayedResponse();
        response.prettyPrint();
    }
}
