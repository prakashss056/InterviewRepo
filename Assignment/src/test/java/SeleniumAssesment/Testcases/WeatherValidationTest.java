package SeleniumAssesment.Testcases;

import SeleniumAssesment.Base.BaseTest;
import SeleniumAssesment.Pages.LandingPage;
import SeleniumAssesment.Pages.WeatherHistoryPage;
import SeleniumAssesment.Pages.WeatherdataPage;
import SeleniumAssesment.utility.Config;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import java.util.List;

public class WeatherValidationTest extends BaseTest{

    public WeatherValidationTest() {super();}
    LandingPage landingPage;
    WeatherdataPage weatherdataPage;
    WeatherHistoryPage weatherHistoryPage;
    @BeforeClass
        public void setup() {
            landingPage = PageFactory.initElements(driver, LandingPage.class);
            weatherdataPage = PageFactory.initElements(driver, WeatherdataPage.class);
            weatherHistoryPage =PageFactory.initElements(driver, WeatherHistoryPage.class);

        }

        @Test
        public void validateWeatherData()  {
            driver.get(new Config(BaseTest.prop).url());
            landingPage. WeatherDatamenu_button();
            weatherdataPage.searchLocation("Bengaluru");
            weatherHistoryPage.VerifyMax_temp();
            driver.quit();
        }
}
