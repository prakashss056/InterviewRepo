package SeleniumAssesment.utility;

import SeleniumAssesment.Base.BaseTest;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.util.List;
import java.util.Properties;

public class Waiter {
    private WebDriver driver;


    public static WebDriverWait WebDriverWait(WebDriver driver, List<WebElement> Element){
        WebDriverWait wait = new WebDriverWait(driver,new Config(BaseTest.prop).getImplicitWait());
        wait.until(ExpectedConditions.visibilityOf(Element.get(0)));
        return wait;
    }
}
