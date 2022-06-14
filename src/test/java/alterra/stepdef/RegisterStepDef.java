package alterra.stepdef;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;

public class RegisterStepDef {
    @Given("user is on registration page")
    public void userIsOnRegistrationPage() {
        System.out.println("User berada di halaman register");
    }

    @And("user input email data")
    public void userInputEmailData() {
        System.out.println("Eksekusi perintah ini");
    }

    @And("user input password data")
    public void userInputPasswordData() {
        System.out.println("input password");
    }

    @And("user input address data")
    public void userInputAddressData() {
        System.out.println("input alamat");
    }
}
