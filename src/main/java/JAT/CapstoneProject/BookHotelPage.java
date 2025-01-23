package JAT.CapstoneProject;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class BookHotelPage {

    @FindBy(id = "hotel_name_dis")
    private WebElement hotelName;

    @FindBy(id = "room_type_dis")
    private WebElement roomType;

    @FindBy(id = "price_night_dis")
    private WebElement pricePerNight;

    @FindBy(id = "first_name")
    private WebElement firstName;

    @FindBy(id = "last_name")
    private WebElement lastName;

    @FindBy(id = "address")
    private WebElement address;

    @FindBy(id = "cc_num")
    private WebElement creditCardNumber;

    @FindBy(id = "cc_type")
    private WebElement creditCardType;

    @FindBy(id = "cc_exp_month")
    private WebElement creditCardExpMonth;

    @FindBy(id = "cc_exp_year")
    private WebElement creditCardExpYear;

    @FindBy(id = "cc_cvv")
    private WebElement creditCardCVV;

    @FindBy(id = "book_now")
    private WebElement bookNowButton;

    @FindBy(id = "first_name_span")
    private WebElement firstNameError;

    @FindBy(id = "cc_num_span") 
    private WebElement creditCardError;

    @FindBy(xpath = "//td[@class='login_title']")
    private WebElement confirmationMessage;

    public BookHotelPage(WebDriver driver) {
        PageFactory.initElements(driver, this);
    }

    public String getHotelName() {
        return hotelName.getAttribute("value");
    }

    public String getRoomType() {
        return roomType.getAttribute("value");
    }

    public String getPricePerNight() {
        return pricePerNight.getAttribute("value");
    }


    public void enterFirstName(String name) {
        firstName.sendKeys(name);
    }

    public void enterLastName(String name) {
        lastName.sendKeys(name);
    }

    public void enterAddress(String addr) {
        address.sendKeys(addr);
    }

    public void enterCreditCardDetails(String cardNumber, String cardType, String expMonth, String expYear, String cvv) {
        creditCardNumber.sendKeys(cardNumber);
        creditCardType.sendKeys(cardType);
        creditCardExpMonth.sendKeys(expMonth);
        creditCardExpYear.sendKeys(expYear);
        creditCardCVV.sendKeys(cvv);
    }

    public void clickBookNow() {
        bookNowButton.click();
    }

    public boolean isFirstNameErrorDisplayed() {
        return firstNameError.isDisplayed();
    }

    public boolean isCreditCardErrorDisplayed() {
        return creditCardError.isDisplayed();
    }

    public String getConfirmationMessage() {
        return confirmationMessage.getText();
    }
}
