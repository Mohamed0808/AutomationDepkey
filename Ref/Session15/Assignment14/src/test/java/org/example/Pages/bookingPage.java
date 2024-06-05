package org.example.Pages;

import org.example.stepDefs.Hooks;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import java.util.List;

public class bookingPage {
    public bookingPage()
    {
        PageFactory.initElements(Hooks.driver,this);
    }
    public static String chosenArrivalDate;
    public static String chosenDepartureDate;
    public static int bookedRoomNumber;
    public static int bookedCustomerNumber;
    @FindBy(xpath = "//*[@class=\"auto-compelete-container home\"]")
    public WebElement destinationDropDownList;
    @FindBy(xpath = "//*[@class=\"most__visited\"]//*[@class=\"result_content ng-star-inserted\"][1]")
    public WebElement MeccaDestination;
    @FindBy(xpath = "//*[@class=\"most__visited\"]//*[@class=\"result_content ng-star-inserted\"]")
    public List<WebElement> mostVisitedDestinations;
    @FindBy(xpath = "//*[@class=\"p-datepicker-group ng-tns-c89-1 ng-star-inserted\"][2]//tbody[@class=\"ng-tns-c89-1\"]//tr[3]//td[2]")
    public WebElement day10;
    @FindBy(xpath = "//*[@class=\"p-datepicker-group ng-tns-c89-1 ng-star-inserted\"][2]//tbody[@class=\"ng-tns-c89-1\"]//tr[4]//td[2]")
    public WebElement day17;
    @FindBy(xpath = "//*[@class=\"almatar-calendar__input almatar-calendar__input--departure ng-star-inserted\"]//*[@class=\"almatar-calendar__date\"]")
    public WebElement calender;
    @FindBy(xpath = "//*[@class=\"almatar-calendar__input almatar-calendar__input--return ng-star-inserted\"]//*[@class=\"almatar-calendar__date\"]")
    public WebElement leave;
    @FindBy(xpath = "//*[@class=\"dropdown__item panel-mobile-overlay\"]//span")
    public WebElement roomsDropDown;
    @FindBy(xpath = "//*[@class=\"passenger-control__button increase-1 decrement ng-star-inserted\"]")
    public WebElement addAdult;
    @FindBy(xpath = "//*[@class=\"increase-2 passenger-control__button decrement ng-star-inserted\"]")
    public List<WebElement> addChildButtons;
    @FindBy(xpath = "//*[@class=\"children-age__item\"]//*[@class=\"ng-arrow-wrapper\"]")
    public List<WebElement> childAgesListArrow;
    @FindBy(xpath = "//*[@class=\"children-age__item\"]//*[@class=\"ng-dropdown-panel-items scroll-host\"]//div//div")
    public List<WebElement> childrenAges;
    @FindBy(xpath = "//*[@class=\"edit-search-sheet__action\"]//button")
    public WebElement applyButton;
    @FindBy(xpath = "//button[@class=\"search__action\"]")
    public WebElement searchOnHotelsButton;
    @FindBy(xpath = "//button[@class=\"icrement decrement medium-font\"]")
    public WebElement addAnotherRoomButton;
    @FindBy(xpath = "//*[@class=\"dropdown__item panel-mobile-overlay\"]//span[2]")
    public WebElement roomNumberIndicator;
    @FindBy(xpath = "//*[@class=\"dropdown__item panel-mobile-overlay\"]//span[1]")
    public WebElement customerNumberIndicator;
    @FindBy(xpath = "//*[@class=\"city_name ng-star-inserted\"]")
    public List<WebElement> destinationNames;
    @FindBy(xpath = "//*[@class=\"search__item__input\"]//input")
    public WebElement destinationEntryField;
    @FindBy(xpath = "//*[@class=\"almatar-calendar__input almatar-calendar__input--departure ng-star-inserted\"]//*[@class=\"almatar-calendar__date\"]")
    public WebElement selectedArrivalDate;
    @FindBy(xpath = "//*[@class=\"almatar-calendar__input almatar-calendar__input--return ng-star-inserted\"]//*[@class=\"almatar-calendar__date\"]")
    public WebElement selectedDepartureDate;


}
