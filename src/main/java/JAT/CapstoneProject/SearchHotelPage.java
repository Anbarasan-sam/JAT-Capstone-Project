package JAT.CapstoneProject;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import utils.BaseClass;

import java.util.List;

public class SearchHotelPage extends BaseClass {

    @FindBy(id = "location")
    private WebElement locationDropdown;

    @FindBy(xpath = "//select[@id='location']/option")
    private List<WebElement> locationOptions;

    @FindBy(id = "hotels")
    private WebElement hotelsDropdown;

    @FindBy(xpath = "//select[@id='hotels']/option")
    private List<WebElement> hotelOptions;

    @FindBy(id = "room_type")
    private WebElement roomTypeDropdown;

    @FindBy(xpath = "//select[@id='room_type']/option")
    private List<WebElement> roomTypeOptions;

    @FindBy(id = "room_nos")
    private WebElement numberOfRoomsDropdown;

    @FindBy(id = "datepick_in")
    private WebElement checkInDateField;

    @FindBy(id = "datepick_out")
    private WebElement checkOutDateField;

    @FindBy(id = "adult_room")
    private WebElement adultsPerRoomDropdown;

    @FindBy(id = "child_room")
    private WebElement childrenPerRoomDropdown;

    @FindBy(id = "Submit")
    private WebElement searchButton;

    @FindBy(id = "Reset")
    private WebElement resetButton;

    public SearchHotelPage(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }

    // Method to select an option from a dropdown by text
    public void selectDropdownOption(WebElement dropdown, List<WebElement> options, String value) {
        for (WebElement option : options) {
            if (option.getText().equalsIgnoreCase(value)) {
                option.click();
                break;
            }
        }
    }

    public void selectLocation(String location) {
    	waitForElementVisible(locationDropdown, 10);
        selectDropdownOption(locationDropdown, locationOptions, location);
    }

    public void selectHotel(String hotel) {
        selectDropdownOption(hotelsDropdown, hotelOptions, hotel);
    }

    public void selectRoomType(String roomType) {
        selectDropdownOption(roomTypeDropdown, roomTypeOptions, roomType);
    }

    public void selectNumberOfRooms(String numberOfRooms) {
        numberOfRoomsDropdown.sendKeys(numberOfRooms);
    }

    public void enterCheckInDate(String checkInDate) {
        checkInDateField.clear();
        checkInDateField.sendKeys(checkInDate);
    }

    public void enterCheckOutDate(String checkOutDate) {
        checkOutDateField.clear();
        checkOutDateField.sendKeys(checkOutDate);
    }

    public void selectAdultsPerRoom(String adults) {
        adultsPerRoomDropdown.sendKeys(adults);
    }

    public void selectChildrenPerRoom(String children) {
        childrenPerRoomDropdown.sendKeys(children);
    }

    public void clickSearch() {
        searchButton.click();
    }

    public void clickReset() {
        resetButton.click();
    }

    public boolean areFieldsCleared() {
        return checkInDateField.getText().isEmpty() && checkOutDateField.getText().isEmpty();
    }
}
