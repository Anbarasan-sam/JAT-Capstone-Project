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

public class MyItineraryTest {

	private WebDriver driver;
	private HomePage homePage;
	private MyItineraryPage itineraryPage;

	@BeforeTest(groups="MyItinerary")
	public void setUp() {
		driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.get("https://adactinhotelapp.com/");

		homePage = new HomePage(driver);
		itineraryPage = new MyItineraryPage(driver);

		homePage.userNameAndPassword("AnbarasanTest", "guvi123");
		homePage.clickLoginButton();
	}

	@Test(priority = 1,groups="MyItinerary")
	public void testRedirectsToBookedItineraryPage() {
		itineraryPage.clickMyItineraryButton();
		Assert.assertEquals(itineraryPage.getPageName(), "Booked Itinerary", "Redirects to wrong page.");
	}

	@Test(priority = 2,groups="MyItinerary")
	public void testCancleBookingByCheckBox() {
		itineraryPage.clickFirstCeckBox();
		itineraryPage.clickCancleSelected();
		driver.switchTo().alert().accept();

		Assert.assertTrue(itineraryPage.getBookingCancleMessage(), "Booking cancled message is not displayed.");
	}

	@AfterMethod(groups="MyItinerary")
	public void takeScreenshotOnFailure(ITestResult result) {
		if (ITestResult.FAILURE == result.getStatus()) {
			ScreenshotUtil.takeScreenshot(driver, result.getName());
		}
	}

	@AfterTest(groups="MyItinerary")
	public void tearDown() {
		if (driver != null) {
			driver.quit();
		}

	}

}