package JAT.CapstoneProject;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import utils.BaseClass;

public class HomePage extends BaseClass{
	private WebDriver driver;
	
	@FindBy(id="username")
	private WebElement usernameField;

	@FindBy(id="username_span")
	private WebElement usernameFieldError;
	
	@FindBy(id="password_span")
	private WebElement passwordFieldError;
	
	@FindBy(id="password")
	private WebElement passwordField;
	
	@FindBy(id="login")
	private WebElement loginButton;
	
	@FindBy(xpath="//div[@class='auth_error']//b")
	private WebElement loginError;
	
	@FindBy(xpath="//td[@class='login_register']//a")
	private WebElement newUserRegisterButton;
	
	public HomePage(WebDriver driver) {
		this.driver=driver;
		PageFactory.initElements(driver, this);
	}
	
	public void userNameAndPassword(String username, String password) {
		waitForElementVisible(usernameField, 10);
		usernameField.isDisplayed();
		if(usernameField != null)usernameField.sendKeys(username);
		passwordField.isDisplayed();
		if(passwordField != null)passwordField.sendKeys(password);
	}
	public void clickLoginButton() {
		loginButton.isDisplayed();
		loginButton.isEnabled();
		loginButton.click();
	}
	
	public boolean isLoginButtonVisible() {
		loginButton.isDisplayed();
		loginButton.isEnabled();
		return loginButton.isDisplayed();
	}
	
	public boolean isLoginButtonClickable() {
		loginButton.isDisplayed();
		loginButton.isEnabled();
		return loginButton.isEnabled();
	}
	
	public boolean errorMessage() {
		waitForElementVisible(loginError, 10);
		return loginError.isDisplayed();
		
	}
	
	public boolean enterValidUsernameShows() {
		waitForElementVisible(usernameFieldError, 10);
		return usernameFieldError.isDisplayed();
	}
	public boolean enterValidPasswordShows() {
		waitForElementVisible(passwordFieldError, 10);
		return passwordFieldError.isDisplayed();
	}
	
	public void clickNewUserRegister() {
		newUserRegisterButton.isDisplayed();
		newUserRegisterButton.isEnabled();
		newUserRegisterButton.click();
	}
	
	public boolean isNewUserRigisterVisible() {
		waitForElementVisible(newUserRegisterButton, 10);
		
		return newUserRegisterButton.isDisplayed();
	}
	
	public boolean isNewUserRigisterClickable() {
		waitForElementVisible(newUserRegisterButton, 10);
		waitForElementClickable(newUserRegisterButton, 10);
		return newUserRegisterButton.isEnabled();
	}
	
}
