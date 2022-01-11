package master.utility;

import org.openqa.selenium.Alert;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.time.Duration;

public class TestingUtils {

    WebDriver driver;
    private  static Logger logger = LoggerFactory.getLogger(TestingUtils.class);

    public TestingUtils(WebDriver driver){
        this.driver = driver;
    }

    public void acceptAlert() {
        try {
            WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(5));
            wait.until(ExpectedConditions.alertIsPresent());
            Alert alert = driver.switchTo().alert();
            alert.accept();
        }
        catch (Exception e){
            logger.info("Alert not found");
        }
    }

    public void waitForVisibility(WebDriver driver, WebElement webElement){
        (new WebDriverWait(driver,Duration.ofSeconds(60))).until(new ExpectedCondition<Boolean>() {
            @Override
            public Boolean apply(WebDriver d){
            return webElement.isDisplayed();}
            }
        );
    }
}
