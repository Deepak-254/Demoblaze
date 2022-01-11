package master.stepDefs;

import io.cucumber.java.en.And;
import io.cucumber.java.en.When;
import master.pageObjects.PurchasePage;
import master.utility.TestingUtils;
import org.openqa.selenium.support.PageFactory;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.time.Duration;

public class PurchaseStepdef extends BasicTest{

    private PurchasePage pp;
    private TestingUtils testutil;
    private static Logger logger = LoggerFactory.getLogger(LoginStepdef.class);

    @When("User selects category \"([^\"]*)\"$")
    public void userSelectsCategory(String category) throws Exception {
        pp = PageFactory.initElements(driver, PurchasePage.class);
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
        pp.category.click();
        testutil.waitForVisibility(driver, pp.iphone);
    }

    @And("User selects the product \"([^\"]*)\"$")
    public void userSelectsTheProduct(String product) throws Exception {
        pp.iphone.click();
        testutil.waitForVisibility(driver, pp.addToCart);
    }

    @And("User adds the product to cart")
    public void userAddsTheProductToCart() throws Exception {
        pp.addToCart.click();
        testutil.acceptAlert();
    }

    @And("User verifies the product in cart")
    public void userVerifiesTheProductInCart() throws Exception {
        pp.cartLink.click();
        testutil.waitForVisibility(driver, pp.cartPageHeading);
        if (pp.productInCart.isDisplayed()){
            logger.info("Product added to Cart with total Cart Price = " + pp.totalCartPrice.getText());
        }
        else
            logger.info("Product not added to Cart");
    }

    @And("User places the order with buyer name \"([^\"]*)\"$ and country \"([^\"]*)\"$ and city \"([^\"]*)\"$ " +
            "and credit card \"([^\"]*)\"$ and month \"([^\"]*)\"$ and year \"([^\"]*)\"$")
    public void userPlacesTheOrder(String name, String country, String city, String card, String month, String year ) throws Exception {
        testutil.waitForVisibility(driver, pp.placeOrderButton);
        if (pp.placeOrderButton.isEnabled())
            pp.placeOrderButton.click();
        else
            logger.info("Product not added to Cart");

        testutil.waitForVisibility(driver, pp.orderDialogBoxHeading);
        pp.orderUserNameInputBox.sendKeys(name);
        pp.orderCountryInputBox.sendKeys(country);
        pp.orderCityInputBox.sendKeys(city);
        pp.orderCreditCardNumberInputBox.sendKeys(card);
        pp.orderMonthInputBox.sendKeys(month);
        pp.orderYearInputBox.sendKeys(year);

        pp.orderDialogPurchaseButton.click();

    }

    @And("User verifies order success")
    public void userVerifiesOrderSuccess() throws Exception {
        testutil.waitForVisibility(driver, pp.orderSuccessAcknowledgementMessage);
        if(pp.orderSuccessAcknowledgementMessage.isDisplayed())
            logger.info("Order is Successful");
        else
            logger.info("Something went wrong. Order Failed");
    }
}
