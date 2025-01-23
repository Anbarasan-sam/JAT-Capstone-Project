package JAT.CapstoneProject;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.ITestResult;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import utils.ScreenshotUtil;

public class LoginTest {
	private WebDriver driver;
	private HomePage homePage;
	private LoginPage loginPage;
	
	@BeforeTest(groups="Login")
	public void setUp() {
		driver =new ChromeDriver();
		driver.manage().window().maximize();
		driver.get("https://adactinhotelapp.com/index.php");
		homePage = new HomePage(driver);
		loginPage = new LoginPage(driver);
	}
	@Test(groups="Login")
	public void testLoginButtonVisibility() {
		Assert.assertTrue(homePage.isLoginButtonVisible(), "Login button is not visible.");
	}
	@Test(groups="Login")
	public void testLoginButtonClickability() {
		Assert.assertTrue(homePage.isLoginButtonClickable(), "Login button is not clickable.");
	}
	@Test(priority=1,groups="Login")
	public void testLoginWithInValidCridentials(){
		homePage.userNameAndPassword("AnbarasanTest","12345");
		homePage.clickLoginButton();
		Assert.assertTrue(homePage.errorMessage(),"Invalid login error not displayed.");
	}
	
	@Test(priority=2,groups="Login")
	public void testLoginWithValidCridentials(){
		homePage.userNameAndPassword("AnbarasanTest","guvi123");
		homePage.clickLoginButton();
		
		Assert.assertTrue(driver.getCurrentUrl().contains("SearchHotel.php"), "Redirects to wrong page.");
		Assert.assertTrue(loginPage.isWelcomeUesrTextVisible(), "Welecome user text not shows.");
	}
	@AfterMethod(groups="Login")
	public void takeScreenshotOnFailure(ITestResult result) {
		if(ITestResult.FAILURE == result.getStatus()) {
			ScreenshotUtil.takeScreenshot(driver, result.getName());
		}
	}
	@AfterTest(groups="Login")
	public void tearDown() {
		if(driver != null) {
			driver.quit();
		}
		
	}
}
