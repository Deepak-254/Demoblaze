package master.pageObjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class LoginPage {
    WebDriver driver;

    public LoginPage(WebDriver driver){
        this.driver = driver;
    }

    @FindBy(id = "login2")
    public WebElement login;

    @FindBy(id = "logInModalLabel")
    public WebElement loginModalBoxHeading;

    @FindBy(id = "loginusername")
    public WebElement loginUsernameTextbox;

    @FindBy(id = "loginpassword")
    public WebElement loginPasswordInputbox;

    @FindBy(xpath = "//*[@id='logInModal']//button[text()='Close']")
    public WebElement closeButtonLoginPage;

    @FindBy(xpath = "//*[@id='logInModal']//button[text()='Log in']")
    public WebElement loginButtonLoginPage;

    @FindBy(id = "nameofuser")
    public WebElement loginSuccessUsernameDisplay;
}
