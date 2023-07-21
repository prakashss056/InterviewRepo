package SeleniumAssesment.utility;

import SeleniumAssesment.Base.BaseTest;

import java.util.Properties;

public class Config extends BaseTest {
    private static Properties prop;
    public Config(Properties prop){this.prop = prop;}
    public String getBrowser() {return prop.getProperty("browser");}
    public String url() {return prop.getProperty("url");}
    public int getPageLoadTimeOut() {return Integer.parseInt(prop.getProperty("PageLoadTimeOut"));}
    public int getImplicitWait() {return Integer.parseInt(prop.getProperty("ImplcitWait"));}
    public int getExpliciteWait() {return Integer.parseInt(prop.getProperty("ExpliciteWait"));}
}
