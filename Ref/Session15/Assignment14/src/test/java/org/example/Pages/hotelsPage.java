package org.example.Pages;

import org.example.stepDefs.Hooks;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import java.util.List;

public class hotelsPage {
    public hotelsPage()
    {
        PageFactory.initElements(Hooks.driver,this);
    }
    @FindBy(xpath = "//*[@class=\"hotel-item ng-star-inserted\"]")
    public List<WebElement> hotelsLinks;
    @FindBy(xpath = "//*[@class=\"hotel-item ng-star-inserted\"]//*[@class=\"p-element hotel-item__name\"]")
    public List<WebElement> hotelNames;
    @FindBy(xpath = "//*[@class=\"hotel-item ng-star-inserted\"]//*[@class=\"hotel-item__prices--current ng-star-inserted\"]")
    public List<WebElement> hotelPrices;
    @FindBy(xpath = "//*[@class=\"rating ng-star-inserted\"]//*[@class=\"checkmark\"]")
    public List<WebElement> hotelRatingsCheckMark;
    @FindBy(xpath = "//*[@class=\"checkbox__rating ng-star-inserted\"]")
    public List<WebElement> hotelRatings;

    @FindBy(xpath = "//*[@class=\"sort-container ng-star-inserted\"]//*[@class=\"p-dropdown-trigger\"]")
    public WebElement sortingDropDownMenu;
    @FindBy(xpath = "//*[@class=\"sort-container ng-star-inserted\"]//*[@class=\"p-element ng-star-inserted\"]")
    public List<WebElement> sortingOptions;
}
