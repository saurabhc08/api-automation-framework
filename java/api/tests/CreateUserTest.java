package api.tests;

import org.testng.annotations.Test;

import static io.restassured.RestAssured.*;
import static org.hamcrest.Matchers.*;

public class CreateUserTest {

    @Test
    public void createUser() {

        String requestBody = "{ \"name\": \"Saurabh\", \"job\": \"QA Engineer\" }";

        given()
            .baseUri("https://reqres.in")
            .header("x-api-key", "reqres_f3d098cfd3b14635b45dbe69e300b2df")
            .header("Content-Type", "application/json")
            .body(requestBody)
        .when()
            .post("/api/users")
        .then()
            .statusCode(201)
            .body("name", equalTo("Saurabh"))
            .body("job", equalTo("QA Engineer"))
            .body("id", notNullValue());
    }
}