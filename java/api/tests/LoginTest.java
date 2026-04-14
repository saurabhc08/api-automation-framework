package api.tests;

import io.restassured.response.Response;
import org.testng.annotations.Test;

import static io.restassured.RestAssured.*;

public class LoginTest {

    @Test
    public void loginTest() {

        String requestBody = "{ \"email\": \"eve.holt@reqres.in\", \"password\": \"cityslicka\" }";

        Response response =
                given()
                    .baseUri("https://reqres.in")
                    .header("x-api-key", "reqres_f3d098cfd3b14635b45dbe69e300b2df")
                    .header("Content-Type", "application/json")
                    .body(requestBody)
                .when()
                    .post("/api/login");

        // Print full response
        response.prettyPrint();

        // Extract token
        String token = response.jsonPath().getString("token");

        System.out.println("Token is: " + token);
    }
}
