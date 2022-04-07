package web.stepdef;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

public class RegisterStepDef {
    @Given("user is on registration page")
    public void userIsOnRegistrationPage() {
        System.out.println("User berada di halaman register");
    }

    @And("user input email data")
    public void userInputEmailData() {
        System.out.println("input email");
    }

    @And("user input password data")
    public void userInputPasswordData() {
        System.out.println("input password");
    }

    @And("user input address data")
    public void userInputAddressData() {
        System.out.println("input alamat");
    }

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
}
