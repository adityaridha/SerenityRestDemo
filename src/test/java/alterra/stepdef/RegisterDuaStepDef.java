package alterra.stepdef;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

public class RegisterDuaStepDef {
    @When("user click register button")
    public void userClickRegisterButton() {
        System.out.println("click register");
    }

    @Then("user should be redirected to homepage")
    public void userShouldBeRedirectedToHomepage() {
        System.out.println("redirect ke homepage");
    }

    @Then("user should be able to see warning message")
    public void userShouldBeAbleToSeeWarningMessage() {
        System.out.println("redirect ke homepage");
    }

    @When("^user click register with \"([^\"]*)\"$")
    public void userClickRegisterWithGoogle(String partner) {
        System.out.println("Ini partner : " + partner);
    }

    @Then("^user should redirected to \"([^\"]*)\" page$")
    public void userShouldRedirectedToGooglePage(String partner) {
        System.out.println("Redirect ke partner : " + partner);
    }

    @When("bikin step baru")
    public void bikin_step_baru() {
        System.out.println("Ini step baru");
        System.out.println("Ini step baru lagi");
    }

    @And("ini step baru lagi")
    public void iniStepBaruLagi() {
        System.out.println("Step di file dua");
    }
}
