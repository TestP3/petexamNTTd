package com.nttdata.steps;

import io.restassured.RestAssured;
import io.restassured.response.Response;
import org.junit.Assert;

public class PetStoreStep {


    Response response;
    private String URL_BASE;

    public void definirurl(String url) {
        URL_BASE = url;
    }

    public void consultaMascota(int idmascota) {
        response = RestAssured.given().baseUri(URL_BASE).
                get("/pet/" + idmascota) //---request
                .then(). //---response
                        log().all().  // log del response y request
                        extract().response();

        System.out.println("respuesta: " + response.statusCode());
    }

    public void validarCodigoRespuesta(int statusCode) {
        Assert.assertEquals("Validandacion", statusCode, response.statusCode());
    }

    public void validarNombreMascota(String nombreMasctoa) {
    }

    public void crearmascota(String nombre, String id) {
        String body = "{\n" +
                "  \"id\": "+id+",\n" +
                "    \"name\": \""+nombre+"\",\n" +
                "    \"status\": \"available\"\n" +
                "}";
        System.out.println(body);
        response =  RestAssured.given().baseUri(URL_BASE).
                header("Content-Type", "application/json").
                body(body).
                log().all().
                post("/pet").
                then().
                extract().
                response()

                ;

    }
}
