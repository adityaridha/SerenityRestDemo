package api.service.reqresin;

import io.restassured.RestAssured;

public class ReqresinAPI {

    private static String REQRESIN_BASEURL = "https://reqres.in/";

    public void getListUser() {
        RestAssured.get(REQRESIN_BASEURL + "users?page=2");
    }



}
