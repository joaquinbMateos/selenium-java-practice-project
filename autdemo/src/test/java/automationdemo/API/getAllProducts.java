package automationdemo.API;

import static io.restassured.RestAssured.baseURI;
import static io.restassured.RestAssured.given;
import static org.hamcrest.Matchers.equalTo;

import org.testng.Assert;
import org.testng.annotations.Test;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.SerializationFeature;

import io.restassured.RestAssured;
import io.restassured.path.json.JsonPath;
import io.restassured.response.Response;

public class getAllProducts {
    @Test
    public void getProducts(){
        Response response = RestAssured.get("https://automationexercise.com/api/productsList");
        String responseBody = response.getBody().asString();
        //System.out.println("Response Body: "+ responseBody);
        ObjectMapper objectMapper = new ObjectMapper();
        objectMapper.enable(SerializationFeature.INDENT_OUTPUT);
        try {
            // Convertir el cuerpo de respuesta a un objeto JSON formateado
            Object json = objectMapper.readValue(responseBody, Object.class);
            // Imprimir el JSON formateado
            String formattedJson = objectMapper.writeValueAsString(json);
            System.out.println("Response Body:");
            System.out.println(formattedJson);
        } catch (Exception e) {
            e.printStackTrace();
        }
        JsonPath extractor = response.jsonPath();
        String firstProductName = extractor.get("products[0].name");
        System.out.print("First Product Name: "+ firstProductName);
        Assert.assertEquals(firstProductName, "Blue Top");
    }

    @Test
    public void getProductsBDD(){
        baseURI = "https://automationexercise.com/api";
        given()
            .baseUri(baseURI)
        .when()
            .get("/productsList")
        .then()
            .statusCode(200)
            .body("products[0].name", equalTo("Blue Top"));
    }
}
