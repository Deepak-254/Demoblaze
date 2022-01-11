package master.stepDefs;

import io.cucumber.java.Before;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import master.pageObjects.LoginPage;
import master.utility.TestingUtils;
import org.openqa.selenium.support.PageFactory;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.time.Duration;

public class LoginStepdef extends BasicTest{

    private LoginPage lp;
    private TestingUtils testutil;
    private static Logger logger = LoggerFactory.getLogger(LoginStepdef.class);

    @Before
    public void env() throws Exception{
        setup();
    }

    @Given("^User launches website$")
    public void user_Launches_Website() throws Exception{
            launchBrowser(config.getProperty("url"));
    }

    @And("^Navigates to login page$")
    public void navigates_To_Login_Page() throws Exception {
    driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
    lp = PageFactory.initElements(driver, LoginPage.class);
    if(lp.login.isDisplayed()){
        logger.info("Home Page is displayed");
    }
        lp.login.click();
    }

    @When("^User enters incorrect username \"([^\"]*)\"$")
    public void user_Enters_Incorrect_Username(String username) throws Exception {
        if(lp.loginModalBoxHeading.isDisplayed()){
            lp.loginUsernameTextbox.sendKeys(username);
        }
    }

    @And("^User enters incorrect password \"([^\"]*)\"$")
    public void user_Enters_Incorrect_Password(String password) throws Exception {
        if(lp.loginPasswordInputbox.isDisplayed()){
            lp.loginPasswordInputbox.sendKeys(password);
        }
    }

    @Then("^Login should fail$")
    public void login_Should_Fail() throws Exception {
        if(lp.loginButtonLoginPage.isDisplayed() && lp.loginButtonLoginPage.isEnabled()){
            lp.loginButtonLoginPage.click();
            testutil.acceptAlert();
            logger.info("Login Failed");
        }

    }

    @When("^User enters correct username \"([^\"]*)\"$")
    public void user_Enters_Correct_Username(String username) throws Exception {
        if(lp.loginUsernameTextbox.isDisplayed()){
            lp.loginUsernameTextbox.clear();
            lp.loginUsernameTextbox.sendKeys(username);
        }
    }

    @And("^User enters correct password \"([^\"]*)\"$")
    public void user_Enters_Correct_Password(String password) throws Exception {
    if(lp.loginPasswordInputbox.isDisplayed()){
        lp.loginPasswordInputbox.clear();
        lp.loginPasswordInputbox.sendKeys(password);
    }
    }

    @Then("^Login should pass$")
    public void login_Should_Pass() throws Exception {
        if(lp.loginButtonLoginPage.isDisplayed() && lp.loginButtonLoginPage.isEnabled()){
            lp.loginButtonLoginPage.click();
        }
        if (lp.loginSuccessUsernameDisplay.isDisplayed())
            logger.info("Login Successful");
    }
}
