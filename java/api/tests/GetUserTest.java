package api.tests;

import io.restassured.RestAssured;
import org.testng.annotations.Test;

import static io.restassured.RestAssured.*;
import static org.hamcrest.Matchers.*;

public class GetUserTest {

    @Test
    public void getUser() {

        given()
            .baseUri("https://reqres.in")
            .header("x-api-key", "reqres_f3d098cfd3b14635b45dbe69e300b2df")   // 🔥 ADD THIS
        .when()
            .get("/api/users/2")
        .then()
            .statusCode(200)
            .body("data.id", equalTo(2));
    }
}