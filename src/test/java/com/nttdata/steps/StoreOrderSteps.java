package com.nttdata.steps;
import io.restassured.RestAssured;
import io.restassured.response.Response;
import org.junit.Assert;
public class StoreOrderSteps {
    private String baseUrl;
    private Response response;

    public void setBaseUrl(String baseUrl) {
        this.baseUrl = baseUrl;
    }

    public void createOrder(int orderId, int petId, int quantity, String status, boolean complete) {
        String body = String.format(
                "{\"id\":%d,\"petId\":%d,\"quantity\":%d,\"status\":\"%s\",\"complete\":%b}",
                orderId, petId, quantity, status, complete
        );

        response = RestAssured.given()
                .baseUri(baseUrl)
                .header("Content-Type", "application/json")
                .body(body)
                .log().all()
                .post("/store/order")
                .then()
                .log().all()
                .extract().response();
    }

    public void validateResponseCode(int expectedStatusCode) {
        Assert.assertEquals("El código de respuesta no es el esperado.", expectedStatusCode, response.statusCode());
    }

    public void validateOrderBody(int orderId, String status) {
        int actualOrderId = response.jsonPath().getInt("id");
        String actualStatus = response.jsonPath().getString("status");

        Assert.assertEquals("El ID del pedido no coincide.", orderId, actualOrderId);
        Assert.assertEquals("El estado del pedido no coincide.", status, actualStatus);
    }

    public void getOrderById(int orderId) {
        response = RestAssured.given()
                .baseUri(baseUrl)
                .log().all()
                .get("/store/order/" + orderId)
                .then()
                .log().all()
                .extract().response();
    }
}
