package api;

import io.restassured.RestAssured;
import io.restassured.response.Response;
import org.json.JSONObject;

import java.io.File;

public class Reqres {

    public static Response response;

    public void getListUser() {
        response = RestAssured.get("/users/2");
    }

    public void postLogin(File body) {
        response = RestAssured.given()
                .header("Content-type", "application/json")
                .body(body)
                .post("/login");
    }
}
