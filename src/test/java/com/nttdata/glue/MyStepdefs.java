package com.nttdata.glue;

import com.nttdata.steps.StepTest;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.When;
import net.thucydides.core.annotations.Steps;

public class MyStepdefs {
    @Steps
    StepTest obj;
    @Given("prueba de assertion")
    public void pruebaDeAssertion() {
    obj.metodoPrueba();
    }

    @When("pruebo un servicio url {string}")
    public void prueboUnServicioUrl(String arg0) {
        System.out.println("imprimir url "+arg0);
    }
}
