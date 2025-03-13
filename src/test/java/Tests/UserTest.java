package Tests;

import BaseTest.BaseTest;
import io.restassured.response.Response;
import org.testng.Assert;
import org.testng.annotations.Test;
import org.testng.annotations.DataProvider;

import static io.restassured.RestAssured.given;

public class UserTest extends BaseTest {

    @Test(dataProvider = "zipCodes", dataProviderClass = data.TestdataProvider.class)
    public void ValidatezipcodeDeatails(String country, String zip, String place){

        Response response = given()
                .when()
                .get("/" + country + "/" + zip) // Dynamically using country and zip
                .then()
                .statusCode(200)
                .extract().response();

        // Assertions - validate place and country
        Assert.assertEquals(response.jsonPath().getString("places[0].'place name'"), place);
        Assert.assertEquals(response.jsonPath().getString("country"), "United States");

        // Print response for debugging
        System.out.println(response.asPrettyString());
    }
}
