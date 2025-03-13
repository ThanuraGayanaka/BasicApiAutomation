package BaseTest;

import io.restassured.RestAssured;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;

public class BaseTest {

    public void setup() throws IOException {

        Properties properties= new Properties();
        FileInputStream configFile= new FileInputStream("src/main/resources/config.properties");
        properties.load(configFile);


        RestAssured.baseURI=properties.getProperty("base_url");



    }


}
