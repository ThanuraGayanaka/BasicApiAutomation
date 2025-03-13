package Tests;

import BaseTest.BaseTest;
import io.restassured.response.Response;
import org.testng.Assert;
import org.testng.annotations.Test;

import static io.restassured.RestAssured.given;

public class UserTest extends BaseTest {


    @Test

    public void ValidatezipcodeDeatails(String country, String zip, String place){

        Response response = given()
                .when()
                .get("/us/90210")
                .then()
                .statusCode(200)
                .extract().response();

        // Assertions - validate place and country
        Assert.assertEquals(response.jsonPath().getString("places[0].'place name'"), "Beverly Hills");
        Assert.assertEquals(response.jsonPath().getString("country"), "United States");

        // Print response for debugging
        System.out.println(response.asPrettyString());
    }
}
