package SeleniumAssesment.Pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class WeatherdataPage {

    private WebDriver driver;

    public WeatherdataPage(WebDriver driver) {
        this.driver = driver;
    }
    @FindBy(xpath = "//*[@class='form-control' and @placeholder='Enter a location']")
    private WebElement location_searchfield;

    @FindBy(xpath = "//*[text()='Search']")
    private WebElement locationsearch_btn;

    public WeatherHistoryPage searchLocation(String Location){
        location_searchfield.sendKeys(Location);
        locationsearch_btn.click();
        return new WeatherHistoryPage(driver);
    }
}
