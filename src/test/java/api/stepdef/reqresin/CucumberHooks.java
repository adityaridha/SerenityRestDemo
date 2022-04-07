package api.stepdef.reqresin;

import io.cucumber.java.After;
import io.cucumber.java.Before;

public class CucumberHooks {

    @Before
    public void Before() {
        System.out.println("Ini selalu di eksekusi sebelum test");
    }

    @After
    public void After() {
        System.out.println("Delete data testing di database");
    }

}
