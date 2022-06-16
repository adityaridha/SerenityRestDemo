package api;

import io.restassured.RestAssured;
import io.restassured.module.jsv.JsonSchemaValidator;
import io.restassured.response.Response;
import org.json.JSONObject;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

import static org.hamcrest.Matchers.equalTo;

public class ReqresTest {

    Reqres reqres = new Reqres();

    @BeforeAll
    public static void setup() {
        RestAssured.baseURI = "https://reqres.in/api";
    }

    @Test
    public void test_get_list_users() {
        Response response = RestAssured.get("/users?page=2");
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
    }

    @Test
    public void test_get_single_resource() {
        // 1. Request API
        Response response = RestAssured.get("/unknown/2");

        // 2. Validasi API
        System.out.println(response.body().asPrettyString());
        Assertions.assertEquals(response.statusCode(), 200);

        int userId = response.body().jsonPath().get("data.id");
        String userName = response.body().jsonPath().get("data.name");
        Assertions.assertEquals(response.headers().getValue("Server"), "cloudflare");
        Assertions.assertEquals(userId, 2);
        Assertions.assertEquals(userName, "fuchsia rose");
        assert response.getTime() < 5000;
    }

    @Test
    public void test_get_single_resource_2() {
        RestAssured.get("/unknown/2").then().statusCode(200);
    }

    @Test
    public void test_post_create() {
        JSONObject bodyData = new JSONObject();

        bodyData.put("name", "morpheus");
        bodyData.put("job", "leader");

        Response response = RestAssured.given()
                .body(bodyData.toString())
                .post("/users");

        Assertions.assertEquals(response.statusCode(), 201);
    }

    @Test
    public void test_post_register() {
        Response response = reqres.postRegister("eve.holt@reqres.in", "pistol");
        response.prettyPrint();
        response = reqres.postRegister("adit@reqres.in", "pistol");
        response.prettyPrint();

        if (response.statusCode() == 200) {
            response.then().body(JsonSchemaValidator.matchesJsonSchemaInClasspath("schema/register.json"));
        } else {
            response.then().body(JsonSchemaValidator.matchesJsonSchemaInClasspath("schema/register-failed.json"));
        }

    }
}
