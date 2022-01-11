package master.pageObjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class PurchasePage {
    WebDriver driver;

    public PurchasePage(WebDriver driver){
        this.driver = driver;
    }

    @FindBy(xpath = "//[@id='itemc'][text()='Phones']")
    public WebElement category;

    @FindBy(xpath = "//div[@id='tbodyid']//a[text()='Iphone 6 32gb']")
    public WebElement iphone;

    @FindBy(xpath = "//h2[text()='Iphone 6 32gb']")
    public WebElement productDetailsPageHeading;

    @FindBy(xpath = "//a[text()='Add to cart'][@onclick]")
    public WebElement addToCart;

    // click on OK button on alert after successful add to cart

    @FindBy(xpath = "//a[@id='cartur']")
    public WebElement cartLink;

    @FindBy(xpath = "//h2[text()='Products']")
    public WebElement cartPageHeading;

    @FindBy(xpath = "//*[@id='page-wrapper']//tbody[@id='tbodyid']//td[text()='Iphone 6 32gb']")
    public WebElement productInCart;

    @FindBy(xpath = "//*[@id='totalp']")
    public WebElement totalCartPrice;

    @FindBy(xpath = "//button[text()='Place Order']")
    public WebElement placeOrderButton;

    @FindBy(xpath = "//*[@id='orderModalLabel'][text()='Place order']")
    public WebElement orderDialogBoxHeading;

    @FindBy(xpath = "//*[@id='orderModal']//input[@id='name']")
    public WebElement orderUserNameInputBox;

    @FindBy(xpath = "//*[@id='orderModal']//input[@id='country']")
    public WebElement orderCountryInputBox;

    @FindBy(xpath = "//*[@id='orderModal']//input[@id='city']")
    public WebElement orderCityInputBox;

    @FindBy(xpath = "//*[@id='orderModal']//input[@id='card']")
    public WebElement orderCreditCardNumberInputBox;

    @FindBy(xpath = "//*[@id='orderModal']//input[@id='month']")
    public WebElement orderMonthInputBox;

    @FindBy(xpath = "//*[@id='orderModal']//input[@id='year']")
    public WebElement orderYearInputBox;

    @FindBy(xpath = "//*[@id='orderModal']//button[text()='Close']")
    public WebElement orderDialogCloseButton;

    @FindBy(xpath = "//*[@id='orderModal']//button[text()='Purchase'][@onclick]")
    public WebElement orderDialogPurchaseButton;

    @FindBy(xpath = "//div[contains(@class,'sweet-alert')]//*[text()='Thank you for your purchase!']")
    public WebElement orderSuccessAcknowledgementMessage;

    @FindBy(xpath = "//div[contains(@class,'sweet-alert')]//p")
    public WebElement orderConfirmationDetails;

    @FindBy(xpath = "//div[contains(@class,'sweet-alert')]//button[text()='OK']")
    public WebElement orderConfirmationOKButton;
}
