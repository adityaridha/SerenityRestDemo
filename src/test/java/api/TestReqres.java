package api;

import io.restassured.RestAssured;
import io.restassured.response.Response;
import org.json.JSONObject;
import org.junit.jupiter.api.Test;

import static org.hamcrest.Matchers.equalTo;

public class TestReqres {

    @Test
    public void test_get_list_users() {
        System.out.println("Execute test satu");
        Response response = RestAssured.get("https://reqres.in/api/users?page=2");

        response.body().prettyPrint();

        int statusCode = response.statusCode();
        int dataPerPage = response.body().jsonPath().get("per_page");

        assert statusCode == 200;
        assert dataPerPage == 6;

        System.out.println(statusCode);
        System.out.println(response.body().jsonPath().get("data[0].id").toString());
    }

    @Test
    public void test_post_login() {
        JSONObject body = new JSONObject();
        body.put("email", "eve.holt@reqres.in");
        body.put("password", "cityslicka");

        Response response = RestAssured.given().headers("Content-type", "application/json").
                body(body.toString()).post("https://reqres.in/api/register");

        response.body().prettyPrint();
    }

    @Test
    public void test_get_single_user() {
        RestAssured.get("https://reqres.in/api/users/2")
                .then()
                .statusCode(200)
                .body("data.id", equalTo(2));
    }

}
