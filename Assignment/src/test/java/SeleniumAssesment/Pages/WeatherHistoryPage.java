package SeleniumAssesment.Pages;
import SeleniumAssesment.utility.Waiter;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;

import javax.xml.xpath.XPath;
import java.util.List;

public class WeatherHistoryPage {
    private WebDriver driver;

    public WeatherHistoryPage(WebDriver driver) {
        this.driver = driver;
    }

    @FindBy(xpath = "//*[@class ='row justify-content-center mt-3 mb-3']/div/div")
    private  List<WebElement>max_temp;
    @FindBy(xpath = "//*[@class ='row justify-content-center mt-3 mb-3']/div/div[2]")
    private List<WebElement>max_tempValue;

    public WebDriverWait isElementsLoaded() {
        return Waiter.WebDriverWait(driver, max_temp);
    }
    public boolean VerifyMax_temp(){
        isElementsLoaded();
        List<WebElement> value = max_tempValue;
        String temp_max = value.get(0).getText();
        temp_max = temp_max.replace("°C", "");
        System.out.println(temp_max);
        return max_temp!=null;
    }
}
