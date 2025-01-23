package JAT.CapstoneProject;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import utils.BaseClass;

public class MyItineraryPage extends BaseClass {
	private WebDriver driver;
	
	@FindBy(xpath="(//td[@class='welcome_menu']//a)[2]")
	private WebElement myItineraryButton;
	
	@FindBy(xpath="//td[@class='login_title']")
	private WebElement pageName;
	
	@FindBy(id="(//tr//td)[28]")
	private WebElement cancleButtonInRow;
	
	@FindBy(xpath="(//input[@class='reg_button'])[1]")
	private WebElement cancleSelectedButton;

	@FindBy(xpath="(//tr//td)[26]")
	private WebElement firstCheckBox;
	
	@FindBy(id="search_result_error")
	private WebElement bookingCancleMessage;
	
	public MyItineraryPage(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}
	
	public void clickMyItineraryButton() {
		waitForElementVisible(myItineraryButton, 10);
		myItineraryButton.isDisplayed();
		myItineraryButton.isEnabled();
		myItineraryButton.click();
	}
	
	public void clickCancleButtonInRow() {
		waitForElementVisible(cancleButtonInRow, 10);
		cancleButtonInRow.isDisplayed();
		cancleButtonInRow.isEnabled();
		cancleButtonInRow.click();
	}
	
	public void clickCancleSelected() {
		waitForElementVisible(cancleSelectedButton, 10);
		cancleSelectedButton.isDisplayed();
		cancleSelectedButton.isEnabled();
		cancleSelectedButton.click();
	}
	
	public void clickFirstCeckBox() {
		waitForElementVisible(firstCheckBox, 10);
		firstCheckBox.isDisplayed();
		firstCheckBox.isEnabled();
		firstCheckBox.click();
	}
	
	public String getPageName() {
		waitForElementVisible(pageName, 10);
		return pageName.getText();
	}
	
	public boolean getBookingCancleMessage() {
		waitForElementVisible(bookingCancleMessage, 10);
		return bookingCancleMessage.isDisplayed();
	}
}
