package api.stepdef.reqresin;

import api.service.reqresin.Reqresin;
import io.cucumber.java.en.And;

public class ReqresinStepDef {

    Reqresin reqresin = new Reqresin();

    // Action

    @And("user send PUT Update request to reqresin")
    public void putUpdate() {
        reqresin.putUpdate();
    }

    @And("user send POST login request to reqresin")
    public void postLogin() {
        reqresin.postLogin();
    }

    @And("user send GET Users request to reqresin")
    public void getUsers() {
        reqresin.getListUser();
    }
}
