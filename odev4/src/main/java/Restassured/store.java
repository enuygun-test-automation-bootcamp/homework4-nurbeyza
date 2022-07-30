package Restassured;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.mashape.unirest.http.HttpResponse;
import com.mashape.unirest.http.Unirest;
import com.mashape.unirest.http.exceptions.UnirestException;
import io.restassured.http.ContentType;
import io.restassured.path.json.JsonPath;
import io.restassured.response.Response;
import org.junit.Assert;
import org.junit.Test;

import static io.restassured.RestAssured.baseURI;
import static io.restassured.RestAssured.given;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;

public class store {


    Response response;
    @Test
    public void placeOrderPet() throws JsonProcessingException {

        response = given()
                .header("Content-Type","application/json")
                .body("{\r\n  \"id\": 100,\r\n  \"petId\": 0,\r\n  \"quantity\": 0,\r\n  \"shipDate\": \"2022-07-29T18:40:49.084Z\",\r\n  \"status\": \"placed\",\r\n  \"complete\": true\r\n}")
                .when()
                .post("https://petstore.swagger.io/v2/store/order")
                .then()
                .statusCode(200)
                .contentType(ContentType.JSON)
                .extract().response();

    }

    @Test
    public void findfPurchaseOrderByID() throws UnirestException {
        response = given()
                .header("Content-Type","application/json")
                .when()
                .get("https://petstore.swagger.io/v2/store/order/9")
                .then()
                .statusCode(200)
                .contentType(ContentType.JSON)
                .extract().response();

    }

    @Test
    public void deletePurchaseOrderByID() throws UnirestException {
        response = given()
                .header("Content-Type","application/json")
                .when()
                .delete("https://petstore.swagger.io/v2/store/order/9")
                .then()
                .statusCode(200)
                .contentType(ContentType.JSON)
                .extract().response();

    }

    @Test
    public void returnPetInventoriesByStatus() throws UnirestException {
        response = given()
                .header("Content-Type","application/json")
                .when()
                .get("https://petstore.swagger.io/v2/store/inventory")
                .then()
                .statusCode(200)
                .contentType(ContentType.JSON)
                .extract().response();

    }
}
