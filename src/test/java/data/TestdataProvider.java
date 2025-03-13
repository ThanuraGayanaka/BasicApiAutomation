package data;

import org.testng.annotations.DataProvider;

public class TestdataProvider {

    @DataProvider(name = "zipCodes")
    public Object[][] getZipCodeData() {
        return new Object[][]{
                {"us", "90210", "Beverly Hills"},
                {"us", "10001", "New York"},
                {"ca", "M5S", "Toronto"},
                {"de", "10115", "Berlin"}
        };
    }
}
