package api;

import io.restassured.RestAssured;
import io.restassured.response.Response;
import org.json.JSONObject;

public class Reqres {

    public Response getDelayedResponse() {
        return RestAssured.get("https://reqres.in/api/users?delay=1");
    }

    public Response postRegister(String email, String password) {
        JSONObject bodyData = new JSONObject();
        bodyData.put("email", email);
        bodyData.put("password", password);

        return RestAssured.given()
                .headers("Content-type", "application/json")
                .body(bodyData.toString())
                .post("https://reqres.in/api/register");
    }
}
