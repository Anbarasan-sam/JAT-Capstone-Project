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

public class BookHotelTest {

    private WebDriver driver;
    private HomePage homePage;
    private SearchHotelPage searchHotelPage;
    private SelectHotelPage selectHotelPage;
    private BookHotelPage bookHotelPage;

    @BeforeTest(groups="Book Hotel")
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
        searchHotelPage.enterCheckInDate("25/03/2025");
        searchHotelPage.enterCheckOutDate("25/03/2025");
        searchHotelPage.selectAdultsPerRoom("2");
        searchHotelPage.selectChildrenPerRoom("1");
        searchHotelPage.clickSearch();

        selectHotelPage.selectFirstHotel();
        selectHotelPage.clickContinue();
    }

    @Test(priority = 1,groups="Book Hotel")
    public void testBookingWithoutMandatoryFields() {
        bookHotelPage.clickBookNow();

        Assert.assertTrue(bookHotelPage.isFirstNameErrorDisplayed(), "First Name error should be displayed.");
        Assert.assertTrue(bookHotelPage.isCreditCardErrorDisplayed(), "Credit Card error should be displayed.");
    }

    @Test(priority = 2,groups="Book Hotel")
    public void testBookingWithValidData() throws InterruptedException {
        String hotelName = bookHotelPage.getHotelName();
        String roomType = bookHotelPage.getRoomType();
        String pricePerNight = bookHotelPage.getPricePerNight();

        Assert.assertEquals(hotelName, "Hotel Creek", "Hotel name mismatch!");
        Assert.assertEquals(roomType, "Deluxe", "Room type mismatch!");
        Assert.assertTrue(pricePerNight.startsWith("AUD"), "Price mismatch! Expected AUD currency but found: " + pricePerNight);

        bookHotelPage.enterFirstName("John");
        bookHotelPage.enterLastName("Doe");
        bookHotelPage.enterAddress("123 Test Street, Sydney");
        bookHotelPage.enterCreditCardDetails("6598325698745612", "VISA", "March", "2030", "123");
        bookHotelPage.clickBookNow();
        
        Thread.sleep(6000);
        Assert.assertEquals(bookHotelPage.getConfirmationMessage(), "Booking Confirmation", "Incorrect confirmation message.");
    }
    @AfterMethod(groups="Book Hotel")
	public void takeScreenshotOnFailure(ITestResult result) {
		if(ITestResult.FAILURE == result.getStatus()) {
			ScreenshotUtil.takeScreenshot(driver, result.getName());
		}
	}
	@AfterTest(groups="Book Hotel")
	public void tearDown() {
		if(driver != null) {
			driver.quit();
		}
		
	}
}
