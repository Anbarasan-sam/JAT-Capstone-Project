package JAT.CapstoneProject;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import utils.BaseClass;

import java.util.List;

public class SelectHotelPage extends BaseClass {

    @FindBy(id= "radiobutton_0")
    private WebElement firstHotel;

    @FindBy(id = "continue")
    private WebElement continueButton;
    
    @FindBy(id="radiobutton_span")
    private WebElement errorMessage;

    public SelectHotelPage(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }
    public void clickContinue() {
        continueButton.click();
    }
    
    public void selectFirstHotel() {
    	waitForElementVisible(firstHotel, 10);
        waitForElementClickable(firstHotel, 10);
    	firstHotel.click();
    }
    
    public boolean iserrorMessageDisplay() {
    	waitForElementVisible(errorMessage, 10);
    	return errorMessage.isDisplayed();
    }

    public boolean isContinueButtonEnabled() {
        return continueButton.isEnabled();
    }
    
    
}
