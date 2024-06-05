package org.example.Pages;

import org.example.stepDefs.Hooks;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class hotelDetailsPage {
    public hotelDetailsPage() {PageFactory.initElements(Hooks.driver,this);}

    @FindBy(xpath = "//*[@class=\"almatar-calendar__input almatar-calendar__input--departure ng-star-inserted\"]//*[@class=\"almatar-calendar__date\"]")
    public WebElement arrivalDate;

    @FindBy(xpath = "//*[@class=\"almatar-calendar__input almatar-calendar__input--return ng-star-inserted\"]//*[@class=\"almatar-calendar__date\"]")
    public WebElement departureDate;

    @FindBy(xpath = "//*[@class=\"search__passengers-dropdown__info ng-star-inserted\"]//span[1]")
    public WebElement roomNumbers;

    @FindBy(xpath = "//*[@class=\"search__passengers-dropdown__info ng-star-inserted\"]")
    public WebElement customerNumbers;
    @FindBy(xpath = "//*[@class=\"slide slick-slide slick-current slick-active ng-star-inserted\"]//*[@class=\"btn btn-customize\"]")
    public WebElement continueCheckOutButton;
    @FindBy(xpath = "//*[@class=\"almatar-button almatar-button--primary\"]")
    public WebElement continuePaymentButton;
    @FindBy(xpath = "//*[@class=\"hotel-summary__content\"]")
    public WebElement reservationSummary;

}
