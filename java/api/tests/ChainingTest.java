package api.tests;

import io.restassured.response.Response;
import org.testng.annotations.Test;

import api.base.BaseTest;

import static io.restassured.RestAssured.*;
import static org.hamcrest.Matchers.*;

public class ChainingTest extends BaseTest {

    @Test
    public void apiChainingTest() {

        String requestBody = "{ \"email\": \"eve.holt@reqres.in\", \"password\": \"cityslicka\" }";

        Response loginResponse =
                given()
                    .header("x-api-key", "reqres_f3d098cfd3b14635b45dbe69e300b2df")
                    .header("Content-Type", "application/json")
                    .body(requestBody)
                .when()
                    .post("/api/login");

        String token = loginResponse.jsonPath().getString("token");

        given()
            .header("x-api-key", "reqres_f3d098cfd3b14635b45dbe69e300b2df")
            .header("Authorization", "Bearer " + token)
        .when()
            .get("/api/users/2")
        .then()
            .statusCode(200);
    }
}