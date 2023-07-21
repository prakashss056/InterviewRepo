package SeleniumAssesment.Base;
import SeleniumAssesment.utility.Config;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.BeforeTest;

import java.io.FileInputStream;
import java.io.InputStream;
import java.util.Properties;
import java.util.concurrent.TimeUnit;

public class BaseTest {
    public static WebDriver driver;
    public static Properties prop;
    public BaseTest(){
        try {
            prop = new Properties();
            InputStream Env_file = new FileInputStream(System.getProperty("user.dir") + "/src/test/java/SeleniumAssesment/Resource/Env.properties");
            prop.load(Env_file);
        }catch (Exception e){
            e.printStackTrace();
        }
    }

    @BeforeTest
    //to run with parameters
    //@Parameters("browser")
    public static void browserInitiallization() {  //change this to browserInitiallization(String BrowserName)
        Config config = new Config(prop);
        String BrowserName = config.getBrowser();  // comment this line when your passing parameters from xml file
        if (System.getProperty("os.name").contains("Window")) {
            if (BrowserName.equalsIgnoreCase("chrome")) {
                System.setProperty("webdriver.chrome.driver",System.getProperty("user.dir")+"/src/test/java/SeleniumAssesment/Resource/chromedriver.exe");
                driver = new ChromeDriver();

            }else if(BrowserName.equalsIgnoreCase("firefox")) {
                System.setProperty("webdriver.gecko.driver",
                        System.getProperty("user.dir")+"/src/test/java/SeleniumAssesment/Resource/geckodriver.exe");

                driver = new FirefoxDriver();
            }
        }
        else if (System.getProperty("os.name").contains("Mac")) {
            if (BrowserName.equalsIgnoreCase("chrome")) {
                System.setProperty("webdriver.chrome.driver", System.getProperty("user.dir")+"/src/test/java/SeleniumAssesment/Resource/chromedriver");
                driver = new ChromeDriver();

            }else if(BrowserName.equalsIgnoreCase("firefox")) {
                System.setProperty("webdriver.gecko.driver",System.getProperty("user.dir")+"/src/test/java/SeleniumAssesment/Resource/geckodriver");
                driver = new FirefoxDriver();
            }
        }

        driver.manage().timeouts().pageLoadTimeout(config.getPageLoadTimeOut(), TimeUnit.SECONDS);
        driver.manage().timeouts().implicitlyWait(config.getImplicitWait(), TimeUnit.SECONDS);
        driver.manage().deleteAllCookies();
        driver.manage().window().maximize();


    }



}
