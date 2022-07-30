package Unirest;

import com.mashape.unirest.http.HttpResponse;
import org.junit.Assert;
import org.junit.Test;


import com.mashape.unirest.http.Unirest;
import com.mashape.unirest.http.exceptions.UnirestException;


public class store {

    @Test
    public void placeOrderPet() throws UnirestException {
        Unirest.setTimeouts(0, 0);
        HttpResponse<String> response = Unirest.post("https://petstore.swagger.io/v2/store/order")
                .header("Content-Type", "application/json")
                .body("{\r\n  \"id\": 100,\r\n  \"petId\": 0,\r\n  \"quantity\": 0,\r\n  \"shipDate\": \"2022-07-29T18:40:49.084Z\",\r\n  \"status\": \"placed\",\r\n  \"complete\": true\r\n}")
                .asString();

        Assert.assertEquals(200,response.getStatus());

    }
    @Test
    public void findfPurchaseOrderByID() throws UnirestException {
        Unirest.setTimeouts(0, 0);
        HttpResponse<String> response = Unirest.get("https://petstore.swagger.io/v2/store/order/8")
                .header("Content-Type", "application/json")
                .asString();

        Assert.assertEquals(200,response.getStatus());
    }

    @Test
    public void deletePurchaseOrderByID() throws UnirestException {
        Unirest.setTimeouts(0, 0);
        HttpResponse<String> response = Unirest.delete("https://petstore.swagger.io/v2/store/order/3")
                .body("")
                .asString();

        Assert.assertEquals(200,response.getStatus());
    }

    @Test
    public void returnPetInventoriesByStatus() throws UnirestException {
        Unirest.setTimeouts(0, 0);
        HttpResponse<String> response = Unirest.get("https://petstore.swagger.io/v2/store/inventory")
                .asString();

        Assert.assertEquals(200,response.getStatus());
    }
}
