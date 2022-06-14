package alterra.stepdef;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;

public class InputStepDef {
    @Given("user input data {string}")
    public void userInputData(String data) {
        System.out.println(data);

    }


    @And("user input angka {int}")
    public void userInputAngka(int angka) {
        if (angka > 5) {
            System.out.println("Lebih besar dari lima");
        } else {
            System.out.println("Lebih kecil dari lima");
        }
    }
}
