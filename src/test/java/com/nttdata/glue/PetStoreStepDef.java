package com.nttdata.glue;

import com.nttdata.steps.PetStoreStep;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import io.restassured.RestAssured;
import io.restassured.internal.common.assertion.Assertion;
import io.restassured.response.Response;
import net.thucydides.core.annotations.Steps;
import org.junit.Assert;

public class PetStoreStepDef {
    @Steps
    PetStoreStep tienda;
    @Given("la url {string}")
    public void laUrl(String url) {
        tienda.definirurl(url);

    }

    @When("consulto la mascota con ID {int}")
    public void consultoLaMascotaConID(int idmascota) {
        tienda.consultaMascota(idmascota);

    }

    @Then("valido el cod de re sponse sea {int}")
    public void validoElCodDeReSponseSea(int statusCode) {
        tienda.validarCodigoRespuesta(statusCode);
    }

    @And("valido el nombre de la mascota sea {string}")
    public void validoElNombreDeLaMascotaSea(String nombreMasctoa) {
        tienda.validarNombreMascota(nombreMasctoa);
    }

    @When("creo la mascota {string} con ID {string}")
    public void creoLaMascotaConID(String nombre, String id) {
        tienda.crearmascota(nombre, id);
    }
}
