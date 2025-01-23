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

public class SearchHotelTest {
    private WebDriver driver;
    private HomePage homePage;
    private SearchHotelPage searchHotelPage;

    @BeforeTest(groups="Search Hotel")
    public void setUp() {
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.get("https://adactinhotelapp.com/");

        homePage = new HomePage(driver);
        searchHotelPage = new SearchHotelPage(driver);

        homePage.userNameAndPassword("AnbarasanTest", "guvi123");
        homePage.clickLoginButton();
    }

    @Test(priority=4,groups="Search Hotel")
    public void testSearchWithAllFields() {
    	driver.navigate().back();
        searchHotelPage.selectLocation("Sydney");
        searchHotelPage.selectHotel("Hotel Creek");
        searchHotelPage.selectRoomType("Deluxe");
        searchHotelPage.selectNumberOfRooms("2");
        searchHotelPage.enterCheckInDate("2025-01-25");
        searchHotelPage.enterCheckOutDate("2025-01-30");
        searchHotelPage.selectAdultsPerRoom("2");
        searchHotelPage.selectChildrenPerRoom("1");
        searchHotelPage.clickSearch();

        Assert.assertTrue(driver.getPageSource().contains("Select Hotel"), "Search with all fields failed.");
    }

    @Test(priority=3,groups="Search Hotel")
    public void testSearchWithMandatoryFieldsOnly() {
        searchHotelPage.selectLocation("Sydney");
        searchHotelPage.enterCheckInDate("2025-01-25");
        searchHotelPage.enterCheckOutDate("2025-01-30");
        searchHotelPage.selectAdultsPerRoom("2");
        searchHotelPage.clickSearch();

        Assert.assertTrue(driver.getPageSource().contains("Select Hotel"), "Search with mandatory fields failed.");
    }

    @Test(priority=2)
    public void testInvalidDates() {
        searchHotelPage.selectLocation("Sydney");
        searchHotelPage.enterCheckInDate("2025-01-30");
        searchHotelPage.enterCheckOutDate("2025-01-25");
        searchHotelPage.selectAdultsPerRoom("2");
        searchHotelPage.clickSearch();

        Assert.assertTrue(driver.getPageSource().contains("Select Hotel"),
                "Expected to navigate to 'Select Hotel' page, but failed.");
    }

    @Test(priority=1,groups="Search Hotel")
    public void testResetButton() {
        searchHotelPage.selectLocation("Sydney");
        searchHotelPage.enterCheckInDate("2025-01-25");
        searchHotelPage.enterCheckOutDate("2025-01-30");
        searchHotelPage.selectAdultsPerRoom("2");
        searchHotelPage.clickReset();

        Assert.assertTrue(searchHotelPage.areFieldsCleared(), "Reset button failed to clear fields.");
    }
    @AfterMethod(groups="Search Hotel")
	public void takeScreenshotOnFailure(ITestResult result) {
		if(ITestResult.FAILURE == result.getStatus()) {
			ScreenshotUtil.takeScreenshot(driver, result.getName());
		}
	}
    @AfterTest(groups="Search Hotel")
    public void tearDown() {
        driver.quit();
    }
}
