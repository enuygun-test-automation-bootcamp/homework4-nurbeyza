package Httpentity;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.mashape.unirest.http.exceptions.UnirestException;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.MediaType;
import org.junit.Test;
import org.springframework.web.client.RestTemplate;

import static io.restassured.RestAssured.given;
import static org.junit.Assert.assertNotNull;

public class store {


    RestTemplate restTemplate;
    HttpHeaders headers;
    private final ObjectMapper objectMapper = new ObjectMapper();

    //Bir yapıcı oluşturup headers ve templateleri oluşturuldu.
    public store(){
        headers = new HttpHeaders();
        headers.setContentType(MediaType.APPLICATION_JSON);
        restTemplate = new RestTemplate();

    }

    //Store altında bulunan 4 tane sorgu için Httpentity kullanarak testler gerçekleştirildi.
    @Test
    public void placeOrderPet() throws JsonProcessingException {
        HttpEntity<String> request =
                new HttpEntity<String>("{\r\n  \"id\": 0,\r\n  \"petId\": 0,\r\n  \"quantity\": 0,\r\n  \"shipDate\": \"2022-07-29T18:40:49.084Z\",\r\n  \"status\": \"placed\",\r\n  \"complete\": true\r\n}", headers);
        String signupResultAsJsonStr =
                restTemplate.postForObject("https://petstore.swagger.io/v2/store/order", request, String.class);
        com.fasterxml.jackson.databind.JsonNode root = objectMapper.readTree(signupResultAsJsonStr);

        //result değeri kontrol edildi.
        assertNotNull(signupResultAsJsonStr);
    }


    @Test
    public void findfPurchaseOrderByID() throws UnirestException, JsonProcessingException {
        HttpEntity<String> request =
                new HttpEntity<String>("", headers);
        String signupResultAsJsonStr =
                restTemplate.getForObject("https://petstore.swagger.io/v2/store/order/8", String.class);
        com.fasterxml.jackson.databind.JsonNode root = objectMapper.readTree(signupResultAsJsonStr);

        //result değeri kontrol edildi.
        assertNotNull(signupResultAsJsonStr);

    }

    @Test
    public void deletePurchaseOrderByID() throws UnirestException, JsonProcessingException {
        HttpEntity<String> request =
                new HttpEntity<String>("", headers);
        String signupResultAsJsonStr =
                restTemplate.delete("https://petstore.swagger.io/v2/store/order/8",url);
        com.fasterxml.jackson.databind.JsonNode root = objectMapper.readTree(signupResultAsJsonStr);

        //result değeri kontrol edildi.
        assertNotNull(signupResultAsJsonStr);


    }

    @Test
    public void returnPetInventoriesByStatus() throws UnirestException, JsonProcessingException {
        HttpEntity<String> request =
                new HttpEntity<String>("", headers);
        String signupResultAsJsonStr =
                restTemplate.getForObject("https://petstore.swagger.io/v2/store/inventory", String.class);
        com.fasterxml.jackson.databind.JsonNode root = objectMapper.readTree(signupResultAsJsonStr);

        //result değeri kontrol edildi.
        assertNotNull(signupResultAsJsonStr);


    }
}
