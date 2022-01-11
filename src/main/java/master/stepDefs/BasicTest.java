package master.stepDefs;

import io.cucumber.java.Scenario;
import master.utility.DriverClass;
import master.utility.TestingUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.io.InputStream;
import java.util.Properties;

public class BasicTest {

    public static WebDriver driver;
    String browserType = null;
    public static Properties config = new Properties();
    public TestingUtils testUtil = null;
    private static Logger logger = LoggerFactory.getLogger(BasicTest.class);

    public void setup() throws Exception{
        try(final InputStream stream =
                getClass().getResourceAsStream(System.getProperty("user.dir")+"/src/main/resources/config.properties")){
            config.load(stream);
        }
        testUtil = new TestingUtils(driver);
    }

    public String getPropertyValue(String key) throws Exception{
        String propertyValue = config.getProperty(key);
        return propertyValue;
    }

    public void launchBrowser(String url){
        browserType = config.getProperty("browser");
        driver = DriverClass.getDriver(browserType, url);
    }

    public void tearDown(Scenario scenario) throws  Exception{
        if(scenario.isFailed()){
            byte[] screenshotBytes = ((TakesScreenshot) driver).getScreenshotAs(OutputType.BYTES);
            scenario.attach(screenshotBytes,"image/png","Failure_img");
        }
        if(driver!=null){
            driver.quit();
        }
        driver=null;
    }
}
