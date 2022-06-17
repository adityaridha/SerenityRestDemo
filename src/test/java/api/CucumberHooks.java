package api;

import io.cucumber.java.After;
import io.cucumber.java.AfterAll;
import io.cucumber.java.Before;
import io.cucumber.java.BeforeAll;
import io.restassured.RestAssured;

public class CucumberHooks {

    @BeforeAll
    public static void beforeAll() {
        System.out.println("Selalu di eksekusi sekali di awal");
        RestAssured.baseURI = "https://reqres.in/api";
    }

    @AfterAll
    public static void afterAll() {
        System.out.println("Selalu di eksekusi sekali di akhir");
    }

    @Before
    public static void beforeEach() {
        System.out.println("Selalu di eksekusi setiap di awal test case");
    }

    @After
    public static void afterEach() {
        System.out.println("Selalu di eksekusi setiap di akhir test case");
    }
}

