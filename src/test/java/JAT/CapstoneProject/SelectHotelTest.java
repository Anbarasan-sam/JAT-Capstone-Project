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

public class SelectHotelTest {
    private WebDriver driver;
    private HomePage homePage;
    private SearchHotelPage searchHotelPage;
    private SelectHotelPage selectHotelPage;
    private BookHotelPage bookHotelPage;

    @BeforeTest(groups="Select Hotel")
    public void setUp() {
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.get("https://adactinhotelapp.com/");

        homePage = new HomePage(driver);
        searchHotelPage = new SearchHotelPage(driver);
        selectHotelPage = new SelectHotelPage(driver);
        bookHotelPage = new BookHotelPage(driver);

        homePage.userNameAndPassword("AnbarasanTest", "guvi123");
        homePage.clickLoginButton();

        searchHotelPage.selectLocation("Sydney");
        searchHotelPage.selectHotel("Hotel Creek");
        searchHotelPage.selectRoomType("Deluxe");
        searchHotelPage.selectNumberOfRooms("2");
        searchHotelPage.enterCheckInDate("2025-01-25");
        searchHotelPage.enterCheckOutDate("2025-01-30");
        searchHotelPage.selectAdultsPerRoom("2");
        searchHotelPage.selectChildrenPerRoom("1");
        searchHotelPage.clickSearch();
    }
    @Test(priority = 1,groups="Select Hotel")
    public void verifyInvalidHotelSelection() {
        selectHotelPage.clickContinue();
        Assert.assertTrue(selectHotelPage.iserrorMessageDisplay(), "Error message is not displayed");
    }
    @Test(priority = 2,groups="Select Hotel")
    public void testRedirectsToBookingPage() {
    	selectHotelPage.selectFirstHotel();
    	selectHotelPage.clickContinue();
    	
    	Assert.assertTrue(driver.getCurrentUrl().contains("BookHotel.php"), "Redirects to wrong page.");
    }
    @AfterMethod(groups="Select Hotel")
	public void takeScreenshotOnFailure(ITestResult result) {
		if(ITestResult.FAILURE == result.getStatus()) {
			ScreenshotUtil.takeScreenshot(driver, result.getName());
		}
	}
	@AfterTest(groups="Select Hotel")
	public void tearDown() {
		if(driver != null) {
			driver.quit();
		}
		
	}
}