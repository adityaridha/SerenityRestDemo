package api;

import io.restassured.RestAssured;
import io.restassured.response.Response;

public class Reqres {

    public Response getDelayedResponse() {
        return RestAssured.get("https://reqres.in/api/users?delay=1");
    }
}
