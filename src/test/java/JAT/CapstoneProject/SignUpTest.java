package JAT.CapstoneProject;

import org.testng.annotations.Test;
import org.testng.annotations.BeforeMethod;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.ITestResult;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;

import utils.ScreenshotUtil;


public class SignUpTest {
	private WebDriver driver;
	
	private HomePage homePage;
	
	@BeforeTest(groups="SignUp")
	public void setUp() {
		driver = new ChromeDriver();
		driver.get("https://adactinhotelapp.com/index.php");
		driver.manage().window().maximize();
		homePage = new HomePage(driver);
        
	}
	@Test(groups="SignUp")
	public void testNewUserRegisterVisibility() {
		Assert.assertTrue(homePage.isNewUserRigisterVisible(), "New user rigister is not visible.");
	}
	
	@Test(groups="SignUp")
	public void testNewUserRegisterClickability() {
		Assert.assertTrue(homePage.isNewUserRigisterClickable(), "New user rigister is not Clickable.");
	}
	
	@Test(groups="SignUp")
	public void testRedirectToRigisterPage() {
		homePage.clickNewUserRegister();
		Assert.assertTrue(driver.getCurrentUrl().contains("Register.php"), "Redirects to wrong page.");
	}
	@AfterMethod(groups="SignUp")
	public void takeScreenshotOnFailure(ITestResult result) {
		if(ITestResult.FAILURE == result.getStatus()) {
			ScreenshotUtil.takeScreenshot(driver, result.getName());
		}
	}
	@AfterTest(groups="SignUp")
	public void tearDown() {
		if(driver != null) {
			driver.quit();
		}
		
	}
}
