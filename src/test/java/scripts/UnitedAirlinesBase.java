package scripts;

import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.asserts.SoftAssert;
import pages.UnitedAirlinesBasePage;
import pages.UnitedAirlinesConformationPage;
import utilities.ConfigReader;
import utilities.Driver;

public class UnitedAirlinesBase {
    WebDriver driver;
    SoftAssert softAssert;
    UnitedAirlinesBasePage unitedAirlinesPage;
    UnitedAirlinesConformationPage unitedAirlinesConformPage;

    @BeforeMethod
    public void setup(){
        driver = Driver.getDriver();
        softAssert = new SoftAssert();
        driver.get(ConfigReader.getProperty("appURL"));
    }

    @AfterMethod
    public void teardown(){
        softAssert.assertAll();
        Driver.quiteDriver();
    }
}
