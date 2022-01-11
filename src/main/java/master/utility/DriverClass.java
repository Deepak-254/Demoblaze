package master.utility;

import master.stepDefs.BasicTest;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class DriverClass extends BasicTest {

    public static WebDriver driver = null;
    public static Logger logger = LoggerFactory.getLogger(DriverClass.class);

    public static WebDriver getDriver(String browser, String url){
        driver = null;

        switch(browser){
            case "chrome" :
                String driverPath1 = config.getProperty(browser);
                System.setProperty("webdriver.chrome.driver",
                        System.getProperty("user.dir")+"/Drivers/chromedriver.exe");
                ChromeOptions options = new ChromeOptions();
                options.setCapability("useAutomationExtension",false);
                driver = new ChromeDriver(options);
                driver.manage().deleteAllCookies();
                logger.info("Chrome Driver Launched");
                break;

            case "firefox" :
                String driverPath2 = config.getProperty(browser);
                System.setProperty("webdriver.gecko.driver",
                        System.getProperty("user.dir")+"/Drivers/geckodriver.exe");
                driver = new FirefoxDriver();
                driver.manage().deleteAllCookies();
                logger.info("Firefox Driver Launched");
                break;

            default:
                logger.info("Driver not Launched");
                break;
        }
        driver.get(url);
        driver.manage().window().maximize();
        return driver;
    }

}
