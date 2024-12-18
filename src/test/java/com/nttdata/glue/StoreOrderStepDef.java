package com.nttdata.glue;
import com.nttdata.steps.StoreOrderSteps;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import net.thucydides.core.annotations.Steps;
public class StoreOrderStepDef {
    @Steps
    StoreOrderSteps storeOrderSteps;

    @Given("la URL base {string}")
    public void setBaseUrl(String baseUrl) {
        storeOrderSteps.setBaseUrl(baseUrl);
    }


//    @When("creo un pedido con ID {int}, petId {int}, cantidad {int}, status \"placed\" y complete {string}")
//    public void createOrder(int orderId, int petId, int quantity, String status, String complete) {
//        boolean isComplete = Boolean.parseBoolean(complete);
//        storeOrderSteps.createOrder(orderId, petId, quantity, status, isComplete);
//
//    }
//@When("creo un pedido con ID {int}, petId {int}, cantidad {int}, status {string} y complete true")
//public void createOrder(int orderId, int petId, int quantity, String status) {
//    storeOrderSteps.createOrder(orderId, petId, quantity, status, true);
//
//
//}


    @Then("valido que el código de respuesta sea {int}")
    public void validateResponseCode(int expectedStatusCode) {
        storeOrderSteps.validateResponseCode(expectedStatusCode);
    }

    @And("valido que el body contenga el ID del pedido {int} y el status {string}")
    public void validateOrderBody(int orderId, String status) {
        storeOrderSteps.validateOrderBody(orderId, status);
    }

    @When("consulto el pedido con ID {int}")
    public void getOrderById(int orderId) {
        storeOrderSteps.getOrderById(orderId);
    }

    @When("creo un pedido con ID {}, petId {}, cantidad {}, status {string} y complete {}")
    public void creoUnPedidoConIDPetIdCantidadStatusYComplete(int orderId, int petId, int quantity, String status, String complete) {
        boolean isComplete = Boolean.parseBoolean(complete);
        storeOrderSteps.createOrder(orderId, petId, quantity, status, isComplete);
    }
}
