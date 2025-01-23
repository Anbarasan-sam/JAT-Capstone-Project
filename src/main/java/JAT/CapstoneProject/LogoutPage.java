package JAT.CapstoneProject;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import utils.BaseClass;

public class LogoutPage extends BaseClass {
	private WebDriver driver;
	
	@FindBy(xpath="(//tr//td[@class='welcome_menu']/a)[4]")
	private WebElement logoutButton;
	
	@FindBy(xpath="//td[@class='reg_success']")
	private WebElement logoutMessage;
	
	public LogoutPage(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver,this);
	}
	 public boolean isLogoutButtonVisible() {
	        waitForElementVisible(logoutButton, 10);
	        return logoutButton.isDisplayed();
	    }

	    public void clickLogoutButton() {
	        waitForElementVisible(logoutButton, 10);
	        logoutButton.click();
	    }
	    
	    public boolean logoutMessageDisplay() {
	    	waitForElementVisible(logoutMessage, 10);
	    	return logoutMessage.isDisplayed();
	    }
}
