package api.tests;

import io.restassured.response.Response;
import org.testng.annotations.Test;

import static io.restassured.RestAssured.*;
import static org.hamcrest.Matchers.*;

import api.base.BaseTest;
import api.utils.ConfigReader;
import api.constants.Endpoints;
import api.utils.LoggerUtil;

public class UserTests extends BaseTest {

    @Test
    public void apiChainingTest() {

        LoggerUtil.log.info("Starting Login API");

        String requestBody = "{ \"email\": \"eve.holt@reqres.in\", \"password\": \"cityslicka\" }";

        Response loginResponse =
                given()
                    .header("x-api-key", ConfigReader.get("api.key"))
                    .header("Content-Type", "application/json")
                    .body(requestBody)
                .when()
                    .post(Endpoints.LOGIN);

        String token = loginResponse.jsonPath().getString("token");
        LoggerUtil.log.info("Token received: " + token);

        LoggerUtil.log.info("Calling Get User API");

        given()
            .header("x-api-key", ConfigReader.get("api.key"))
            .header("Authorization", "Bearer " + token)
        .when()
            .get(Endpoints.GET_USER)
        .then()
            .statusCode(200)
            .body("data.id", equalTo(2));

        LoggerUtil.log.info("Test completed successfully");
    }
}
