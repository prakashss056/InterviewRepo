package SeleniumAssesment.Pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class LandingPage {

    private WebDriver driver;
    public LandingPage(WebDriver driver){this.driver=driver;}

    @FindBy(xpath ="//*[@class='nav-link text-nowrap' and @href='/weather-data']")
    private WebElement WeatherDatamenu_button;

    @FindBy(xpath ="//*[text()='Accept all cookies']")
    private WebElement Accept_cookies;


    public WeatherdataPage WeatherDatamenu_button() {
        Accept_cookies.click();
        WeatherDatamenu_button.click();
        return new WeatherdataPage(driver);
}
}
